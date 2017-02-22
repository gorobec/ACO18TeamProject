package dao;

import exceptions.NoSuchProductException;
import exceptions.NoSuchTicketException;
import model.Product;
import model.Ticket;
import model.User;

import javax.xml.crypto.Data;
import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class MapDataBase implements IDataBase {

    private Map<Integer, Product> products;
    private Map<Integer, Ticket> tickets;
    private Map<String, User> users;

    public MapDataBase() {}

    public MapDataBase(Map<Integer, Product> products, Map<Integer, Ticket> tickets, Map<String, User> users) {
        this.products = products;
        this.tickets = tickets;
        this.users = users;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return tickets.put(getMaxTicketID() + 1, ticket);
    }

    @Override
    public Product addProduct(Product product) {
        return products.put(getMaxProductID() + 1, product);
    }

    @Override
    public User addUser(User user) {
        return users.put(user.getEmail(), user);
    }

    public Map<Integer, Product> getAllProducts() {
        return products;
    }

    public Map<Integer, Ticket> getAllTickets() {
        return tickets;
    }

    public Map<String, User> getAllUsers() {
        return users;
    }

    @Override
    public String allProductsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Product> e : products.entrySet()) {
            stringBuilder.append("ID : ").append(e.getKey()).append(" Product : ").append(e.getValue().toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Product getProductById(int id) throws NoSuchProductException {
        Product pr = products.get(id);
        if (pr == null) {
            throw new NoSuchProductException("No such product with this id " + id);
        }
        return pr;
    }

    @Override
    public Ticket getTicketById(int id) throws NoSuchTicketException {
        Ticket ticket = tickets.get(id);
        if (ticket == null) {
            throw new NoSuchTicketException("No such ticket with this id " + id);
        }
        return ticket;
    }

    @Override
    public int getMaxTicketID() {
        int maxKey = 0;
        for (Integer me : tickets.keySet()) {
            if (me > maxKey) {
                maxKey = me;
            }
        }
        return maxKey;
    }

    @Override
    public int getMaxProductID() {
        int maxKey = 0;
        for (Integer me : products.keySet()) {

            if (me > maxKey) {
                maxKey = me;
            }
        }
        return maxKey;
    }
}
