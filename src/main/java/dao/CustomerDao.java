package dao;

import models.*;

import java.util.List;

/**
 * Created by Guest on 1/17/18.
 */
public interface CustomerDao {

   void add (Customer customer);

   List<Customer> getAllCustomers();
//    List<Animal> getAllAnimalsByBreed(int breedId) - may need to move to animal
//
    Customer findById(int id);
//
//
//    void update();
//
//    void deleteById();
//    void clearAllCategories();
//

}
