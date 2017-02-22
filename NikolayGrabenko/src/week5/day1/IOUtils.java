package week5.day1;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;

public class IOUtils implements IBash {

    private String curDirPath;
    private File curDirectory;

    public IOUtils(File curDirectory) {
        this.curDirectory = curDirectory;
    }

    @Override // вывести имя текущего каталога.
    public String pwd() {
        return curDirectory.getName();
    }

    //cd [каталог] — сменить текущий каталог. Если имя каталога не указывается,
    // то текущим становится домашний каталог пользователя.
    @Override
    public String cd(String path) {
        return curDirPath = path;
    }

    @Override// выдать список файлов в текущем каталоге.
    public List<String> ls() {
        if (curDirectory.isDirectory()) {
            String[] fileList = curDirectory.list();
            return Arrays.asList(fileList);
        } else return null;
    }

    @Override//cat <имя_файла> — вывод содержимого файла на стандартный вывод (по умолчанию — на экран).
    public String cat(String path) throws NoSuchFileException {
        return null;
    }

    @Override    //> return true if file did not exist, false file existed
    public boolean writeInto(String path, String content) {

   return true;
    }

    @Override// >>
    public boolean append(String path, String content) {
        return false;
    }

    @Override// create new file
    public boolean touch(String path) {
        File fileNew = new File(path);
        if (fileNew.isFile()) return true;
        else return false;
    }

    @Override// mkdir create new directory
    public boolean mkdir(String dirPath) {
        File folder = new File(dirPath);
        if (folder.isDirectory()) return true;
        else return false;
    }

    @Override//найти файлы и директории с именем searchKey. Поиск начать с корня (startPointPath)
    public List<File> find(String searchKey, String startPointPath) {
        return null;
    }
}
