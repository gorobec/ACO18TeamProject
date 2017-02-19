package controller;

import model.Product;
import model.Ticket;

import java.util.List;

/**
 * Created by Игорь on 19.02.2017.
 */
public interface IDataBase {
    void addTicket(Ticket ticket);
    void addProduct(Product product);
    void removeProductByID(int id);
    void removeTicketByID(int id);
    Product getProductByID(int id);
    Ticket getTicketByID(int id);
    List<Product> getAllProduct();
}
