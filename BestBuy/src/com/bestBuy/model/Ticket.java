package com.bestBuy.model;

import java.util.*;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class Ticket {

    private int id;
    private List<Integer> productsID;
    private String email;
    private Calendar dateTimeOfCommit;

    public Ticket() {
        productsID = new ArrayList<>();
    }

    public Ticket(String email) {
        this.email = email;
        productsID = new ArrayList<>();
    }

    public Ticket(String email, int id) {
        this.id = id;
        this.email = email;
        productsID = new ArrayList<>();
    }

    public boolean addProductID(int productID) {
        return productsID.add(productID);
    }

    public List<Integer> getProductsID() {
        return productsID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUserEmail() {
        return email;
    }

    public Calendar getDateTimeOfCommit() {
        return dateTimeOfCommit;
    }

    public void setDateTimeOfCommit(Calendar dateTimeOfCommit) {
        this.dateTimeOfCommit = dateTimeOfCommit;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", products=" + productsID +
                ", user=" + email +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Ticket ticket = (Ticket) object;

        if (id != ticket.id) return false;
        if (productsID != null ? !productsID.equals(ticket.productsID) : ticket.productsID != null) return false;
        return email.equals(ticket.email);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productsID != null ? productsID.hashCode() : 0);
        result = 31 * result + email.hashCode();
        return result;
    }

}
