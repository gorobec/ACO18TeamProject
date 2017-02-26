package html_server;

import com.sun.net.httpserver.HttpServer;
import utils.HttpServerUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;

/**
 * Created by v21k on 26.02.17.
 */
public class HelpContextCreator {
    public static void createHelpContext(HttpServer httpServer) {
        httpServer.createContext("/help", httpExchange -> {

            StringBuilder response = new StringBuilder();

            try (BufferedReader bf = new BufferedReader(new FileReader(Paths.get("Team1/src/html_server/README.txt").toString()))) {
                String s;
                while ((s = bf.readLine()) != null) {
                    response.append(s).append("\n");
                }
            }
            HttpServerUtils.sendingAResponse(httpExchange, response.toString());
        });
    }
}
