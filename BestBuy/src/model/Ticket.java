package model;

import java.util.List;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class Ticket {

    private int id;
    private int productID;
    private User user;

    public Ticket() {}

    public Ticket(User user, int productID) {
        this.productID = productID;
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", productID=" + productID +
                ", adress='" + user.getAddress() + '\'' +
                ", creditCard='" + user.getCreditCard() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (productID != ticket.productID) return false;
        return user.equals(ticket.user);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productID;
        result = 31 * result + user.hashCode();
        return result;
    }
}
