package oop.week5.io;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by fmandryka on 18.02.2017.
 */
public class MyBash implements IBash {

    private File currentDir;

    public MyBash(String currentPath) {

        File currDir = new File(currentPath);

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
        if (nextPath.isAbsolute()) {
            if (nextPath.isDirectory()) {
                currentDir = nextPath;
                return pwd();
            }

        } else {
            if (nextPath.isDirectory()) {
                currentDir = nextPath;
                return pwd();
            }
        }
        return null;
    }

    @Override
    public List<File> ls() {

        return Arrays.asList(currentDir.listFiles());
    }

    @Override
    public String cat(String path) throws NoSuchElementException {
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


        return false;
    }

    @Override
    public boolean mkdir(String dirPath) {
        File file = new File(dirPath);

        if (!file.exists()) {

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
