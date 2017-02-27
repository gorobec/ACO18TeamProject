package com.bestBuy.to;

import com.bestBuy.model.Product;
import com.bestBuy.model.Ticket;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class SerializerTest {
    Map<Integer, Product> productMap;
    Map<Integer, Ticket> ticketMap;
    Product product;
    Ticket ticket;
    Serializer<Integer,Product> serProduct;
    Serializer<Integer,Ticket> serTicket;

    @org.junit.Before
    public void setUp() throws Exception {
        productMap = new HashMap<>();
        ticketMap = new HashMap<>();
        product = new Product();
        ticket = new Ticket();
        serProduct = new Serializer<>();
        serTicket = new Serializer<>();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        productMap = null;
        ticketMap = null;
        product = null;
        ticket = null;
        serProduct = null;
        serTicket = null;
    }

    @org.junit.Test
    public void testConvertProductToJson() throws Exception {
        productMap.put(0, product);
        Assert.assertNotNull(serProduct.convertObjectToJson(productMap));
    }


    @org.junit.Test
    public void testConvertJsonToObject() throws Exception {
        productMap.put(0, product);
        String txt = serProduct.convertObjectToJson(productMap);
        Assert.assertNotNull(serProduct.convertJsonToProduct(txt));
    }

    @org.junit.Test
    public void testTicketToJson() throws Exception {
        ticketMap.put(0, ticket);
        Assert.assertNotNull(serTicket.convertObjectToJson(ticketMap));
    }

    @org.junit.Test
    public void testTicketToObject() throws Exception {
        ticketMap.put(0, ticket);
        String txt = serTicket.convertObjectToJson(ticketMap);
        Assert.assertNotNull(serTicket.convertJsonToTicket(txt));
    }

}