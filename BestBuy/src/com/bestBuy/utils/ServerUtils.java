package com.bestBuy.utils;

import com.bestBuy.model.Product;
import com.bestBuy.model.User;
import com.bestBuy.to.Serializer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by Nastia on 04.03.17.
 */
public class ServerUtils {
    public static int getIdData(HttpExchange httpExchange) throws IOException {
        InputStream is = httpExchange.getRequestBody();
        StringBuilder sb = new StringBuilder();

        String input = "";
        int read = -1;
        while ((read = is.read()) != -1) {
            input += (char) read;
        }

        Serializer ser = Serializer.getInstance();
        Map<String, Integer> map = ser.convertJsonIDToObject(input);
        return Integer.valueOf(map.get("id"));
    }

    public static User getUserData(HttpExchange httpExchange) throws IOException {
        InputStream is = httpExchange.getRequestBody();
        StringBuilder sb = new StringBuilder();

        String input = "";
        int read = -1;
        while ((read = is.read()) != -1) {
            input += (char) read;
        }
        input = input.replace("[", "{").replace("]", "}").replace("\\", "");
        Serializer ser = Serializer.getInstance();
        User user = ser.convertJsonToSingleUser(input);
        return user;
    }

    public static Product getProduct(HttpExchange httpExchange) throws IOException {
        InputStream is = httpExchange.getRequestBody();

        Product product = new Product();


        String input = "";
        int read = -1;
        while ((read = is.read()) != -1) {
            input += (char) read;
        }

        Serializer ser = Serializer.getInstance();
        product = ser.convertJsonToProductType(input);
        return product;
    }
}
