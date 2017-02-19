package week5.day1.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 * Created by ksyashka on 18.02.2017.
 */
public interface IBash {

    // show current directory
    String pwd();

    // change current directory
    String cd(String path);

    // show all in current directory
    List<File> ls();

    String cat(String path) throws FileNotFoundException, IOException;

    // >
    // return true if file did not exist, false file existed
    boolean writeInto(String path, String content);

    // >>
    boolean append(String path, String content);

    // create new file
    boolean touch(String path) throws IOException;

    // mkdir create new directory
    boolean mkdir(String dirPath);

    List<File> find(String searchKey, String startPointPath);

}
