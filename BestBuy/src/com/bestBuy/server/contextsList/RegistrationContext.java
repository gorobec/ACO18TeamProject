package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.*;
import com.bestBuy.model.User;
import com.bestBuy.server.Server;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;

/**
 * Created by Nastia on 04.03.17.
 */
public class RegistrationContext {
    public static void registration(HttpServer server, IStore service) {
        server.createContext("/registration", httpExchange -> {
            httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            User registerData = ServerUtils.getUserData(httpExchange);
            String s = "Registartion was successful";
            try (OutputStream outputStream = httpExchange.getResponseBody()) {
                try {
                    service.registerUser(registerData.getEmail(), registerData.getPassword(), registerData.getAddress(), registerData.getCreditCard());

                } catch (IllegalEmailFormatException e) {
                    s = e.getMessage();
                } catch (UserWithSuchEmailRegisteredException e) {
                    s = e.getMessage();
                } catch (IllegalPasswordFormatException e) {
                    s = e.getMessage();
                } catch (IllegalCreditCardFormatException e) {
                    s = e.getMessage();
                }
                httpExchange.sendResponseHeaders(200, s.length());
                System.out.println(s);
                outputStream.write(s.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        });
    }

}
