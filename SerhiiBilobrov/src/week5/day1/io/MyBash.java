package week5.day1.io;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class MyBash implements IBash {
    
    private File currentDir;

    public MyBash(String path) {
        File currentDir = new File(path);

        if (currentDir.exists() && currentDir.isDirectory()) {
            this.currentDir = currentDir;
        } else {
            throw new NoSuchDirectoryException("No such directory");
        }


    }

    @Override
    public String pwd() {
        return currentDir.getAbsolutePath();
    }

    // file1 , /home/serhii/file1, D:\home\serhii\file1
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
    public boolean touch(String path) {
        return false;
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
