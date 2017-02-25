package html_server;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import utils.HttpServerUtils;

/**
 * Created by v21k on 25.02.17.
 */
public class RegisterContextCreator {
    public static void createRegisterContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/register", httpExchange -> {

            String requestURI = httpExchange.getRequestURI().toString();
            final int MIN_PARAMS = 3;
            String response = "FAILED";


            // check if we have 3 or more params
            if (HttpServerUtils.checkParams(iService, requestURI, response, MIN_PARAMS)) {
                String[] params = HttpServerUtils.getParams(requestURI, "\\&");

                String name = params[0].split("=")[1];
                String pass = params[1].split("=")[1];
                String email = params[2].split("=")[1];

                try {
                    response = iService.signUp(name, pass, email) != null ? "OK" : "FAILED";
                } catch (InvalidIdException | InvalidInputParameters e) {
                    response = e.getMessage();
                }
            }

            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }
}
