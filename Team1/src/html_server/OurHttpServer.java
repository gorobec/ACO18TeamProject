package html_server;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import view.ViewUtils;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by v21k on 25.02.17.
 */
public class OurHttpServer {
    public static HttpServer httpServer;
    public static String token;

    public static void main(String[] args) throws IOException {
        // load from db
        IService iService = ViewUtils.load();

        // create server and create various contexts
        httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        LoginContextCreator.createLoginContext(httpServer, iService);
        RegisterContextCreator.createRegisterContext(httpServer, iService);
        httpServer.start();

        // save
        ViewUtils.save(iService);

    }
}
