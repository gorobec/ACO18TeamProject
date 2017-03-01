package html_server;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import utils.HttpServerUtils;
import html_server.LoginAndReg.LoginContextCreator;
import html_server.LoginAndReg.RegisterContextCreator;
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

        try {
            iService.signUp("username1", "Password1", "42004200zhenia@gmail.com");
            token = iService.logIn("username1", "Password1");
        } catch (InvalidInputParameters invalidInputParameters) {
            invalidInputParameters.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }

        // create server and various contexts
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        BuyContextCreator.createBuyContext(httpServer, iService);
        LoginContextCreator.createLoginContext(httpServer, iService);
        RegisterContextCreator.createRegisterContext(httpServer, iService);
        GetAllProductsContextCreator.getAllProductsContext(httpServer, iService);
        HelpContextCreator.createHelpContext(httpServer);
        httpServer.start();

        System.out.println("Server started!");

        // save
        ViewUtils.save(iService);

    }
}
