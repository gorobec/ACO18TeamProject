package html_server.building_blocks;

import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpServer;
import controller.IService;
import model.Coordinates;
import model.Product;
import utils.HttpServerUtils;
import utils.PropertiesHolder;
import view.ViewUtils;

import java.awt.image.BufferedImage;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Created by serhii on 04.03.17.
 */
public class HtmlUtils {
    public static void getHtmlDirectCreator(HttpServer httpServer, IService iService) {
        httpServer.createContext("/html", httpExchange -> {
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
            String response = "Done!";
            try {
                // type for correct json converting
                Type type = new TypeToken<ProductModel>() {
                }.getType();

                // creating model and other stuff to create Product
                ProductModel productModel = HttpServerUtils.getModel(httpExchange, type);
                String[] location = productModel.location.split(",");
                Coordinates coordinates = new Coordinates(Double.parseDouble(location[0]), Double.parseDouble(location[0]));
                Product product = new Product(iService.getProducts().size() + 1, productModel.name, coordinates, null);

                // get buffered image
                BufferedImage image = HttpServerUtils.getBufferedImage(productModel.image.split(",")[1]);

                // save image to local folder and set imagePath
                String path = PropertiesHolder.getProperty("pathForProductImages") + product.getId() + product.getName() + ".png";
                product.setImagePath(HttpServerUtils.saveImage(image, path));


                // add to DB and save DB
                iService.addProduct(product);
                ViewUtils.save(iService);

                // check
                System.out.println(product.getImagePath());
            } catch (Throwable e) {
                response = e.getMessage();
                e.printStackTrace();
            }

            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }

<<<<<<< HEAD
    public static class ProductModel {
        public String name;
        public String location;
        public String image;

    }
=======
    // how to catch errors
    public static void test(HttpServer httpServer) {
        httpServer.createContext("/error", httpExchange -> {
            try{
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
                String e = null;
                e.isEmpty();
            } catch (Throwable e){
                e.printStackTrace();
            }
        });
    }

>>>>>>> 6dac0337ca3b5043b6dc69e81e55c84815b8083b
}
