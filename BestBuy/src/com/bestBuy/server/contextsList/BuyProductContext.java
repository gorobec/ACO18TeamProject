package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.NoCurrentUserException;
import com.bestBuy.exceptions.TicketIsEmptyException;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

/**
 * Created by Nastia on 04.03.17.
 */
public class BuyProductContext {
    public static void buyProduct(HttpServer server, IStore service) {
        server.createContext("/buy", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                ServerUtils.getResponse(httpExchange);
                String result = "Thank for you order! You got mail with information";
                try {
                    service.buy();
                } catch (TicketIsEmptyException | NoCurrentUserException e) {
                    result = e.getMessage();
                }
                System.out.println(result);
                ServerUtils.sendData(httpExchange, result);
            }
        });
    }
}
