package controller;

import exception.InvalidIdException;
import exception.NoSuchProductException;
import model.Address;
import model.Product;
import model.Ticket;

import java.util.List;

/**
 * Created by v21k on 19.02.17.
 */
public interface IService {
    boolean addProduct(Product product);

    boolean addTicket(Ticket ticket);

    List<Product> getProducts();

    Product getProductById(int id) throws InvalidIdException;

    Ticket getTicketById(int id) throws InvalidIdException;

    boolean buy(int productID, Address address, String creditCard) throws NoSuchProductException;

    Ticket showTicket(int id) throws InvalidIdException;

    boolean addPoduct(Product product);

}
