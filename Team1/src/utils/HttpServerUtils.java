package utils;

import com.sun.net.httpserver.HttpExchange;
import controller.IService;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by v21k on 25.02.17.
 */
public class HttpServerUtils {
    public static boolean checkParams(IService iService, String requestURI, String response, int numberOfParams) {
        if (requestURI.contains("?") && !requestURI.endsWith("?") && requestURI.contains("&")) {
            // parse name and pass
            String[] params = requestURI.split("\\?")[1].split("&");

            if (params.length >= numberOfParams) {
                return true;
            }
        }
        return false;
    }

    public static void sendingAResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public static String[] getParams(String string, String regExpr) {
        return string.split(regExpr);
    }
}
