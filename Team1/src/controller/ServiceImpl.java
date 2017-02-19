package controller;

import exception.InvalidIdException;
import exception.NoSuchProductException;
import model.Address;
import model.Product;
import model.Ticket;

import java.util.List;

/**
 * Created by SDotsenko on 19.02.2017.
 */
public class ServiceImpl implements IService {
    private  IDataBase db;

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
    public int buy(int productID, Address address, String creditCard) throws NoSuchProductException {
        if(address == null || creditCard == null) {
            try {
                throw new InvalidInputParameters("Incorrect parameters");
            } catch (InvalidInputParameters invalidInputParameters) {
                invalidInputParameters.printStackTrace();
            }
        }

        Ticket newTicket = new Ticket(creditCard,address,productID);

        db.addTicket(newTicket);

        return newTicket.getId();
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
