package html_server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.*;
import model.Address;
import model.BankCard;
import requestModels.BuyRequestModel;
import utils.HttpServerUtils;
import utils.MailSender;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.YearMonth;
import java.util.Arrays;

import static utils.DataBaseConverter.GSON;

/**
 * Created by zhenia on 25.02.17.
 */
public class BuyContextCreator {

    /**
     * sends in response ticket id if all good, else "NULL"
     * required request have to be similar to
     *          ".../buy?productId=<id>&city=<city>&street=<street>&house=<house>
     *              &bankCardNumber=<number>&bankCardCvv2=<cvv2>&bankCardDate=<year + month in format XXXX-XX>"
     */

    public static void createBuyContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/buy", httpExchange -> {

            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
            System.out.println("O_O");

            int ticketId = 0;

            boolean check = true;

            String response = "NULL";

            BuyRequestModel model = HttpServerUtils.getRequestData(httpExchange, BuyRequestModel.class);

            System.out.println(model.productId);
            System.out.println(model.adress);
            System.out.println(model.bankCard);

            if(model != null && model.adress != null && model.bankCard != null){
                try {
                    ticketId = iService.buy(
                                                iService.getUserByToken(OurHttpServer.token).getId(),
                                                    model.productId,
                                                        model.adress,
                                                            model.bankCard
                                                );

                    response = GSON.toJson(iService.getTicketById(ticketId, OurHttpServer.token));

                } catch (InvalidInputParameters invalidInputParameters) {
                    invalidInputParameters.printStackTrace();
                    check = false;
                } catch (InvalidTokenException e) {
                    e.printStackTrace();
                    check = false;
                } catch (NoSuchProductException e) {
                    e.printStackTrace();
                    check = false;
                } catch (InvalidIdException e) {
                    e.printStackTrace();
                    check = false;
                } catch (UserLoginException e) {
                    e.printStackTrace();
                    check = false;
                }
            }

            System.out.println(response);

            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

            if(model != null && model.adress != null && model.bankCard != null && check) {
                if (check) try {
                    MailSender.sendEmail(
                            iService.getUserByToken(OurHttpServer.token),
                            iService.getTicketById(ticketId, OurHttpServer.token),
                            iService.getProductById(model.productId)
                    );
                } catch (InvalidTokenException e) {
                    e.printStackTrace();
                } catch (InvalidIdException e) {
                    e.printStackTrace();
                } catch (UserLoginException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
