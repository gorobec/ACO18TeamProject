package utils;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import controller.IService;
import html_server.building_blocks.HtmlUtils;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Created by v21k on 25.02.17.
 */
public class HttpServerUtils {

    public static void sendingAResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
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

    public static ByteArrayOutputStream getByteArrayOutputStream(HttpExchange httpExchange) throws IOException {
        InputStream is = httpExchange.getRequestBody();
        int read;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        while((read = is.read()) != -1){
            os.write(read);
        }
        return os;
    }

    public static String saveImage(BufferedImage image, String path) throws IOException {
        File outputfile = new File(path);
        ImageIO.write(image, "png", outputfile);
        return path;
    }

    public static BufferedImage getBufferedImage(String raw) throws IOException {
        BufferedImage image = null;
        byte[] imageByte;
        BASE64Decoder decoder = new BASE64Decoder();
        imageByte = decoder.decodeBuffer(raw);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        image = ImageIO.read(bis);
        bis.close();
        return image;
    }

    public static <T> T getModel(HttpExchange httpExchange, Type type) throws IOException {
        InputStream is = httpExchange.getRequestBody();
        StringBuilder sb = new StringBuilder();
        int temp;
        while ((temp = is.read()) != -1) {
            sb.append((char) temp);
        }
        return new Gson().fromJson(sb.toString(), type);
    }
}
