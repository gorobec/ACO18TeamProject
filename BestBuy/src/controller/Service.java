package controller;

import exceptions.NoSuchProductException;
import exceptions.NoSuchTicketException;
import model.DataBase;
import model.Product;
import model.Ticket;

import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class Service implements IService {

    private DataBase base;

    public Service(DataBase base) {
        this.base = base;
    }

    @Override
    public Map<Integer, Product> getAllProducts() {
        return base.getProducts();
    }

    @Override
    public Product getProductById(int id) throws NoSuchProductException {
        Product pr = base.getProducts().get(id);
        if (pr == null) {
            throw new NoSuchProductException("No such product with this id" + id);
        }
        return pr;
    }

    @Override
    public Ticket buy(String addressTo, String creditCard, int productId) {

        Ticket tc = new Ticket(base.getMaxTicketID() + 1, productId, addressTo, creditCard);
        base.addTicket(tc);

        return tc;
    }

    @Override
    public Ticket showTicketById(int id) throws NoSuchTicketException {
        Ticket tc = base.getTickets().get(id);
        if (tc == null) {
            throw new NoSuchTicketException("No such ticket with this id" + id);
        }
        return tc;
    }


}
