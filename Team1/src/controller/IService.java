package controller;

import exception.InvalidIdException;
import exception.InvalidInputParameters;
import exception.NoSuchProductException;
import model.*;

import java.security.SecureRandom;
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

    int buy(int userID, int productID, Address address, BankCard bankCard) throws NoSuchProductException, InvalidInputParameters;

    Ticket showTicket(int id) throws InvalidIdException;

    boolean addPoduct(Product product);

    String logIn(String name, String pass) throws InvalidIdException, InvalidInputParameters;

    String signUp(String name, String pass, String email) throws InvalidInputParameters, InvalidIdException;
}