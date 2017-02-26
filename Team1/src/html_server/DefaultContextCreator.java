package html_server;

import com.sun.net.httpserver.HttpServer;
import utils.HttpServerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by v21k on 26.02.17.
 */
public class DefaultContextCreator {
    public static void createDefaultContext(HttpServer httpServer){
        httpServer.createContext("/", httpExchange -> {
            HttpServerUtils.sendingAResponse(httpExchange,
                    Files.readAllLines(Paths.get("Team1/src/html_server/README")).stream().map(Object::toString).collect(Collectors.joining()));
        });
    }
}
