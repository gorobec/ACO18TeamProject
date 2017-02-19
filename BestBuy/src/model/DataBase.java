package model;

import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class DataBase {

    Map<Integer, Product> products;
    Map<Integer, Ticket> tickets;

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

    public boolean addTicket(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
        return true;
    }

    public boolean addProduct(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    public int getMaxTicketID() {
        int maxKey =0;
        for (Integer me : tickets.keySet()) {

            if (me > maxKey) {
                maxKey = me;
            }
        }
        return maxKey;
    }


}
