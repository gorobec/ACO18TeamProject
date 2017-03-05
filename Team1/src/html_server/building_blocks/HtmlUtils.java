package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import utils.HttpServerUtils;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

/**
 * Created by serhii on 04.03.17.
 */
public class HtmlUtils {
    public static void getHtmlDirectCreator(HttpServer httpServer, IService iService) {
        httpServer.createContext("/html", httpExchange -> {
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

            ByteArrayOutputStream os = HttpServerUtils.getByteArrayOutputStream(httpExchange);

            BufferedImage image = HttpServerUtils.getBufferedImage(os);

            HttpServerUtils.saveImage(image, "Team1/resources/images/products");

            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, "OK");
        });
    }

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

}
