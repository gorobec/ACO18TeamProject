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
 * Created by ksyashka on 07.03.2017.
 */
public class RemoveProductFromCartContext {
    public static void removeProductFromCart(HttpServer server, IStore service) {
        server.createContext("/removeProductFromCart", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                ServerUtils.getResponse(httpExchange);
                int productId = ServerUtils.getIdData(httpExchange);
                String result = "Product removed from cart";
                try {
                    service.removeProductFromCurrentTicket(productId);
                } catch (NoSuchProductException e) {
                    result = e.getMessage();
                    e.printStackTrace();
                }
                ServerUtils.sendData(httpExchange, result);
            }

        });
    }
}
