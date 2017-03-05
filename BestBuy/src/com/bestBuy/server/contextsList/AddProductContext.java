package com.bestBuy.server.contextsList;

import com.bestBuy.controller.IStore;
import com.bestBuy.model.Configuration;
import com.bestBuy.model.Product;
import com.bestBuy.utils.ServerUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Nastia on 04.03.17.
 */
public class AddProductContext {
    public static void addProduct(HttpServer server, IStore service) {
        server.createContext("/addproduct", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                ServerUtils.getResponse(httpExchange);
                Properties config = Configuration.getConfig();
                Product product = ServerUtils.getProduct(httpExchange);
                String imageSrc = config.getProperty("package_for_images") +"/"+ product.getName() + ".jpg";
                File file = new File(imageSrc);
                ImageIO.write(ServerUtils.getImage(product.getImageSource()), "jpg", file);
                product.setImageSource(imageSrc);
                boolean added = service.addProduct(product);
                service.saveDatabase();
                ServerUtils.sendData(httpExchange, String.valueOf(added));
            }
        });
    }
}
