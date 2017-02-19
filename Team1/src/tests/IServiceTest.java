package tests;

import controller.IService;
import exception.InvalidIdException;
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
 * Created by v21k on 19.02.17.
 */
public class IServiceTest {

    private IService controller;

    @Before
    public void setUp(){
        controller.addProduct(new Product(0, "product1"));
        controller.addProduct(new Product(1, "product2"));
        controller.addProduct(new Product(2, "product3"));
        controller.addProduct(new Product(3, "product4"));

        controller.addTicket(new Ticket(0, "1111 1111", new Address("Kiev", "KPI", 1)));
        controller.addTicket(new Ticket(1, "1111 1111", new Address("Kiev", "KPI", 1)));
        controller.addTicket(new Ticket(2, "1111 1111", new Address("Kiev", "KPI", 1)));
        controller.addTicket(new Ticket(3, "1111 1111", new Address("Kiev", "KPI", 1)));
    }

    @org.junit.Test
    public void getProducts() throws Exception {
        List<Product> exp = new ArrayList<>();

        exp.add(new Product(0, "product1"));
        exp.add(new Product(1, "product2"));
        exp.add(new Product(2, "product3"));
        exp.add(new Product(3, "product4"));

        Assert.assertEquals(exp, controller.getProducts());
    }

    @org.junit.Test
    public void getProductByIdTest1() throws Exception {
        Assert.assertEquals(new Product(0, "product1"), controller.getProductById(0));
    }

    @Test(expected = InvalidIdException.class)
    public void GetProductByIdTest2() throws Exception{
        controller.getProductById(-1);
        controller.getProductById(5);
    }

    @org.junit.Test
    public void buy() throws Exception {

    }

    @org.junit.Test
    public void showTicket() throws Exception {

    }

}