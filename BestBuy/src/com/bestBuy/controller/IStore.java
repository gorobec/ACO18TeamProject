package com.bestBuy.controller;

import com.bestBuy.exceptions.*;
import com.bestBuy.model.Product;
import com.bestBuy.model.Ticket;
import com.bestBuy.model.User;

import java.io.IOException;

/**
 * Created by fmandryka on 19.02.2017.
 */
public interface IStore {

    // button - "show all products in catalog "
    Product[] showAllProducts();
    Product getProductById(int id) throws NoSuchProductException ;

    void setCurrentUser(User currentUser);
    // button - "OK " in login Window
    boolean checkLoginAndPassword(String login, String password) throws NoSuchUserException, IncorrectPasswordException;

    //button - "Apply " in Registration Window
    boolean registerUser(String email, String password, String address, String creditCard) throws IllegalEmailFormatException, UserWithSuchEmailRegisteredException, IllegalPasswordFormatException, IllegalCreditCardFormatException;

    String printTicketById(int id) throws NoSuchTicketException;

    String printProductById(int id) throws NoSuchProductException;

    // send Ticket com.bestBuy.to DB
    String buy() throws TicketIsEmptyException, IOException;

    boolean loadDatabase();

    boolean saveDatabase();

    // //   create new Ticket with product ID
//    Ticket addProductByIdToTicket(int productId) throws NoSuchProductException;

//    boolean removeProductByIdFromTicket(int productId) throws NoSuchProductException;
}