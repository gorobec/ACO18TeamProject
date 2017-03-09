package com.bestBuy.utils;

import com.bestBuy.model.Product;
import com.bestBuy.model.User;
import com.bestBuy.to.Serializer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
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

    public static BufferedImage getImage(String src) throws IOException {
        String Url = src;
        byte[] imagedata = DatatypeConverter.parseBase64Binary(Url.substring(Url.indexOf(",") + 1));
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
        return bufferedImage;
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

    public static void sendData (HttpExchange httpExchange, String data) throws IOException{
        try (OutputStream outputStream = httpExchange.getResponseBody()) {
            byte[] dataBytes = data.getBytes();
            httpExchange.sendResponseHeaders(200, dataBytes.length);
            outputStream.write(dataBytes);
            outputStream.flush();
        }
    }

    public static void getResponse(HttpExchange httpExchange){
        try {
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
        } catch (Throwable e){
            e.printStackTrace();
        }
    }

}