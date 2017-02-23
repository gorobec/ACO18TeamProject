package controller;

import exception.*;
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

    Ticket getTicketById(int id, String token) throws InvalidIdException, UserLoginException;

    int buy(int userID, int productID, Address address, BankCard bankCard) throws NoSuchProductException, InvalidInputParameters;

    Ticket showTicket(int id, String token) throws InvalidIdException, UserLoginException;

    String logIn(String name, String pass) throws InvalidIdException, InvalidInputParameters;

    boolean signUp(String name, String pass, String email) throws InvalidInputParameters, InvalidIdException;

    User getUserByToken(String token) throws InvalidTokenException;
}