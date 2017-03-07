package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
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
public class AllCurrentTicketProducts {
    public static void getAllCurrentTicketProducts(HttpServer server, IStore service) {
        server.createContext("/allCurrentTicketProducts", new HttpHandler() {
            public void handle(HttpExchange httpExchange) throws IOException {
                ServerUtils.getResponse(httpExchange);
                Product[] products = service.showAllProductsInTicket(service.getCurrentTicket()); //??
                Serializer serializer = Serializer.getInstance();
                String json = serializer.convertObjectToJson(products);
                ServerUtils.sendData(httpExchange, json);
            }
        });
    }
}
