package controller;

import dao.IDataBase;
import exceptions.NoSuchProductException;
import exceptions.NoSuchTicketException;
import dao.MapDataBase;
import exceptions.TicketIsEmptyException;
import model.Product;
import model.Ticket;
import model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class BestBuy implements IStore {

    private IDataBase base;

    public BestBuy(IDataBase base) {
        this.base = base;
    }

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

    //@Override
    public String printTicketById(Ticket ticket) {
        if (ticket != null)
            return ticket.toString();
        else return "product == null";
    }

  //  @Override
    public String printAllTickets() {
    return null;
    }


    public String printProduct(Product product) {
        if (product != null)
            return product.toString();
        else return "product == null";
    }


    //We have to use next
    @Override
    public String printAllProducts() {
        return base.allProductsToString();
    }

    @Override
    public boolean checkLoginAndPassword(String login, String password) {
        return true;
    }

    @Override
    public boolean registerUser(String email, String password, String address, int creditCard) {
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

}
