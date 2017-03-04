package com.bestBuy.server.contextsList;

import com.bestBuy.model.Product;
import com.bestBuy.to.Serializer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by Nastia on 04.03.17.
 */
public class AllProductsContext {
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
}
