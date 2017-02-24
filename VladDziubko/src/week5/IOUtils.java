package week5;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class IOUtils implements Bash {
    private String currentPath = "";

    public IOUtils() {
    }

    public IOUtils(String currentPath) {
        this.currentPath = currentPath;
    }

    @Override
    public String less(String path) throws NoSuchFileException {
        return null;
    }

    @Override
    public String pwd() {
        return currentPath;
    }

    @Override
    public List<File> ls() {
        return null;
    }

    @Override
    public String cd(String path) {
        return null;
    }

    @Override
    public String cat(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(currentPath));
        String res;
        while((res = br.readLine()) != null){
            System.out.println(res);
        }
        return res;
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
    public boolean touch(String path) {
        return false;
    }

    @Override
    public boolean mkdir(String dirPath) {
        return false;
    }
}
