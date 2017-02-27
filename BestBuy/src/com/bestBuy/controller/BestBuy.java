package com.bestBuy.controller;

import com.bestBuy.dao.IDataBase;
import com.bestBuy.exceptions.*;
import com.bestBuy.model.Product;
import com.bestBuy.model.Ticket;
import com.bestBuy.model.User;
import com.bestBuy.to.MailSender;
import com.bestBuy.to.Validator;

import java.io.IOException;

/**
 * Created by fmandryka on 19.02.2017.
 */

public class BestBuy implements IStore {

    private IDataBase base;

    private User currentUser;

    private int chosenProductId;

    public BestBuy(IDataBase base) {
        this.base = base;
    }

    @Override
    public String printAllProducts() {
        return base.allProductsToString();
    }

    @Override
    public boolean checkLoginAndPassword(String login, String password) throws IncorrectPasswordException, NoSuchUserException {

        if (!base.containsUser(login)) {
            throw new NoSuchUserException("User not found in database!");
        }
        if (!base.getUserPassword(login).equals(password)) {
            throw new IncorrectPasswordException("Password not correct!");
        }

        currentUser = base.getUserByLogin(login);

        return true;
    }

    @Override
    public boolean registerUser(String email, String password, String address, String creditCard) throws IllegalPasswordFormatException, IllegalEmailFormatException, UserWithSuchEmailRegisteredException, IllegalCreditCardFormatException {

        if (!Validator.validEmail(email)) {
            throw new IllegalEmailFormatException("Email format is invalid!");
        }
        if (base.containsUser(email)) {
            throw new UserWithSuchEmailRegisteredException("User with such email alresdy exists");
        }
        if (!Validator.validPassword(password)) {
            throw new IllegalPasswordFormatException("Password should contains only a-Z, 0-9, _ . Length 6-30 characters!");
        }
        if (!Validator.validCreditCard(creditCard)) {
            throw new IllegalCreditCardFormatException("Credit card is not valid!");
        }

        base.addUser(new User(email, password, creditCard, address));

        return true;
    }

    @Override
    public String printTicketById(int id) throws NoSuchTicketException {
        Ticket ticket = base.getTicketById(id);
        if (ticket != null)
            return ticket.toString();
        else return "ticket == null";
    }

    @Override
    public String printProductById(int id) throws NoSuchProductException {
        Product product = base.getProductById(id);
        if (product != null) {
            chosenProductId = id;
            return product.toString();
        } else {
            chosenProductId = -1;
            return "product == null";
        }

    }

    @Override
    public String buy() throws TicketIsEmptyException, IOException {
        if (chosenProductId < 0) {
            throw new TicketIsEmptyException("No product in ticket!");
        }
        Ticket ticket = new Ticket(base.getMaxTicketID()+1, currentUser, chosenProductId);
        base.addTicket(ticket);

        MailSender mailSender = new MailSender();
        mailSender.sendMail(ticket);
        return ticket.toString();
    }

    @Override
    public boolean loadDatabase() {
        return base.loadDatabase();
    }

    @Override
    public boolean saveDatabase() {
        return base.saveDatabase();
    }

}
