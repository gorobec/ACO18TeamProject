package week5;

import java.io.File;

public class Run {
    public static void main(String[] args) {
        IOUtils utils = new IOUtils();
        File file = new File("E:\\test.txt");
        System.out.println(file.getAbsolutePath());

    }

}
