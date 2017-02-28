package com.bestBuy.server;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.IncorrectPasswordException;
import com.bestBuy.exceptions.NoSuchProductException;
import com.bestBuy.exceptions.NoSuchUserException;
import com.bestBuy.model.Product;
import com.bestBuy.model.User;
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
        server.createContext("/allProducts", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
                String requestUrl = httpExchange.getRequestURI().toString();
                System.out.println(requestUrl);
                System.out.println("HTTP method is " + httpExchange.getRequestMethod());

                try (OutputStream outputStream = httpExchange.getResponseBody()) {
                    Product[] products = service.showAllProducts();
                    Serializer serializer = Serializer.getInstance();
                    String json = serializer.convertObjectToJson(products);
                    httpExchange.sendResponseHeaders(200, json.length());

                    outputStream.write(json.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }

            }
        });
        server.createContext("/productByID", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

                int productId = Server.getIdData(httpExchange);
                try (OutputStream outputStream = httpExchange.getResponseBody()) {
                    String s = null;
                    try {
                        s = service.printProductById(productId);
                    } catch (NoSuchProductException e) {
                        s = e.getMessage();
                    }
                    httpExchange.sendResponseHeaders(200, s.length());

                    outputStream.write(s.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
            }
        });

        server.createContext("/ticketByID", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

                int ticketId = Server.getIdData(httpExchange);
                try (OutputStream outputStream = httpExchange.getResponseBody()) {
                    String s = null;
                    try {
                        s = service.printProductById(ticketId);
                    } catch (NoSuchProductException e) {
                        s = e.getMessage();
                    }
                    httpExchange.sendResponseHeaders(200, s.length());

                    outputStream.write(s.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
            }
        });

        server.createContext("/login", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

                String[] userData = getUserData(httpExchange);
                String s = "login was successful";
                try (OutputStream outputStream = httpExchange.getResponseBody()) {
                    try {
                        service.checkLoginAndPassword(userData[0], userData[1]);
                    } catch (NoSuchUserException e) {
                        s = e.getMessage();
                    } catch (IncorrectPasswordException e) {
                        s = e.getMessage();
                    }
                    httpExchange.sendResponseHeaders(200, s.length());

                    outputStream.write(s.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
            }
        });

        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started. Connect com.bestBuy.to localhost:8000/test");
    }

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

    public static String[] getUserData(HttpExchange httpExchange) throws IOException {
        InputStream is = httpExchange.getRequestBody();
        StringBuilder sb = new StringBuilder();

        String input = "";
        int read = -1;
        while ((read = is.read()) != -1) {
            input += (char) read;
        }
        return input.split(";");
    }

}
