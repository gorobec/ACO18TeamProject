package html_server.LoginPage;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import model.User;
import utils.HttpServerUtils;

/**
 * Created by v21k on 25.02.17.
 */
public class RegisterContextCreator {
    public static void createRegisterContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/register", httpExchange -> {
            String response = null;

            RegisterModel lm = HttpServerUtils.getRequestData(httpExchange, RegisterModel.class);
            try {
                User user = iService.signUp(lm.name, lm.pass, lm.email);
                response = user != null ? "OK" : "FAILED";
            } catch (InvalidIdException | InvalidInputParameters e) {
                response = e.getMessage();
            }
            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }

    private class RegisterModel {
        public String name;
        public String pass;
        public String email;
    }
}
