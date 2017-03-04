package com.bestBuy.server;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.*;
import com.bestBuy.model.Product;
import com.bestBuy.model.User;
import com.bestBuy.server.contextsList.*;
import com.bestBuy.to.Serializer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Map;

import static com.bestBuy.utils.ServerUtils.getUserData;

/**
 * Created by fmandryka on 27.02.2017.
 */
public class Server {

    HttpServer server = null;

    public Server(IStore service) {
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AllProductsContext.getAllProducts(server, service);
        AddProductContext.addProduct(server, service);
        GetProductByIdContext.getProductById(server, service);
        BuyProductContext.buyProduct(server, service);
        LoginContext.login(server, service);
        RegistrationContext.registration(server, service);



        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started. Connect com.bestBuy. http://localhost:8000");
    }



}
