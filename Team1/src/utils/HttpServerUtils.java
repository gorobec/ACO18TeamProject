package utils;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import controller.IService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

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

    public static <T> T getRequestData(HttpExchange httpExchange, Class<T> model) throws IOException {
        httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
        StringBuilder request = new StringBuilder();

        try (InputStream is = httpExchange.getRequestBody()) {
            int i;
            while ((i = is.read()) != -1) {
                request.append((char) i);
            }
        }
        return new Gson().fromJson(request.toString(), model);
    }
}
