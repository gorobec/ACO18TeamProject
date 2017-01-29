package oop.weak1.test_task.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Vorobiei on 18.05.2016.
 */
public class FileUtils {
    public static String readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src/oop/weak1/test_task/resources/WarAndPeace.txt")));
        StringBuilder sb = new StringBuilder();
        while (br.ready()){
            sb.append(br.readLine()).append("\n");
        }
        return sb.toString().substring(1);
    }
}
