package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.NoCurrentUserException;
import com.bestBuy.exceptions.NoSuchProductException;
import com.bestBuy.exceptions.TicketIsEmptyException;
import com.bestBuy.model.Product;
import com.bestBuy.to.Serializer;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

/**
 * Created by ksyashka on 06.03.2017.
 */
public class AddProductToCartContext {
    public static void addProductToCart(HttpServer server, IStore service) {
        server.createContext("/addProductToCart", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                ServerUtils.getResponse(httpExchange);
                int productId = ServerUtils.getIdData(httpExchange);
                String result = "Product added to cart";
                try {
                    service.addProductToCurrentTicket(productId);
                } catch (NoSuchProductException | NoCurrentUserException e) {
                    result = e.getMessage();
                    e.printStackTrace();
                }
                ServerUtils.sendData(httpExchange, result);
            }

        });
    }
}
