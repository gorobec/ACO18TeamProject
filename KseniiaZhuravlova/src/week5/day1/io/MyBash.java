package week5.day1.io;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 * Created by ksyashka on 18.02.2017.
 */
public class MyBash implements IBash {

    private File currentDir;

    public MyBash(String path) {
    }

    @Override
    public String pwd() {
        return currentDir.getAbsolutePath();
    }

    @Override
    public String cd(String path) {
        File newPath = new File(path);

        if (newPath.isDirectory()) {
            currentDir = newPath;
            return pwd();
        }
        return null;
    }

    @Override
    public List<File> ls() {
        return null;
    }

    @Override
    public String cat(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder result = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null)
                result.append(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        return result.toString();
    }

    @Override
    public boolean writeInto(String path, String content) {
        return false;
    }

    @Override
    public boolean append(String path, String content) {
        return false;
    }

    @Override
    public boolean touch(String path) throws IOException {
        File file = new File(path);
        return file.createNewFile();
    }

    @Override
    public boolean mkdir(String dirPath) {
        return false;
    }

    @Override
    public List<File> find(String searchKey, String startPointPath) {
        return null;
    }
}
