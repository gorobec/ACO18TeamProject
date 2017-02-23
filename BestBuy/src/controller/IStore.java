package controller;

import exceptions.*;
import model.Ticket;

/**
 * Created by fmandryka on 19.02.2017.
 */
public interface IStore {

 //   Map<Integer, Product> getAllProducts();

  //  Product getProductById(int id) throws NoSuchProductException;
//same as addProductByIdToTicket (i cant put User Obj: how to print info about user? it must be some user ID? )
 //   Ticket buy(User user, int productId);
    // we dont need it in View
//    Ticket showTicketById(int id) throws NoSuchTicketException;
    // we dont need it in View
 //   String printTicketById(Ticket ticket);
    // we dont need it in View but i can create such button (i think- its not users" option)
 //   String printAllTickets();
    // we dont need it in View
//    String printProduct(Product product);
// button - "show all products in catalog "
    String printAllProducts();

//// button - "OK " in login Window
      boolean checkLoginAndPassword (String login, String password) throws NoSuchUserException, IllegalPasswordException;
// //button - "Apply " in Registration Window
      boolean registerUser (String email, String password, String address, String creditCard) throws IllegalEmailFormatException, UserWithSuchEmailRegisteredException,IllegalPasswordFormatException,IllegalCreditCardFormatException;

    String printTicketById(int id)  throws NoSuchTicketException;

    String printProductById(int id)  throws NoSuchProductException;


// //   create new Ticket with product ID
   Ticket addProductByIdToTicket (int productId)throws NoSuchProductException;

  boolean removeProductByIdFromTicket (int productId)throws NoSuchProductException;
    // send Ticket to DB
  boolean buy () throws TicketIsEmptyException;
  //but its impossible, we have to create TicketBuilder
// to create empy Ticket without IDproduct and then after pushing addProduct button we can add IDproduct );

    boolean loadDatabase();
    boolean saveDatabase();
}
