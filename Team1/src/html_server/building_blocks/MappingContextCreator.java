package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import utils.HttpServerUtils;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * Created by zhenia on 06.03.17.
 */
public class MappingContextCreator {
    public static void createMappingContext(HttpServer httpServer) {
        httpServer.createContext("/static", httpExchange -> {
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));
            String response = "<h1>404</h1>";

            try{
                String url = httpExchange.getRequestURI().toString();

                System.out.println(url);

                String[] parseArr = url.split("/");

                if(parseArr.length < 3) throw new InvalidParameterException("Invalid request");

                /**
                 * W
                 * A
                 * T
                 * ?
                 * ?
                 * */

                if(parseArr[2].indexOf(".") != parseArr[2].lastIndexOf(".") || parseArr[2].indexOf(".") == -1)
                    throw new InvalidParameterException("File name");

                String[] reqFileNameArr = new String[2];

                reqFileNameArr[0] = parseArr[2].substring(0, parseArr[2].indexOf("."));
                reqFileNameArr[1] = parseArr[2].substring(parseArr[2].indexOf(".") + 1, parseArr[2].length());

                //String[] reqFileNameArr = parseArr[2].split(".");

                //if(reqFileNameArr.length != 2) throw new InvalidParameterException("File name");

                File file = new File(getValidDir(reqFileNameArr[1]) + parseArr[2]);

                if(!file.exists()) throw new InvalidParameterException("File not exists");

                response = HttpServerUtils.readFile(file.getPath());

            } catch (Throwable e) {
                e.printStackTrace();
                response = "<h1>404</h1>";
            }

            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }

    private static String getValidDir(String fileType){
        if("".equals(fileType)) return "";

        if(fileType.equals("jpeg") ||
                fileType.equals("jpg") ||
                    fileType.equals("png") ||
                        fileType.equals("gif"))
            return "Team1/resources/img/";

        if(fileType.equals("ttf") ||
                fileType.equals("woff") ||
                fileType.equals("woff2") ||
                fileType.equals("eot"))
            return "Team1/resources/fonts/roboto/";

        if(fileType.equals("html")) return "Team1/resources/html/";

        if(fileType.equals("css")) return "Team1/resources/css/";

        if(fileType.equals("js")) return "Team1/resources/js/";

        return "";
    }
}
