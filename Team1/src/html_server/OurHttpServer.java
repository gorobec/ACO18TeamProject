package html_server;

import com.sun.net.httpserver.HttpServer;
import container.ProductDB;
import container.TicketDB;
import container.UserDB;
import controller.IService;
import controller.ServiceImpl;
import html_server.building_blocks.*;
import view.View;
import view.ViewUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

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

        System.out.println(httpServer.getExecutor());
        BuyContextCreator.createBuyContext(httpServer, iService);
        LoginContextCreator.createLoginContext(httpServer, iService);
        RegisterContextCreator.createRegisterContext(httpServer, iService);
        GoogleMapsContextCreator.googleMapsContextCreator(httpServer, iService);
        GetTicketsContextCreator.createGetTicketsContext(httpServer, iService);
        HtmlUtils.getHtmlDirectCreator(httpServer, iService);
        //HtmlUtils.test(httpServer);
        httpServer.start();


        System.out.println("Server started!");
    }
}
