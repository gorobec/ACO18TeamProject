package controller;

import exceptions.NoSuchProductException;
import exceptions.NoSuchTicketException;
import model.Product;
import model.Ticket;

import java.util.List;
import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public interface IService {

    Map<Integer, Product> getAllProducts();

    Product getProductById(int id) throws NoSuchProductException;

    Ticket buy(String addressTo, String creditCard, List<Integer> productId);

    Ticket showTicketById(int id) throws NoSuchTicketException;

}
