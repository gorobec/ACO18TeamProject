package controller;

import exceptions.NoSuchProductException;
import exceptions.NoSuchTicketException;
import model.Product;
import model.Ticket;
import model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public interface IStore {

    Map<Integer, Product> getAllProducts();

    Product getProductById(int id) throws NoSuchProductException;

    Ticket buy(User user, int productId);

    Ticket showTicketById(int id) throws NoSuchTicketException;

    String printTicketById(Ticket ticket);

    String printAllTickets();

    String printProduct(Product product);

    String printAllProducts();
}
