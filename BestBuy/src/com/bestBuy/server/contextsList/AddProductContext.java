package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.model.Configuration;
import com.bestBuy.model.Product;
import com.bestBuy.server.Server;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Nastia on 04.03.17.
 */
public class AddProductContext {
    public static void addProduct(HttpServer server, IStore service) {
        server.createContext("/addproduct", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

                Properties config = Configuration.getConfig();
                Product product = ServerUtils.getProduct(httpExchange);
                String[] images = product.getImageSource();

                for (int i = 0; i < images.length; i++) {
                    String imageSrc = config.getProperty("package_for_images") +"/"+ i + product.getName() + ".jpg";
                    File file = new File(imageSrc);
                    ImageIO.write(ServerUtils.getImage(images[i]), "jpg", file);
                    product.replaceImageSource(imageSrc, i);
                }

                boolean added = service.addProduct(product);
                service.saveDatabase();
                try (OutputStream outputStream = httpExchange.getResponseBody()) {

                    httpExchange.sendResponseHeaders(200, String.valueOf(added).length());

                    outputStream.write(String.valueOf(added).getBytes());
                    outputStream.flush();

                }
            }
        });
    }
}
