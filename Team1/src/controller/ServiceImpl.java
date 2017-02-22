package controller;

import container.IDataBase;
import container.ProductDB;
import container.UserDB;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import exception.NoSuchProductException;
import model.*;
import org.apache.commons.mail.*;

import java.util.List;

/**
 * Created by SDotsenko on 19.02.2017.
 */
public class ServiceImpl implements IService {
    private IDataBase db;

    private UserDB userDB;  // added for correct sending email
    private ProductDB productDB;  // added for correct sending email

    private static final String DEFAULT_NAME = "username";
    private static final String DEFAULT_PASS = "password";
    private static final String DEFAULT_EMAIL = "lorem@gmail.com";

    public ServiceImpl(IDataBase db) {
        this.db = db;
    }

    @Override
    public boolean addProduct(Product product) {
        return db.addProduct(product);
    }

    @Override
    public boolean addTicket(Ticket ticket) {
        return db.addTicket(ticket);
    }

    @Override
    public List<Product> getProducts() {
        return db.getAllProduct();
    }

    @Override
    public Product getProductById(int id) throws InvalidIdException {
        return db.getProductByID(id);
    }

    @Override
    public Ticket getTicketById(int id) throws InvalidIdException {
        return db.getTicketByID(id);
    }

    @Override
    public int buy(int userID, int productID, Address address, BankCard creditCard) throws NoSuchProductException, InvalidInputParameters {
        if(address == null || creditCard == null)
                throw new InvalidInputParameters("Incorrect parameters");

        Ticket newTicket = new Ticket(creditCard,address,productID);

        db.addTicket(newTicket);

        User user = userDB.get(userID);

        sendEmail(user, newTicket);

        return newTicket.getId();
    }

    private boolean sendEmail(User user, Ticket ticket){
        String productName = productDB.get(ticket.getProductID()).getName();

        String msg = String.format("You bought some cool stuff in our shop!\nIt`s %s\nTicket id - %d\nThank you!",
                productName, ticket.getId());

        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(DEFAULT_NAME, DEFAULT_PASS));
            email.setSSLOnConnect(true);
            email.setFrom(DEFAULT_EMAIL);
            email.setSubject("You bought some cool stuff");
            email.setMsg(msg);
            email.addTo(user.getEmail());
            email.send();
        } catch (EmailException e){
            System.out.println("Unable to send email");
            return false;
        }

        return true;
    }

    @Override
    public Ticket showTicket(int id) throws InvalidIdException {
        return db.getTicketByID(id);
    }

    @Override
    public boolean addPoduct(Product product) {
        return db.addProduct(product);
    }
}
