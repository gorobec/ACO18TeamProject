package com.bestBuy.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class Ticket {

    private int id;
    private Map<Integer, Product> products = new HashMap<>();
    private User user;

    public Ticket() {
    }

    public Ticket(User user) {
        this.user = user;
    }

    public Ticket(User user, int id) {
        this.id = id;
        this.user = user;
    }

    public Ticket(int id, Map<Integer, Product> products, User user) {
        this.id = id;
        this.products = products;
        this.user = user;
    }

    public Product addProduct(Product product) {
        return products.put(getMaxProductID() + 1, product);
    }


    public Map<Integer, Product> getProducts() {
        return products;
    }

    public int getMaxProductID() {
        return (int) products.values().stream().count();
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


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", products=" + products +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Ticket ticket = (Ticket) object;

        if (id != ticket.id) return false;
        if (products != null ? !products.equals(ticket.products) : ticket.products != null) return false;
        return user.equals(ticket.user);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + user.hashCode();
        return result;
    }

}
