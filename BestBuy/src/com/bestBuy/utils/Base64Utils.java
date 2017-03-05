package com.bestBuy.utils;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

/**
 * Created by Администратор on 05.03.2017.
 */
public class Base64Utils {

    public static BufferedImage getImage(String src) throws IOException {
        String Url = src;
        byte[] imagedata = DatatypeConverter.parseBase64Binary(Url.substring(Url.indexOf(",") + 1));
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
        return bufferedImage;
    }

    public static String getBase64URLData(String path) {
        File file =  new File(path);
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encodedfile;
    }

}
