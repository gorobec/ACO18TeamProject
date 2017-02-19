package tests;

import controller.DB;
import controller.IDataBase;
import model.Address;
import model.Product;
import model.Ticket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhenia on 19.02.17.
 */
public class IDataBaseTest {

    private IDataBase db;

    @Before
    public void setUp(){
        db = new DB();

        db.addProduct(new Product(0, "product1"));
        db.addProduct(new Product(1, "product2"));
        db.addProduct(new Product(2, "product3"));
        db.addProduct(new Product(3, "product4"));

        db.addTicket(new Ticket(0, "1111 1111", new Address("Kiev", "KPI", 1)));
        db.addTicket(new Ticket(1, "1111 1111", new Address("Kiev", "KPI", 1)));
        db.addTicket(new Ticket(2, "1111 1111", new Address("Kiev", "KPI", 1)));
        db.addTicket(new Ticket(3, "1111 1111", new Address("Kiev", "KPI", 1)));
    }

    @Test
    public void removeProductByID() throws Exception {
        Assert.assertTrue(db.removeProductByID(0));

        List<Product> exp = new ArrayList<>();

        exp.add(new Product(1, "product2"));
        exp.add(new Product(2, "product3"));
        exp.add(new Product(3, "product4"));

        Assert.assertEquals(exp, db.getAllProduct());
    }

    @Test
    public void removeTicketByID() throws Exception {
        Assert.assertTrue(db.removeTicketByID(0));

        Assert.assertNull(db.getTicketByID(0));
    }

    @Test
    public void getProductByID() throws Exception {
        Assert.assertEquals(new Product(0, "product1"), db.getProductByID(0));
        Assert.assertNull(db.getProductByID(7));
        Assert.assertNull(db.getProductByID(-1));
    }

    @Test
    public void getTicketByID() throws Exception {
        Assert.assertEquals(new Ticket(0, "1111 1111", new Address("Kiev", "KPI", 1)), db.getTicketByID(0));
    }

    @Test
    public void getProducts() throws Exception {
        List<Product> exp = new ArrayList<>();

        exp.add(new Product(0, "product1"));
        exp.add(new Product(1, "product2"));
        exp.add(new Product(2, "product3"));
        exp.add(new Product(3, "product4"));

        Assert.assertEquals(exp, db.getAllProduct());
    }

}