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
import java.io.OutputStream;
import java.util.Arrays;

import static com.bestBuy.utils.ServerUtils.getUserData;

/**
 * Created by Nastia on 04.03.17.
 */
public class LoginContext {
    public static void login(HttpServer server, IStore service){
        server.createContext("/login", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

                User userData = ServerUtils.getUserData(httpExchange);
                String s = "login was successful";
                try (OutputStream outputStream = httpExchange.getResponseBody()) {
                    try {
                        service.checkLoginAndPassword(userData.getEmail(), userData.getPassword());

                    } catch (NoSuchUserException e) {
                        s = e.getMessage();
                    } catch (IncorrectPasswordException e) {
                        s = e.getMessage();
                    }
                    httpExchange.sendResponseHeaders(200, s.length());
                    System.out.println(s);
                    outputStream.write(s.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
            }
        });

    }
}
