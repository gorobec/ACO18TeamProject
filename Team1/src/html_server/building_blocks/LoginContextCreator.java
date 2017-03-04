package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import html_server.OurHttpServer;
import utils.HttpServerUtils;

/**
 * Created by v21k on 25.02.17.
 */
public class LoginContextCreator {
    public static void createLoginContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/login", httpExchange -> {
            String response = "FAILED";

            LoginModel lm = HttpServerUtils.getRequestData(httpExchange, LoginModel.class);
            try {
                OurHttpServer.token = iService.logIn(lm.name, lm.pass);
                response = OurHttpServer.token.length() > 1 ? lm.name : "";
            } catch (InvalidIdException | InvalidInputParameters e) {
                System.out.println(e.getMessage());
            }
            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }

    private class LoginModel {
        public String name;
        public String pass;
    }
}
