package controller;

import container.IDataBase;
import container.ProductDB;
import container.UserDB;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import exception.NoSuchProductException;
import model.*;
import model.Address;
import org.apache.commons.mail.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String msgStr = String.format("You bought some cool stuff in our shop!\nIt`s %s\nTicket id - %d\nThank you!",
                productName, ticket.getId());

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(DEFAULT_EMAIL, DEFAULT_PASS);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(DEFAULT_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail().toLowerCase().trim()));
            message.setSubject("You bought some cool stuff");
            message.setText(msgStr);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
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

    @Override
    public String logIn(String name, String pass) throws InvalidIdException, InvalidInputParameters{

        if(name == null || name.length() == 0)
            throw new InvalidInputParameters("Incorrect user name");

        if(pass == null || pass.length() == 0)
            throw new InvalidInputParameters("Incorrect user pass");

        return userDB.createAccessToken(new User.UserBuilder().setName(pass).setPass(pass).build());
    }

    @Override
    public String signUp(String name, String pass, String email) throws InvalidInputParameters, InvalidIdException{

        if(name == null || name.length() == 0)
            throw new InvalidInputParameters("Incorrect user name");

        if(pass == null || pass.length() == 0)
            throw new InvalidInputParameters("Incorrect user pass");

        if(email == null || email.length() == 0 || checkWithRegExp(email))
            throw new InvalidInputParameters("Incorrect user email");

        User u = new User.UserBuilder().setName(pass).setPass(pass).setEmail(email).build();

        userDB.add(u);

        return userDB.createAccessToken(u);
    }

    public static boolean checkWithRegExp(String email){
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
