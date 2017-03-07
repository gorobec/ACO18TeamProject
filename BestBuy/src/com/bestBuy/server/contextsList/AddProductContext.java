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
import static com.bestBuy.utils.Base64Utils.*;

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
                String[] images = product.getImageSource();

                for (int i = 0; i < images.length; i++) {
                    String imageSrc = config.getProperty("package_for_images") +"/"+ i + product.getName() + ".jpg";
                    File file = new File(imageSrc);
                    ImageIO.write(getImage(images[i]), "jpg", file);
                    product.setImageUrl(null);
                }

                boolean added = service.addProduct(product);
                service.saveDatabase();
                ServerUtils.sendData(httpExchange, String.valueOf(added));
            }
        });
    }
}
