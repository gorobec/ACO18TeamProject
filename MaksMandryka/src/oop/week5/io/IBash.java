package oop.week5.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by fmandryka on 18.02.2017.
 */
public interface IBash {

    //show current directory
    String pwd();

    //change current directory
    String cd(String path);

    //show all in current directory
    List<File> ls();

    String cat(String path) throws FileNotFoundException;

    //>
    //return true if file didn't exist, false existed
    boolean writeInfo(String path, String content);

    //>>
    boolean append(String path, String content);

    //create new file
    boolean touch(String path);

    //mkdir create new directory
    boolean mkdir(String dirPath);

    List<File> find(String searchKey, String startPointPath);
}
