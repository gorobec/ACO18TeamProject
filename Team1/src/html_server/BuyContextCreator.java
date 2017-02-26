package html_server;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidInputParameters;
import exception.InvalidTokenException;
import exception.NoSuchProductException;
import model.Address;
import model.BankCard;
import utils.HttpServerUtils;

import java.time.YearMonth;

/**
 * Created by zhenia on 25.02.17.
 */
public class BuyContextCreator {

    /**
     * sends in response ticket id if all good, else "NULL"
     * required request have to be similar to
     * ".../buy?productId=<id>&city=<city>&street=<street>&house=<house>
     * &bankCardNumber=<number>&bankCardCvv2=<cvv2>&bankCardDate=<year + month in format XXXX-XX>"
     */

    public static void createBuyContext(HttpServer httpServer, IService iService) {
        httpServer.createContext("/buy", httpExchange -> {
            String reqURI = httpExchange.getRequestURI().toString();

            String response = "NULL";

            if (HttpServerUtils.checkParams(iService, reqURI, response, 7)) {
                String[] params = HttpServerUtils.getParams(reqURI.split("\\?")[1], "\\&");

                int productId = Integer.parseInt(params[0].split("=")[1]);

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

                    response = "" + iService.buy(
                            iService.getUserByToken(OurHttpServer.token).getId(),
                            productId,
                            adress,
                            card
                    );

                } catch (InvalidInputParameters | InvalidTokenException | NoSuchProductException e) {
                    response = e.getMessage();
                }
            }

            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }
}
