package controller;

import container.IDB.IDataBase;
import container.IDB.IUserDataBase;
import container.ProductDB;
import container.TicketDB;
import container.UserDB;
import exception.*;
import model.*;
import utils.MailSender;
import utils.RegEx;

import java.util.List;

/**
 * Created by SDotsenko on 19.02.2017.
 */
public class ServiceImpl implements IService {

    private IDataBase<Product> productDB;
    private IDataBase<Ticket> ticketDB;
    private IUserDataBase userDB;

    public ServiceImpl(IDataBase<Product> productDB, IDataBase<Ticket> ticketDB, IUserDataBase userDB) {
        this.userDB = userDB;
        this.productDB = productDB;
        this.ticketDB = ticketDB;
    }

    public ServiceImpl() {
        this.userDB = new UserDB();
        this.productDB = new ProductDB();
        this.ticketDB = new TicketDB();
    }

    // showAll
    @Override
    public List<Product> getProducts() {
        return productDB.getAll();
    }

    // show product by ID
    @Override
    public Product getProductById(int id) throws InvalidIdException {
        if(id < 0) throw new InvalidIdException("Id < 0");

        return productDB.get(id);
    }

    // show by ID
    @Override
    public Ticket getTicketById(int id, String token) throws InvalidIdException, UserLoginException {
        if (!userDB.isTokenExisted(token))
            throw new UserLoginException("Token not found");

        if(id < 0) throw new InvalidIdException("Id < 0");

        return ticketDB.get(id);
    }

    // for buy method in view
    @Override
    public User getUserByToken(String token) throws InvalidTokenException {
        if (token == null || token.length() == 0) throw new InvalidTokenException("Login first!");

        return userDB.getUserByToken(token);
    }

    // buy
    @Override
    public int buy(int userID, int productID, Address address, BankCard creditCard) throws NoSuchProductException, InvalidInputParameters {

        if(userID < 0 || productID < 0 || creditCard == null) throw new InvalidInputParameters("Incorrect input");

        Ticket newTicket = new Ticket(ticketDB.getAll().size() + 1, creditCard, address, productID);
        ticketDB.add(newTicket);

        User user = userDB.get(userID);
        Product product = productDB.get(newTicket.getProductID());

        if(user == null || product == null) throw new InvalidInputParameters("Incorrect input");

//        MailSender.sendEmail(user, newTicket, product);

        return newTicket.getId();
    }

    // login
    @Override
    public String logIn(String name, String pass) throws InvalidIdException, InvalidInputParameters {

        if (name == null || !name.matches(RegEx.USERNAME))
            throw new InvalidInputParameters("Incorrect user name");

        if (pass == null || pass.length() < 6)
            throw new InvalidInputParameters("Incorrect user pass");

        return userDB.createAccessToken(new User.UserBuilder().setName(name).setPass(pass).build());
    }

    // register
    @Override
    public User signUp(String name, String pass, String email) throws InvalidInputParameters, InvalidIdException {

        if (name == null || !name.matches(RegEx.USERNAME))
            throw new InvalidInputParameters("Incorrect user name");

        if (pass == null || !pass.matches(RegEx.PASSWORD))
            throw new InvalidInputParameters("Incorrect user pass");

        if (email == null || email.length() == 0 || !email.matches(RegEx.EMAIL))
            throw new InvalidInputParameters("Incorrect user email");

        User u = new User.UserBuilder().setName(name).setPass(pass).setEmail(email).build();

        return userDB.add(u) ? u : null;
    }

    // for save-load purposes
    @Override
    public IDataBase<Product> getProductDB() {
        return productDB;
    }

    @Override
    public IDataBase<Ticket> getTicketDB() {
        return ticketDB;
    }

    @Override
    public IUserDataBase getUserDB() {
        return userDB;
    }

    @Override
    public boolean addProduct(Product product) {
        return productDB.add(product);
    }

    @Override
    public boolean addTicket(Ticket ticket) {
        return ticketDB.add(ticket);
    }
}
