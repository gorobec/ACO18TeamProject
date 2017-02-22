package model;

import javax.xml.crypto.Data;
import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class DataBase {

    private Map<Integer, Product> products;
    private Map<Integer, Ticket> tickets;

    public DataBase(){};
    public DataBase(Map<Integer, Product> products, Map<Integer, Ticket> tickets) {
        this.products = products;
        this.tickets = tickets;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Ticket> getTickets() {
        return tickets;
    }

    public Ticket addTicket(Ticket ticket) {
        return tickets.put(ticket.getId(), ticket);
    }

    public Product addProduct(Product product) {
        return products.put(product.getId(), product);
    }

    public int getMaxTicketID() {
        int maxKey = 0;
        for (Integer me : tickets.keySet()) {

            if (me > maxKey) {
                maxKey = me;
            }
        }
        return maxKey;
    }


}
