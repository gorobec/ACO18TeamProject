package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import utils.HttpServerUtils;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * Created by zhenia on 09.03.17.
 */
public class StartContextCreator {
    public static void createStartContext(HttpServer httpServer) {
        httpServer.createContext("/", httpExchange -> {
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
            String response = "<h1>404</h1>";

            try{
                File file = new File("Team1/resources/html/Main.html");

                if(!file.exists()) throw new InvalidParameterException("File not exists");

                response = HttpServerUtils.readFile(file.getPath());

            } catch (Throwable e) {
                e.printStackTrace();
                response = "<h1>404</h1>";
            }

            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }
}
