package IBash.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.List;

/**
 * Created by zhenia on 18.02.17.
 */
public interface IBash {
    String cat(String path) throws IOException;

    String pwd();

    String cd(String path);

    List<File> ls();

    // >
    // retunt true if file did not exists, false file existed
    boolean writeInto(String path, String content);

    // >>
    boolean append(String path, String content);

    // create new file
    boolean touch(String path);

    // create new directory
    boolean mkdir(String dirPath);

    List<File> find(String searchKey, String startPointPath) throws InvalidPathException;
}
