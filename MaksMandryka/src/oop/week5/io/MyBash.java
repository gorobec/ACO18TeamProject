package oop.week5.io;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by fmandryka on 18.02.2017.
 */
public class MyBash implements IBash {

    private File currentDir;


    public MyBash(String path) {

        File currDir = new File(path);

        if (currDir.exists() && currDir.isDirectory()) {
            this.currentDir = currDir;
        } else {
            throw new NoSuchDirectoryExeption("No such directory");
        }
    }

    @Override
    public String pwd() {
        return currentDir.getAbsolutePath();
    }

    @Override
    public String cd(String path) {
        File nextPath = new File(path);

            if (nextPath.isDirectory()) {
                currentDir = nextPath;
                return pwd();
            }

        return null;
    }

    @Override
    public List<File> ls() {

        return Arrays.asList(currentDir.listFiles());
    }

    @Override
    public String cat(String path) throws FileNotFoundException {

        File file = new File(path);

        if (file.isFile() && !file.isAbsolute()) {

            FileReader fileReader = new FileReader(file);
            char[] buffer = new char[1024];
            String result ="";
            try {
                while (fileReader.read(buffer) > 0) {
                    result += String.valueOf(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;

        }

        return null;
    }

    @Override
    public boolean writeInfo(String path, String content) {

        File file = new File(path);




        return false;
    }

    @Override
    public boolean append(String path, String content) {
        return false;
    }

    @Override
    public boolean touch(String path) {
        File file = new File(path);

        // check if file exists, if no - create file
        // in case of absolute path check if last directory exists, if yes - create file
        if (!file.exists() && file.getAbsoluteFile().getParentFile().exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean mkdir(String dirPath) {
        File file = new File(dirPath);

        if (!file.exists() && file.getAbsoluteFile().getParentFile().exists()) {

            file.mkdir();
            return true;
        }

        return false;
    }

    @Override
    public List<File> find(String searchKey, String startPointPath) {
        return null;
    }
}
