package dao;


import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import javax.print.DocFlavor;
import java.util.List;

public class Sql2oAnimalDao implements AnimalDao {

    private final Sql2o sql2o;

    public Sql2oAnimalDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Animal animal) {
        String sql = "INSERT INTO animals ( name, gender, type, breed, adopted) VALUES(:name, :gender, :type, :breed, :adopted)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("name", animal.getName())
                    .addParameter("gender", animal.getGender())
                    .addParameter("type", animal.getType())
                    .addParameter("breed", animal.getBreed())
                    .addParameter("adopted", animal.isAdopted())
//                    .addParameter("animalId", animal.getAnimalId())
                    .addColumnMapping("NAME", "name")
                    .addColumnMapping("GENDER", "gender")
                    .addColumnMapping("TYPE", "type")
                    .addColumnMapping("BREED", "breed")
                    .addColumnMapping("ADOPTED", "adopted")
                    .addColumnMapping("ADMITTEDAT","admittedAt")
//                    .addColumnMapping("ANIMALID", "animalId")
                    .executeUpdate()
                    .getKey();
            animal.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Animal findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
        }
    }

    @Override
    public List<Animal> getAllAnimals() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animals")
                    .executeAndFetch(Animal.class);
        }
    }

    @Override
    public void update(int id, String name, String gender, String newType, String breed){
        String sql = "UPDATE animals SET type = :type WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("type", newType)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);

        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from animals WHERE id=:id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllAnimals() {
        String sql = "DELETE from animals";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
