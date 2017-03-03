package html_server;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import view.ViewUtils;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by v21k on 25.02.17.
 */
public class OurHttpServer {
    public static String token;

    public static void main(String[] args) throws IOException {
        // load from db
        IService iService = ViewUtils.load();

        // create server and various contexts
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        BuyContextCreator.createBuyContext(httpServer, iService);
        LoginContextCreator.createLoginContext(httpServer, iService);
        RegisterContextCreator.createRegisterContext(httpServer, iService);
        GetAllProductsContextCreator.getAllProductsContext(httpServer, iService);
        HelpContextCreator.createHelpContext(httpServer);
        GoogleMapsContextCreator.googleMapsContextCreator(httpServer, iService);
        httpServer.start();

        System.out.println("Server started!");

        // save - should be moved to handlers
        ViewUtils.save(iService);

    }
}
