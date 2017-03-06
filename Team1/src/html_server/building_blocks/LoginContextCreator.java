package html_server.building_blocks;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import exception.InvalidTokenException;
import html_server.OurHttpServer;
import model.Ticket;
import model.User;
import utils.HttpServerUtils;
import view.ViewUtils;

/**
 * Created by v21k on 25.02.17.
 */
public class LoginContextCreator {
    public static void createLoginContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/login", httpExchange -> {
            String response = "FAILED";

            Gson GSON = new Gson();

            LoginModel lm = HttpServerUtils.getRequestData(httpExchange, LoginModel.class);
            try {
                OurHttpServer.token = iService.logIn(lm.name, lm.pass);
                User user = iService.getUserByToken(OurHttpServer.token);
//
//                UserResponseModel urm = new UserResponseModel();
//
//                urm.email = user.getEmail();
//                urm.name = user.getName();
//                urm.tickets = (Ticket[])user.getTickets().toArray();

                response = OurHttpServer.token.length() > 1 ? GSON.toJson(user) : "";
            } catch (InvalidIdException | InvalidTokenException | InvalidInputParameters e) {
                System.out.println(e.getMessage());
            }

            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
            ViewUtils.save(iService);
        });
    }

    private static class UserResponseModel {
        public String name;
        public String email;
        public Ticket[] tickets;
    }

    private class LoginModel {
        public String name;
        public String pass;
    }
}
