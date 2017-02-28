package com.bestBuy.dao;

import com.bestBuy.exceptions.NoSuchProductException;
import com.bestBuy.exceptions.NoSuchTicketException;
import com.bestBuy.model.Product;
import com.bestBuy.model.Ticket;
import com.bestBuy.model.User;

import java.util.Map;


/**
 * Created by Администратор on 21.02.2017.
 */
public interface IDataBase {

    Map<Integer, Product> getAllProducts();

 //   Map<Integer, Ticket> getAllTickets();

    boolean containsUser(String login);

    User getUserByLogin(String login);

    String getUserPassword(String login);

    Product getProductById(int id) throws NoSuchProductException;

    Ticket getTicketById(int id) throws NoSuchTicketException;

    Ticket addTicket(Ticket ticket);

    Product addProduct(Product product);

    User addUser(User user);

    int getMaxTicketID();

    int getMaxProductID();

    boolean loadDatabase();
    boolean saveDatabase();
}
