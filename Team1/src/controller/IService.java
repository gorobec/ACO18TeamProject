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
    Product addProduct(Product product);
    List<Product> getProducts();
    Product getProductById(int id) throws InvalidIdException;
    Ticket buy(Product product, Address address, String creditCard) throws NoSuchProductException;
    Ticket showTicket(int id) throws InvalidIdException;
}
