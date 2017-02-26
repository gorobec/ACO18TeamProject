package html_server;

import com.sun.net.httpserver.HttpServer;
import utils.HttpServerUtils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by v21k on 26.02.17.
 */
public class HelpContextCreator {
    public static void createHelpContext(HttpServer httpServer){
        httpServer.createContext("/help", httpExchange -> {

            StringBuilder response = new StringBuilder();

            try(BufferedReader bf = new BufferedReader(new FileReader("/home/v21k/Java/dev/ACO18TeamProject/Team1/src/html_server/README.txt"))){
                String s;
                while ((s = bf.readLine()) != null){
                    response.append(s).append("\n");
                }
            }
            HttpServerUtils.sendingAResponse(httpExchange, response.toString());
        });
    }
}
