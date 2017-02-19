package controller;

import model.DataBase;
import model.Product;
import model.Ticket;
import org.junit.Assert;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by fmandryka on 19.02.2017.
 */
public class ServiceTest {
    Product pr1 = new Product("Iron", 1, 300.00);
    Product pr2 = new Product("Cup", 2, 100);
    Product pr3 = new Product("Phone", 3, 3000);
    Product pr4 = new Product("HDD", 4, 1000);
    Product pr5 = new Product("SSD", 5, 2000);
    Map<Integer, Product> baseProd = new HashMap<>();
    Ticket t1 = new Ticket(1, 1, "Kyiv", "4444 4444 4444 4444");
    Map<Integer, Ticket> baseTick = new HashMap<>();
    DataBase db = new DataBase(baseProd,baseTick);
    Service service;

    @Before
    public void setUp(){

        baseProd.put(pr1.getId(),pr1);
        baseProd.put(pr2.getId(),pr2);
        baseProd.put(pr3.getId(),pr3);
        baseProd.put(pr4.getId(),pr4);
        baseProd.put(pr5.getId(),pr5);
        baseTick.put(t1.getId(),t1);
        service = new Service(db);
    }

    @org.junit.Test
    public void getAllProductsTest() throws Exception {
        Assert.assertEquals(baseProd, service.getAllProducts());
    }

    @org.junit.Test
    public void getProductByIdTest() throws Exception {
        Assert.assertEquals(pr3, service.getProductById(3));
    }

    @org.junit.Test
    public void buyTest() throws Exception {

        service.buy("Kyiv","4444 4444 4444 4445",4);

//        Ticket t = new Ticket(db.getMaxTicketID(),4,"Kyiv", "4444 4444 4444 4445");

        Assert.assertNotNull(service.showTicketById(2));
    }

    @org.junit.Test
    public void showTicketByIdTest() throws Exception {
        Assert.assertEquals(t1, service.showTicketById(1));
    }

}