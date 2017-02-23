package controller;

import dao.IDataBase;
import dao.MapDataBase;
import exceptions.*;
import model.Product;
import model.Ticket;
import model.User;
import to.MapDataBaseHelper;
import to.Validator;

/**
 * Created by fmandryka on 19.02.2017.
 */

public class BestBuy implements IStore {

    private IDataBase base;

    private User currentUser;

 /*   public BestBuy(IDataBase base) {
        this.base = base;
    }*/

  /*  @Override
    public Map<Integer, Product> getAllProducts() {
        return base.getAllProducts();
    }*/

    //@Override
    public Product getProductById(int id) throws NoSuchProductException {
        return base.getProductById(id);
    }

    // @Override
    public Ticket buy(User user, int productId) {
        Ticket tc = new Ticket(user, productId);
        base.addTicket(tc);
        return tc;
    }

    // @Override
    public Ticket showTicketById(int id) throws NoSuchTicketException {
        return base.getTicketById(id);
    }


    //  @Override
    public String printAllTickets() {
        return null;
    }

    //We have to use next
    @Override
    public String printAllProducts() {
        return base.allProductsToString();
    }


    @Override
    public boolean checkLoginAndPassword(String login, String password) throws IllegalPasswordException, NoSuchUserException {

        if (!base.containsUser(login)) {
            throw new NoSuchUserException("User not found in database!");
        }
        if (!base.getUserPassword(login).equals(password)) {
            throw new IllegalPasswordException("Password not correct!");
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
        if (product != null)
            return product.toString();
        else return "product == null";
    }

    @Override
    public Ticket addProductByIdToTicket(int productId) throws NoSuchProductException {
        return null;
    }

    @Override
    public boolean removeProductByIdFromTicket(int productId) throws NoSuchProductException {
        return false;
    }

    @Override
    public boolean buy() throws TicketIsEmptyException {
        return false;
    }

    @Override
    public boolean loadDatabase() {
        MapDataBaseHelper dbHelper = new MapDataBaseHelper((MapDataBase)base);
        dbHelper.loadDataBase();
        base = dbHelper.getDb();
        return true;
    }

    @Override
    public boolean saveDatabase() {
        MapDataBaseHelper dbHelper = new MapDataBaseHelper((MapDataBase)base);
        dbHelper.unloadDataBase();
        return true;
    }

}
