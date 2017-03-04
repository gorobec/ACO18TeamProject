package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.model.Product;
import com.bestBuy.server.Server;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by Nastia on 04.03.17.
 */
public class AddProductContext {
    public static void addProduct(HttpServer server, IStore service){
        server.createContext("/addproduct", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

                Product product = ServerUtils.getProduct(httpExchange);
                boolean added = service.addProduct(product);
                service.saveDatabase();
                try (OutputStream outputStream = httpExchange.getResponseBody()) {

                    httpExchange.sendResponseHeaders(200, String.valueOf(added).length());

                    outputStream.write(String.valueOf(added).getBytes());
                    outputStream.flush();

                }
            }
        });
    }
}
