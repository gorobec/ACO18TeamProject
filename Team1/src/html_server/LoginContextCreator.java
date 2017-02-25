package html_server;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import utils.HttpServerUtils;

/**
 * Created by v21k on 25.02.17.
 */
public class LoginContextCreator {
    public static void createLoginContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/login", httpExchange -> {

            String requestURI = httpExchange.getRequestURI().toString();
            String response = "FAILED";
            final int MIN_PARAMS = 2;

            // check if we have 2 or more params
            if (HttpServerUtils.checkParams(iService, requestURI, response, MIN_PARAMS)) {
                String[] params = requestURI.split("\\?")[1].split("&");
                String name = params[0].split("=")[1];
                String pass = params[1].split("=")[1];
                try {
                    // generate token and save it in main class OurHttpServer
                    String token = iService.logIn(name, pass);
                    response = "OK";
                    OurHttpServer.token = token;
                } catch (InvalidIdException | InvalidInputParameters e) {
                    response = e.getMessage();
                }
            }

            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }
}
