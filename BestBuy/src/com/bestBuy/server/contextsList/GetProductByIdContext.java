package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.NoSuchProductException;
import com.bestBuy.model.Product;
import com.bestBuy.to.Serializer;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

/*
 * Created by Nastia on 04.03.17.
 */
public class GetProductByIdContext {
    public static void getProductById(HttpServer server, IStore service) {
        server.createContext("/productByID", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                ServerUtils.getResponse(httpExchange);
                int productId = ServerUtils.getIdData(httpExchange);
                String json = null;
                try {
                    Product product = service.getProductById(productId);
                    Serializer serializer = Serializer.getInstance();
                    json = serializer.convertObjectToJson(product);
                } catch (NoSuchProductException e) {
                    e.printStackTrace();
                }
                ServerUtils.sendData(httpExchange, json);
            }
        });

    }
}