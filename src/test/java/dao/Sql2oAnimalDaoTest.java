package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Guest on 1/17/18.
 */
public class Sql2oAnimalDaoTest {

    private Sql2oAnimalDao animalDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        animalDao = new Sql2oAnimalDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingAnimalSetsId() throws Exception {
        Animal animal = setupNewAnimal();
        int originalAnimalId = animal.getId();
        animalDao.add(animal);
        assertNotEquals(originalAnimalId, animal.getId());
    }

    @Test
    public void existingAnimalsCanBeFoundById() throws Exception {
        Animal animal = setupNewAnimal();
        animalDao.add(animal);
        Animal foundAnimal = animalDao.findById(animal.getId());
        assertEquals(animal, foundAnimal);
    }

    @Test
    public void addedAnimalGetsReturnedFromGetAll() throws Exception {
        Animal animal = setupNewAnimal();
        animalDao.add(animal);
        assertEquals(1, animalDao.getAllAnimals().size());
    }

    @Test
    public void noAnimalsReturnsEmptyList() throws Exception {
        assertEquals(0, animalDao.getAllAnimals().size());
    }

    @Test
    public void updateChangesAnimalContent() throws Exception {
        String initialType = "pig";
        Animal animal = new Animal("kate", "female", initialType, "spanial");
        animalDao.add(animal);

        animalDao.update(animal.getId(),"kate", "female", "dog", "spanial");
        Animal updatedAnimal = animalDao.findById(animal.getId());
        assertNotEquals(initialType, updatedAnimal.getType());
    }

    @Test
    public void deletesByIdDeletesCorrectAnimal() throws Exception {
        Animal animal = setupNewAnimal();
        animalDao.add(animal);
        animalDao.deleteById(animal.getId());
        assertEquals(0, animalDao.getAllAnimals().size());
    }

    @Test
    public void clearsAllAnimals() throws Exception {
        Animal animal = setupNewAnimal();
        Animal otherAnimal = setupNewAnimal();
        animalDao.add(animal);
        animalDao.add(otherAnimal);
        int animalDaoSize = animalDao.getAllAnimals().size();
        animalDao.clearAllAnimals();
        assertTrue(animalDaoSize > 0 && animalDaoSize > animalDao.getAllAnimals().size());
    }







    public Animal setupNewAnimal() {
        return new Animal("Luna", "Female", "canine", "pekenese");
    }

}