package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import utils.HttpServerUtils;

import java.util.stream.Collectors;

public class GetAllProductsContextCreator {

    public static void getAllProductsContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/getallproducts", httpExchange -> {
            HttpServerUtils.sendingAResponse(httpExchange, iService.getProducts().stream().map(Object::toString).collect(Collectors.joining()));
        });
    }
}
