package html_server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import controller.IService;
import model.Product;
import utils.HttpServerUtils;

import java.util.Arrays;


/**
 * Created by v21k on 02.03.17.
 */
public class GoogleMapsContextCreator {
    public static void googleMapsContextCreator(HttpServer httpServer, IService iService) {
        httpServer.createContext("/map", httpExchange -> {
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

            String jsonToSend = new Gson().toJson(iService.getProducts().stream().toArray(Product[]::new));

            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, jsonToSend);
        });
    }
}
