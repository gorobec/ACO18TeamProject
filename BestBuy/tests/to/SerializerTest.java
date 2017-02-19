package to;

import model.Product;
import model.Ticket;
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
        serializer = new Serializer();
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
        Assert.assertNotNull(serializer.convertProductToJson(productMap));
    }



    @org.junit.Test
    public void testConvertJsonToObject() throws Exception {
        productMap.put(0, product);
        String txt = serializer.convertProductToJson(productMap);
        Assert.assertNotNull(serializer.convertJsonToObject(txt));
    }

    @org.junit.Test
    public void testTicketToJson() throws Exception {
        ticketMap.put(0, ticket);
        Assert.assertNotNull(serializer.ticketToJson(ticketMap));
    }

    @org.junit.Test
    public void testTicketToObject() throws Exception {
        ticketMap.put(0, ticket);
        String txt = serializer.ticketToJson(ticketMap);
        Assert.assertNotNull(serializer.ticketToObject(txt));
    }

}