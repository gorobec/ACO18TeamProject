package tests;

import container.IDataBase;
import model.Address;
import model.Product;
import model.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhenia on 19.02.17.
 */
public class IDataBaseTest {

    private IDataBase db;

    @Before
    public void setUp(){
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

    }

    @Test
    public void removeTicketByID() throws Exception {

    }

    @Test
    public void getProductByID() throws Exception {

    }

    @Test
    public void getTicketByID() throws Exception {

    }

    @Test
    public void getAllProduct() throws Exception {

    }

}