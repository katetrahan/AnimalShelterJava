package models;

import java.time.LocalDateTime;

/**
 * Created by Guest on 1/17/18.
 */
public class Animal {

    private String name;
    private String gender;
    private LocalDateTime admittedAt;
    private String type;
    private String breed;
    private boolean adopted;
    private int id;
    private int animalId;


    public Animal(String name, String gender, String type, String breed) { // int animalId
        this.name = name;
        this.gender = gender;
        this.admittedAt = LocalDateTime.now();
        this.type = type;
        this.breed = breed;
        this.adopted = false;
        this.animalId = animalId;

    }

//    public int getAnimalId() {
//        return animalId;
//    }
//
//    public void setAnimalId(int animalId) {
//        this.animalId = animalId;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getAdmittedAt() {
        return admittedAt;
    }

    public void setAdmittedAt(LocalDateTime admittedAt) {
        this.admittedAt = admittedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (adopted != animal.adopted) return false;
        if (id != animal.id) return false;
        if (!name.equals(animal.name)) return false;
        if (!gender.equals(animal.gender)) return false;
//        if (admittedAt != null ? !admittedAt.equals(animal.admittedAt) : animal.admittedAt != null) return false;
        if (!type.equals(animal.type)) return false;
        return breed.equals(animal.breed);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + (admittedAt != null ? admittedAt.hashCode() : 0);
        result = 31 * result + type.hashCode();
        result = 31 * result + breed.hashCode();
        result = 31 * result + (adopted ? 1 : 0);
        result = 31 * result + id;
        return result;
    }
}
