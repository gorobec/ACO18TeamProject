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

import java.util.Arrays;

import static utils.DataBaseConverter.GSON;

/**
 * Created by zhenia on 05.03.17.
 */
public class GetTicketsContextCreator {
    public static void createGetTicketsContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/tickets", httpExchange -> {
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
            String response = "FAILED";

            try {
                User user = iService.getUserByToken(OurHttpServer.token);

                Ticket[] arr = new Ticket[user.getTickets().size()];

                try {
                    arr = user.getTickets().toArray(arr);
                } catch (Throwable ex){
                    ex.printStackTrace();
                }
                TicketsResponseModel[] trm = new TicketsResponseModel[arr.length];

                for(int i = 0; i < arr.length; i++){
                    trm[i] = new TicketsResponseModel();
                    trm[i].id = arr[i].getId();
                    trm[i].product = iService.getProductById(arr[i].getProductID()).getName();
                }

                response = OurHttpServer.token.length() > 1 ? GSON.toJson(trm) : "FAILED";
            } catch (InvalidTokenException | InvalidIdException e) {
                System.out.println(e.getMessage());
            }

            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
            ViewUtils.save(iService);
        });
    }
    private static class TicketsResponseModel{
        public int id;
        public String product;
    }
}
