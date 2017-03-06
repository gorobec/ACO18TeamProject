package com.bestBuy.to;

import com.bestBuy.model.Product;
import com.bestBuy.model.Ticket;
import com.bestBuy.model.User;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class SerializerTest {
    Map<Integer, Product> productMap;
    Map<Integer, Ticket> ticketMap;
    Product product;
    Ticket ticket;
    Serializer serializer;

    @org.junit.Before
    public void setUp() throws Exception {
        productMap = new HashMap<>();
        ticketMap = new HashMap<>();
        product = new Product();
        ticket = new Ticket();
        serializer = Serializer.getInstance();

    }

    @org.junit.After
    public void tearDown() throws Exception {
        productMap = null;
        ticketMap = null;
        product = null;
        ticket = null;
        serializer = null;
    }

    @org.junit.Test
    public void testConvertProductToJson() throws Exception {
        productMap.put(0, product);
        Assert.assertNotNull(serializer.convertObjectToJson(productMap));
    }


    @org.junit.Test
    public void testConvertJsonToObject() throws Exception {
        productMap.put(0, product);
        String txt = serializer.convertObjectToJson(productMap);
        Assert.assertNotNull(serializer.convertJsonToProduct(txt));
    }

    @org.junit.Test
    public void testTicketToJson() throws Exception {
        ticketMap.put(0, ticket);
        Assert.assertNotNull(serializer.convertObjectToJson(ticketMap));
    }

    @org.junit.Test
    public void testTicketToObject() throws Exception {
        ticketMap.put(0, ticket);
        String txt = serializer.convertObjectToJson(ticketMap);
        Assert.assertNotNull(serializer.convertJsonToTicket(txt));
    }

    @org.junit.Test
    public void testTicketToObject1() throws Exception {
        Product product1 = new Product("Iron",300.0);
        Product product2 = new Product("Fish",400.0);
        User user = new User ("email", "123", "4444444444444444", "Kiev");
        Ticket ticket = new Ticket (user,1);
        ticket.addProduct(product1);
        ticket.addProduct(product2);
        ticketMap.put(0, ticket);
        String txt = serializer.convertObjectToJson(ticketMap);
        FileHelper.writeToFile(txt, "test.txt");
        Assert.assertNotNull(serializer.convertJsonToTicket(txt));
    }

}