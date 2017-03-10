package com.bestBuy.controller;

import com.bestBuy.dao.IDataBase;
import com.bestBuy.exceptions.*;
import com.bestBuy.model.Product;
import com.bestBuy.model.Ticket;
import com.bestBuy.model.User;
import com.bestBuy.to.MailSender;
import com.bestBuy.to.Validator;
import com.bestBuy.utils.Base64Utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by fmandryka on 19.02.2017.
 */

public class BestBuy implements IStore {

    private IDataBase base;

    private Map<String,User> currentSessions;

    private User currentUser;

    private Ticket currentTicket;

    public BestBuy(IDataBase base) {
        this.base = base;
        this.currentTicket = null;
    }



    @Override
    public boolean addProductToCurrentTicket(int productId) throws NoSuchProductException,NoCurrentUserException {
        if (currentUser == null) {
            throw new NoCurrentUserException("Login first!");
        }
        if (base.containsProductId(productId)) {
            return currentTicket.addProductID(productId);
        }
        return false;
    }

    @Override
    public Ticket getCurrentTicket() {
        return currentTicket;
    }


    @Override
    public Product[] showAllProducts() {
        return showProductsWithSingleImage(base.getProductsStream());
    }

    @Override
    public Product[] showAllProductsInTicket(Ticket ticket) {
        return showProductsWithSingleImage(base.getProducts(ticket.getProductsID()).stream());
    }

    @Override
    public Product removeProductFromCurrentTicket(int productId) throws NoSuchProductException{
        if (!currentTicket.removeProduct(productId));
        return base.getProductById(productId);
    }
    @Override
    public void clearTicketProducts(){
        currentTicket.getProductsID().clear();
    }

    private Product[] showProductsWithSingleImage(Stream<Product> products) {
        Product[] prodCopy = products
                .map(product ->
                {
                    String[] base64 = new String[1];
                    base64[0] = Base64Utils.getBase64URLData(product.getImageSource()[0]);
                    product.setImageUrl(base64);
                    return product;
                })
                .toArray(size -> new Product[size]);
        return prodCopy;
    }

    @Override
    public Product getProductById(int id) throws NoSuchProductException {
        Product product = base.getProductById(id);

        if (product != null) {
            String[] imageSrc = Arrays.stream(product.getImageSource()).map(productimageSrc ->
            {
                return Base64Utils.getBase64URLData(productimageSrc);
            }).toArray(size -> new String[size]);
            product.setImageUrl(imageSrc);
            return product;
        }
        return null;
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
        currentTicket = new Ticket(currentUser.getEmail());

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
        base.saveDatabase();
        return true;
    }

    @Override
    public String buy() throws TicketIsEmptyException, NoCurrentUserException, IOException {
        if (base.getProducts(currentTicket.getProductsID()).isEmpty()) {
            throw new TicketIsEmptyException("No product in ticket!");
        }
        if (currentUser == null) {
            throw new NoCurrentUserException("Login first!");
        }

        currentTicket.setId(base.getMaxTicketID() + 1);
        base.addTicket(currentTicket);
        currentUser.addToHistoryTicket(currentTicket.getId());
        base.saveDatabase();

        MailSender mailSender = MailSender.getInstance();
       try {
           mailSender.sendMail(currentTicket, this.textForBuyer());
       } catch (NoSuchProductException e){
           e.printStackTrace();
       }
        String result = currentTicket.toString();// сделать нормальную стрингу
        currentTicket = new Ticket(currentUser.getEmail());
        return result;
    }

    @Override
    public boolean loadDatabase() {
        return base.loadDatabase();
    }

    @Override
    public boolean saveDatabase() {
        return base.saveDatabase();
    }

    @Override
    public boolean addProduct(Product product) {
        Product product1 = base.addProduct(product);
        return base.getAllProducts().containsValue(product) && product1 == null;
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
            return product.toString();
        } else {
            return "product == null";
        }

    }

    public String textForBuyer() throws NoSuchProductException{
        StringBuilder sb = new StringBuilder();
        sb.append("Dear buyer,\nyour order has been sent, please wait.\nThank you\n");
        for (int i:currentTicket.getProductsID()) {
            sb.append(base.getProductById(i).toString()).append("\n");
        }
        return sb.toString();
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        this.currentTicket = new Ticket(currentUser.getEmail());
    }
}
