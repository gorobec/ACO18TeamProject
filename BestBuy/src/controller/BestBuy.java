package controller;

import dao.IDataBase;
import exceptions.NoSuchProductException;
import exceptions.NoSuchTicketException;
import dao.MapDataBase;
import model.Product;
import model.Ticket;
import model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class BestBuy implements IStore {

    private IDataBase base;

    public BestBuy(IDataBase base) {
        this.base = base;
    }

    @Override
    public Map<Integer, Product> getAllProducts() {
        return base.getAllProducts();
    }

    @Override
    public Product getProductById(int id) throws NoSuchProductException {
        return base.getProductById(id);
    }

    @Override
    public Ticket buy(User user, int productId) {
        Ticket tc = new Ticket(user, productId);
        base.addTicket(tc);
        return tc;
    }

    @Override
    public Ticket showTicketById(int id) throws NoSuchTicketException {
        return base.getTicketById(id);
    }

    @Override
    public String printTicketById(Ticket ticket) {
        if (ticket != null)
            return ticket.toString();
        else return "product == null";
    }

    @Override
    public String printAllTickets() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Ticket> e : base.getAllTickets().entrySet()) {
            stringBuilder.append("ID : " + e.getKey() + " Ticket : " + e.getValue().toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String printProduct(Product product) {
        if (product != null)
            return product.toString();
        else return "product == null";
    }
    @Override
    public String printAllProducts() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Product> e : base.getAllProducts().entrySet()) {
            stringBuilder.append("ID : " + e.getKey() + " Product : " + e.getValue().toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}
