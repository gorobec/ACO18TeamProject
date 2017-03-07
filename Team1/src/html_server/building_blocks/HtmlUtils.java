package html_server.building_blocks;

import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpServer;
import controller.IService;
import model.Product;
import utils.HttpServerUtils;
import view.ViewUtils;

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

                // get product instance using fields from productModel
                Product product = HttpServerUtils.getProduct(iService, productModel);

                // save images and get paths array to save in Product's field "imagePaths"
                String[] paths = HttpServerUtils.getPathsForProduct(productModel, product);
                product.setImagePath(paths);

                // add to db and save
                iService.addProduct(product);
                ViewUtils.save(iService);

                // check
                System.out.println(Arrays.toString(paths));
            } catch (Throwable e) {
                response = e.getMessage();
                e.printStackTrace();
            }
            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }

    public static class ProductModel {
        public String name;
        public String location;
        public String image;

    }
}

