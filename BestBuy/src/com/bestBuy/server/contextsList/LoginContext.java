package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.IncorrectPasswordException;
import com.bestBuy.exceptions.NoSuchUserException;
import com.bestBuy.model.User;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;


/**
 * Created by Nastia on 04.03.17.
 */
public class LoginContext {
    public static void login(HttpServer server, IStore service) {
        server.createContext("/login", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                ServerUtils.getResponse(httpExchange);
                User userData = ServerUtils.getUserData(httpExchange);
                String result = "login was successful";
                try {
                    service.checkLoginAndPassword(userData.getEmail(), userData.getPassword());

                } catch (NoSuchUserException | IncorrectPasswordException e) {
                    result = e.getMessage();
                    e.printStackTrace();
                }
                ServerUtils.sendData(httpExchange, result);

            }
        });

    }
}
