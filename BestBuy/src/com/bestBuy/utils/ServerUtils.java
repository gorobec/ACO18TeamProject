package com.bestBuy.utils;

import com.bestBuy.model.Product;
import com.bestBuy.model.User;
import com.bestBuy.to.Serializer;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.util.Map;

/**
 * Created by Nastia on 04.03.17.
 */
public class ServerUtils {
    public static int getIdData(HttpExchange httpExchange) throws IOException {
        String input = readData(httpExchange);
        Serializer ser = Serializer.getInstance();
        Map<String, Integer> map = ser.convertJsonIDToObject(input);
        return map.get("id");
    }

    public static User getUserData(HttpExchange httpExchange) throws IOException {
        String input = readData(httpExchange);
        input = input.replace("[", "{").replace("]", "}").replace("\\", "");
        Serializer ser = Serializer.getInstance();
        User user = ser.convertJsonToSingleUser(input);
        return user;
    }

    public static Product getProduct(HttpExchange httpExchange) throws IOException {
        String input = readData(httpExchange);
        System.out.println(input);
        Serializer ser = Serializer.getInstance();
        return ser.convertJsonToProductType(input);
    }

    public static String readData(HttpExchange httpExchange) throws IOException {
        InputStream is = httpExchange.getRequestBody();
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] buff = new byte[1024];
        int bytesRead = 0;
        StringBuilder sb = new StringBuilder();
        while ((bytesRead = bis.read(buff)) != -1) {
            sb.append(new String (buff, 0, bytesRead));
        }
        bis.close();
        return sb.toString();
    }
}
