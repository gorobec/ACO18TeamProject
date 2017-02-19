package week5;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

public interface Bash {

    String less(String path) throws NoSuchFileException;

    // show cd
    String pwd();

    // show all in the cd
    List<File> ls();

    // change cd
    String cd(String path);

    String cat(String path) throws IOException;

    // return true if the fils NOT exists, return false if filse exists
    boolean writeInto(String path, String content);

    // >>
    boolean append(String path, String content);

    // create new File
    boolean touch(String path);

    // mkdir create new directory
    boolean mkdir(String dirPath);


}
