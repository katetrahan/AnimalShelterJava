package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;




public class Sql2oCustomerDaoTest {

    private Sql2oCustomerDao customerDao;
    private Sql2oAnimalDao animalDao;
    private Connection conn;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        customerDao = new  Sql2oCustomerDao(sql2o);
        animalDao = new Sql2oAnimalDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingCustomersSetsId() throws Exception {
        Customer customer = setupNewCustomer();
        int originalCustomerId = customer.getId();
        customerDao.add(customer);
        assertNotEquals(originalCustomerId, customer.getId());
    }

    @Test
    public void existingCustomersCanBeFoundById() throws Exception {
        Customer customer = setupNewCustomer();
        customerDao.add(customer);
        Customer foundCustomer = customerDao.findById(customer.getId());
        assertEquals(customer,foundCustomer);
    }

    @Test
    public void addedCustomersReturnFromGetAll() throws Exception {
        Customer customer = setupNewCustomer();
        customerDao.add(customer);
        assertEquals(1,customerDao.getAllCustomers().size());
    }



    public Customer setupNewCustomer() {
        return new Customer ("Kate", "555-5555","pig", "pig");
    }

}
