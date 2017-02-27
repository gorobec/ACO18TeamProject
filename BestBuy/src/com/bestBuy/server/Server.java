package com.bestBuy.server;

import com.bestBuy.controller.IStore;
import com.bestBuy.exceptions.NoSuchProductException;
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
public class Server{

    HttpServer server = null;

    public Server(IStore service) {
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/test", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
                String requestUrl = httpExchange.getRequestURI().toString();
                System.out.println(requestUrl);
                System.out.println("HTTP method is " + httpExchange.getRequestMethod());

                try (OutputStream outputStream = httpExchange.getResponseBody()){
                    String s = service.printAllProducts();
                    httpExchange.sendResponseHeaders(200, s.length());

                    outputStream.write(s.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }

            }
        });
        server.createContext("/post-info", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

                InputStream is = httpExchange.getRequestBody();
                StringBuilder sb = new StringBuilder();

                String input = "";
                int read = -1;
                while((read = is.read()) != -1){
                    input += (char)read;
                }

                Serializer ser = new Serializer();

                Map<String,Integer> map = ser.convertJsonIDToObject(input);

                try (OutputStream outputStream = httpExchange.getResponseBody()){
                    String s = null;
                    try {
                        s = service.printProductById(Integer.valueOf(map.get("id")));
                    } catch (NoSuchProductException e) {
                        e.printStackTrace();
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

}
