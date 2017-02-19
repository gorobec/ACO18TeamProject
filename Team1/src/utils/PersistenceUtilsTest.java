package utils;

import controller.DB;
import model.Address;
import model.Product;
import model.Ticket;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class PersistenceUtilsTest {


    private String json;
    private DB db;


    @Before
    public void setUp() throws Exception {
        db = new DB();
        db.addProduct(new Product(1,"ProdName1"));
        db.addProduct(new Product(2,"ProdName2"));
        db.addProduct(new Product(1,"ProdName3"));

        db.addTicket(new Ticket(1, "credCard", new Address("kiev", "sdf", 12)));
        db.addTicket(new Ticket(2, "credCard", new Address("kiev", "sdf", 12)));
        db.addTicket(new Ticket(3, "credCard", new Address("kiev","sdf", 12)));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConvertToJson() throws Exception {
        String json = PersistenceUtils.convertToJson(db);
        System.out.println(json);
        Assert.assertNotNull(json);
    }

    @Test
    public void testConvertFromJson() throws Exception {
//        PersistenceUtils.convertFromJson(DB.class,)
    }

    @Test
    public void testSaveIntoFile() throws Exception {

    }

    @Test
    public void testLoadFromFile() throws Exception {

    }
}