package week5;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bash implements IBash{

    private String currentPath;


    @Override
    public String pwd() {
        return null;
    }

    @Override
    public String cd(String path) {
        return null;
    }

    @Override
    public List<File> ls(){
        File dir = new File(currentPath);
        File mas[] = dir.listFiles();
        List list = Arrays.asList(mas);
        for (File file : mas) {
            System.out.println(file.getName());
        }

        return list;
    }

    @Override
    public String cat(String path) throws NoSuchFileException {
        return null;
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
        file.createNewFile();
        return true;
    }

    @Override
    public boolean mkdir(String dirPath) {
        File dir = new File(dirPath);
        dir.mkdir();
        return true;
    }

    @Override
    public List<File> find(String searchKey, String startPointPath) {
        return null;
    }
}
