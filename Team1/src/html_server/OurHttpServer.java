package html_server;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import utils.HttpServerUtils;
import view.ViewUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        LoginContextCreator.createLoginContext(httpServer, iService);
        RegisterContextCreator.createRegisterContext(httpServer, iService);
        GetAllProductsContextCreator.getAllProductsContext(httpServer, iService);
        HelpContextCreator.createHelpContext(httpServer);
        httpServer.start();

        // save
        ViewUtils.save(iService);

    }
}
