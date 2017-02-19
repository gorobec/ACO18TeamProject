package controller;

import model.Product;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 19.02.2017.
 */
public class DB implements IDataBase {
    private List<Product> products = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public DB() {
    }

    @Override
    public boolean addTicket(Ticket ticket){
        tickets.add(ticket);
        return true;
    }

    @Override
    public boolean addProduct(Product product) {
        products.add(product);
        return true;
    }

    @Override
    public boolean removeProductByID(int id) {
        products.remove(findProuctById(id));
        return true;
    }

    @Override
    public boolean removeTicketByID(int id) {
         tickets.remove(findTicketById(id));
         return true;
    }

    @Override
    public Product getProductByID(int id) {
        return products.get(findProuctById(id));
    }

    @Override
    public Ticket getTicketByID(int id) {
        return tickets.get(findTicketById(id));
    }

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

    private int findTicketById(int id){
        for (int i = 0; i < tickets.size(); i++) {
            if (products.get(i).getId() == id) return i;
        }
        return -1;
    }
    private int findProuctById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) return i;
        }
        return -1;
    }
}
