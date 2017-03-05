package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.model.Product;
import com.bestBuy.to.Serializer;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

/**
 * Created by Nastia on 04.03.17.
 */
public class AllProductsContext {
    public static void getAllProducts(HttpServer server, IStore service) {
        server.createContext("/allProducts", new HttpHandler() {
            public void handle(HttpExchange httpExchange) throws IOException {
<<<<<<< HEAD
                ServerUtils.getResponse(httpExchange);
                Product[] products = service.showAllProducts();
                Serializer serializer = Serializer.getInstance();
                String json = serializer.convertObjectToJson(products);
                ServerUtils.sendData(httpExchange, json);
=======
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
                String requestUrl = httpExchange.getRequestURI().toString();

                try (OutputStream outputStream = httpExchange.getResponseBody()) {
                    Product[] products = service.showAllProducts();
                    Serializer serializer = Serializer.getInstance();
                    String json = serializer.convertObjectToJson(products);

                    byte[] bytes = json.getBytes();
                    httpExchange.sendResponseHeaders(200, bytes.length);

                    outputStream.write(bytes);
                    outputStream.flush();
                    outputStream.close();
                }

>>>>>>> 9725706541478fdc83533a7049414b9d2a0ee4c8
            }
        });
    }

}
