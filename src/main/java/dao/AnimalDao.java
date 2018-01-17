package dao;

import models.*;

import java.util.List;

public interface AnimalDao {

    //create

    void add (Animal animal);

    //read - list in chronological order

    Animal findById(int id);

    List<Animal> getAllAnimals();


    //update
    void update(int id, String name, String gender, String type, String breed);

    //delete
    void deleteById(int id);
    void clearAllAnimals();


}
