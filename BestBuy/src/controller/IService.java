package controller;

import model.Product;
import model.Ticket;

import java.util.Map;

/**
 * Created by fmandryka on 19.02.2017.
 */
public interface IService {

    Map<Integer, Product> getAllProducts();

    Product getProductById(int id);

    Ticket buy(String addressTo, int creditCard, int productId);

    Ticket showTicketById(int id);

}
