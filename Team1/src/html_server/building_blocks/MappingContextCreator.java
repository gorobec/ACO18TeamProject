package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import utils.HttpServerUtils;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
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

                if(parseArr[parseArr.length - 1].indexOf(".") != parseArr[parseArr.length - 1].lastIndexOf(".") || !parseArr[parseArr.length - 1].contains("."))
                    throw new InvalidParameterException("File name");

                String[] reqFileNameArr = new String[2];

                reqFileNameArr[0] = parseArr[parseArr.length - 1].substring(0, parseArr[parseArr.length - 1].indexOf("."));
                reqFileNameArr[1] = parseArr[parseArr.length - 1].substring(parseArr[parseArr.length - 1].indexOf(".") + 1, parseArr[parseArr.length - 1].length());

                //String[] reqFileNameArr = parseArr[2].split(".");

                //if(reqFileNameArr.length != 2) throw new InvalidParameterException("File name");

                String pathHolder = getValidDir(reqFileNameArr[1]);

                for(int i = 2; i < parseArr.length - 1; i++) {
                    pathHolder += parseArr[i] + "/";
                }

                pathHolder += parseArr[parseArr.length - 1];

                File file = new File(pathHolder);

                if(!file.exists()) throw new InvalidParameterException("File not exists");

                //File file = new File("/root/images/test.gif");
                if(pathHolder.contains("images")) {

                    httpExchange.sendResponseHeaders(200, file.length());
                    // TODO set the Content-Type header to image/gif

                    OutputStream outputStream = httpExchange.getResponseBody();
                    Files.copy(file.toPath(), outputStream);
                    outputStream.close();

                    return;
                }
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
            return "Team1/resources/";

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
