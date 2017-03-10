package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import html_server.OurHttpServer;
import utils.HttpServerUtils;

import java.util.Arrays;

/**
 * Created by v21k on 09.03.17.
 */
public class LogoutContextCreator {
    public static void createLogoutContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/logout", httpExchange -> {
            String response = "DONE";
            try {
                httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
                System.out.println("Logout for user " + iService.getUserByToken(OurHttpServer.token));
                OurHttpServer.token = "";
            } catch (Throwable e) {
                response = e.getMessage();
                e.printStackTrace();
            }
            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }
}
