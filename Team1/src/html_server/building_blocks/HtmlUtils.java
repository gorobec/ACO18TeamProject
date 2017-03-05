package html_server.building_blocks;

import com.sun.net.httpserver.HttpServer;
import controller.IService;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import model.User;
import sun.misc.BASE64Decoder;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;
import utils.HttpServerUtils;
import view.ViewUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

/**
 * Created by serhii on 04.03.17.
 */
public class HtmlUtils {
    public static void getHtmlDirectCreator(HttpServer httpServer, IService iService) {
        httpServer.createContext("/html", httpExchange -> {
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Arrays.asList("*"));

            InputStream is = httpExchange.getRequestBody();
            int read;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            while((read = is.read()) != -1){
                os.write(read);
            }

            BufferedImage image = null;
            byte[] imageByte;

            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(new String(os.toByteArray()));
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();

// write the image to a file
            File outputfile = new File("/home/serhii/dev/ACO18TeamProject/Team1/image.png");
            ImageIO.write(image, "png", outputfile);

            String response = "<h1>Hello with html<a href='some/go'>Go</a></h1>";
            // sending a response
            HttpServerUtils.sendingAResponse(httpExchange, response);
        });
    }
}
