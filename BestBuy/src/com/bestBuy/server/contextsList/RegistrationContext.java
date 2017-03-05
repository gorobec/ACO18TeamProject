package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.*;
import com.bestBuy.model.User;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpServer;


/**
 * Created by Nastia on 04.03.17.
 */
public class RegistrationContext {
    public static void registration(HttpServer server, IStore service) {
        server.createContext("/registration", httpExchange -> {
            ServerUtils.getResponse(httpExchange);
            User registerData = ServerUtils.getUserData(httpExchange);
            String result = "Registraion was successful";
            try {
                service.registerUser(registerData.getEmail(), registerData.getPassword(), registerData.getAddress(), registerData.getCreditCard());
                service.saveDatabase();
            } catch (IllegalEmailFormatException | UserWithSuchEmailRegisteredException | IllegalCreditCardFormatException | IllegalPasswordFormatException e) {
                result = e.getMessage();
                e.printStackTrace();
            }
            ServerUtils.sendData(httpExchange, result);
        });
    }

}
