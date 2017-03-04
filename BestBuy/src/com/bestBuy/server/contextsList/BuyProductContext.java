package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.NoCurrentUserException;
import com.bestBuy.exceptions.TicketIsEmptyException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by Nastia on 04.03.17.
 */
public class BuyProductContext {
    public static void buyProduct(HttpServer server, IStore service){
        server.createContext("/buy", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
                String result = "Thank for you order! You got mail with information";
                try (OutputStream outputStream = httpExchange.getResponseBody()) {
                    try {
                        service.buy();
                    }catch (TicketIsEmptyException e){
                        result = e.getMessage();
                    }catch (NoCurrentUserException e){
                        result = e.getMessage();
                    }
                    httpExchange.sendResponseHeaders(200, result.length());
                    outputStream.write(result.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }

            }
        });
    }
}
