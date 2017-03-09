package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.NoCurrentUserException;
import com.bestBuy.exceptions.NoSuchProductException;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

/**
 * Created by ksyashka on 09.03.2017.
 */
public class ClearCartContext {
    public static void clearCart(HttpServer server, IStore service) {
        server.createContext("/clearCart", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                ServerUtils.getResponse(httpExchange);
                service.clearTicketProducts();
                ServerUtils.sendData(httpExchange, "Cart is empty");
            }

        });
    }
}
