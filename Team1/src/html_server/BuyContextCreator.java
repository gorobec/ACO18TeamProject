package html_server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.*;
import model.Address;
import model.BankCard;
import requestModels.BuyRequestModel;
import utils.HttpServerUtils;

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

            String reqURI = httpExchange.getRequestURI().toString();
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
            System.out.println("O_O");

            int ticketId;

            String response = "NULL";

            if(HttpServerUtils.checkParams(iService, reqURI, response, 7)){
                String[] params = HttpServerUtils.getParams(reqURI.split("\\?")[1], "\\&");

                int productId = Integer.parseInt(params[0].split("=")[1]);

                //String parameters = HttpServerUtils.readRequestBody(httpExchange);

                //Gson GSON = new Gson();

                //BuyRequestModel model = GSON.fromJson(parameters, BuyRequestModel.class);

                BuyRequestModel model = HttpServerUtils.getRequestData(httpExchange, BuyRequestModel.class);

                System.out.println(model.productId);
                System.out.println(model.adress);
                System.out.println(model.bankCard);

                try {
                    Address adress = new Address(
                            params[1].split("=")[1],
                            params[2].split("=")[1],
                            Integer.parseInt(params[3].split("=")[1])
                    );

                    BankCard card = new BankCard(
                            params[4].split("=")[1],
                            Integer.parseInt(params[5].split("=")[1]),
                            YearMonth.parse(params[6].split("=")[1])
                    );



                    ticketId = iService.buy(
                                                iService.getUserByToken(OurHttpServer.token).getId(),
                                                    productId,
                                                        adress,
                                                            card
                                                );

                    response = GSON.toJson(iService.getTicketById(ticketId, OurHttpServer.token));

                } catch (InvalidInputParameters invalidInputParameters) {
                    invalidInputParameters.printStackTrace();
                } catch (InvalidTokenException e) {
                    e.printStackTrace();
                } catch (NoSuchProductException e) {
                    e.printStackTrace();
                } catch (InvalidIdException e) {
                    e.printStackTrace();
                } catch (UserLoginException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(response);

            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
    }
}
