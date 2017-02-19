package controller;

import model.Product;
import model.Ticket;

import java.util.List;

/**
 * Created by Игорь on 19.02.2017.
 */
public interface IDataBase {

    boolean addTicket(Ticket ticket);
    boolean addProduct(Product product);
    boolean removeProductByID(int id);
    boolean removeTicketByID(int id);
    Product getProductByID(int id);
    Ticket getTicketByID(int id);
    List<Product> getAllProduct();
}
