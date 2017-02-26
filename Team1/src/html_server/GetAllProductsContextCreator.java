package html_server;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import utils.HttpServerUtils;

public class GetAllProductsContextCreator {

    public static void getAllProductsContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/getallproducts", httpExchange -> {
            HttpServerUtils.sendingAResponse(httpExchange, iService.getProducts().toString());
        });
    }
}
