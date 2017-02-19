package ACO.week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.List;

public interface IBash {

    // show current directory
    String pwd();

    // change current directory
    String cd(String path) throws FileNotFoundException;

    // show all in current directory
    List<File> ls();

    String cat(String path) throws NoSuchFileException, FileNotFoundException;

    // >
    // return true if file did not exist, false file existed
    boolean writeInto(String path, String content) throws FileNotFoundException;

    // >>
    boolean append(String path, String content) throws FileNotFoundException;

    // create new file
    boolean touch(String path) throws FileNotFoundException;

    // mkdir create new directory
    boolean mkdir(String dirPath);

    List<File> find(String searchKey, String startPointPath);

}