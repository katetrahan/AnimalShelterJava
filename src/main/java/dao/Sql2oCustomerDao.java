package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

    public class Sql2oCustomerDao implements CustomerDao {

        private final Sql2o sql2o;

        public Sql2oCustomerDao(Sql2o sql2o) {
            this.sql2o = sql2o;
        }

        @Override
        public void add(Customer customer) {
            String sql = "INSERT INTO customer (name, phone, typePref, breedPref) VALUES (:name, :phone, :typePref, :breedPref)";
            try (Connection con = sql2o.open()) {
                int id = (int) con.createQuery(sql)
                        .bind(customer)
                        .executeUpdate()
                        .getKey();
                customer.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }

        }

        @Override
        public  List<Customer> getAllCustomers() {
            try (Connection con = sql2o.open()) {
                return con.createQuery("SELECT * FROM customer")
                        .executeAndFetch(Customer.class);

            }
        }

        @Override
        public Customer findById(int id){
            try(Connection con = sql2o.open()){
                return con.createQuery("SELECT * FROM customer WHERE id = :id")
                        .addParameter("id", id)
                        .executeAndFetchFirst(Customer.class);
            }
        }
    }

