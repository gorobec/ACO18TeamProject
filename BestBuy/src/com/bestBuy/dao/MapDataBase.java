package com.bestBuy.dao;

import com.bestBuy.exceptions.NoSuchProductException;
import com.bestBuy.exceptions.NoSuchTicketException;
import com.bestBuy.model.Configuration;
import com.bestBuy.model.Product;
import com.bestBuy.model.Ticket;
import com.bestBuy.model.User;
import com.bestBuy.to.FileHelper;
import com.bestBuy.to.Serializer;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class MapDataBase implements IDataBase {

    private static String FILE_FOR_PRODUCTS;
    private static String FILE_FOR_TICKETS;
    private static String FILE_FOR_USERS;

    private Map<Integer, Product> products;
    private Map<Integer, Ticket> tickets;
    private Map<String, User> users;

    public MapDataBase() throws IOException {
        Properties config = Configuration.getConfig();
        FILE_FOR_PRODUCTS = config.getProperty("file_for_products");
        FILE_FOR_TICKETS = config.getProperty("file_for_tickets");
        FILE_FOR_USERS = config.getProperty("file_for_users");
    }

    public MapDataBase(Map<Integer, Product> products, Map<Integer, Ticket> tickets, Map<String, User> users) {
        this.products = products;
        this.tickets = tickets;
        this.users = users;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return tickets.put(getMaxTicketID() + 1, ticket);
    }

    @Override
    public Product addProduct(Product product) {
        int nextMaxID = getMaxProductID() + 1;
        product.setId(nextMaxID);
        return products.put(nextMaxID, product);
    }

    @Override
    public User addUser(User user) {
        return users.put(user.getEmail(), user);
    }


    @Override
    public Map<Integer, Product> getAllProducts() {
        return products;
    }

    @Override
    public boolean containsUser(String login) {
        return users.containsKey(login);
    }

    @Override
    public User getUserByLogin(String login) {
        return users.get(login);
    }

    @Override
    public String getUserPassword(String login) {
        return users.get(login).getPassword();
    }

    @Override
    public Product getProductById(int id) throws NoSuchProductException {
        Product pr = products.get(id);
        if (pr == null) {
            throw new NoSuchProductException("No such product with this id " + id);
        }
        return pr;
    }

    @Override
    public Ticket getTicketById(int id) throws NoSuchTicketException {
        Ticket ticket = tickets.get(id);
        if (ticket == null) {
            throw new NoSuchTicketException("No such ticket with this id " + id);
        }
        return ticket;
    }

    @Override
    public int getMaxTicketID() {
        return (int) tickets.values().stream().count();
    }

    @Override
    public int getMaxProductID() {
        return (int) products.values().stream().count();
    }


    @Override
    public boolean loadDatabase() {

        Serializer serializer = Serializer.getInstance();
        String jsonProduct, jsonTicket, jsonUser;

        try {
            jsonProduct = FileHelper.readFromFile(FILE_FOR_PRODUCTS);
            jsonTicket = FileHelper.readFromFile(FILE_FOR_TICKETS);
            jsonUser = FileHelper.readFromFile(FILE_FOR_USERS);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        products = serializer.convertJsonToProduct(jsonProduct);
        tickets = serializer.convertJsonToTicket(jsonTicket);
        users = serializer.convertJsonToUser(jsonUser);

        return true;
    }

    @Override
    public Stream<Product> getProductsStream() {
        return products.values().stream();
    }

    @Override
    public boolean saveDatabase() {

        products.values().stream()
                .map(product -> {
                    product.setImageUrl(null);
                    return product;
                })
                .close();

        Serializer serializer = Serializer.getInstance();

        try {
            FileHelper.writeToFile(serializer.convertObjectToJson(products), FILE_FOR_PRODUCTS);
            FileHelper.writeToFile(serializer.convertObjectToJson(tickets), FILE_FOR_TICKETS);
            FileHelper.writeToFile(serializer.convertObjectToJson(users), FILE_FOR_USERS);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean containsProductId(int productId) {
        return products.containsKey(productId);
    }

    @Override
    public List<Product> getProducts(List<Integer> productsID) {
        return productsID.stream()
                .map(product -> products.get(product))
                .collect(Collectors.toList());
    }
}
