package controller;

import container.IDB.IDataBase;
import container.IDB.IUserDataBase;
import exception.*;
import model.*;

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

    String logIn(String name, String pass) throws InvalidIdException, InvalidInputParameters;

    User signUp(String name, String pass, String email) throws InvalidInputParameters, InvalidIdException;

    User getUserByToken(String token) throws InvalidTokenException;

    // for saving
    IDataBase<Product> getProductDB();

    IDataBase<Ticket> getTicketDB();

    IUserDataBase getUserDB();


}