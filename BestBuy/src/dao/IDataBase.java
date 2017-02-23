package dao;

import exceptions.NoSuchProductException;
import exceptions.NoSuchTicketException;
import model.Product;
import model.Ticket;
import model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 21.02.2017.
 */
public interface IDataBase {

  //  Map<Integer, Product> getAllProducts();

 //   Map<Integer, Ticket> getAllTickets();

    String allProductsToString();

    Product getProductById(int id) throws NoSuchProductException;

    Ticket getTicketById(int id) throws NoSuchTicketException;

    Ticket addTicket(Ticket ticket);

    Product addProduct(Product product);

    User addUser(User user);

    int getMaxTicketID();

    int getMaxProductID();
}
