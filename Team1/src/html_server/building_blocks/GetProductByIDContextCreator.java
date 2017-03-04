package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import utils.HttpServerUtils;

public class GetProductByIDContextCreator {

    public static void getAllProductByIDContext(HttpServer httpServer, IService iService, int productID) {
        httpServer.createContext("/getproductbyid", httpExchange -> {
            try {
                HttpServerUtils.sendingAResponse(httpExchange, iService.getProductById(productID).toString());
            } catch (InvalidIdException e) {
                e.printStackTrace();
            }
        });
    }
}
