package ACO.week5.day1;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by v21k on 18.02.17.
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

    @Override
    public String cd(String path) throws FileNotFoundException {
        File newPath = check(path);

        if (newPath.isDirectory()) {
            currentDir = newPath;
            return pwd();
        }
        return null;
    }

    @Override
    public List<File> ls() {
        return currentDir.listFiles() == null ?
                null : Arrays.stream(currentDir.listFiles()).collect(Collectors.toList());
    }

    @Override
    public boolean mkdir(String dirPath) {
        if (dirPath != null) {
            File file = new File(dirPath);
            if (!file.exists()) {
                return file.mkdir();
            }
        }
        return false;
    }

    @Override
    public String cat(String path) throws NoSuchFileException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = check(path);

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {

            String temp;
            while ((temp = bf.readLine()) != null) {
                sb.append(temp).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString().trim();
    }

    @Override
    public boolean writeInto(String path, String content) throws FileNotFoundException {
        return write(path, content, false);
    }

    @Override
    public boolean append(String path, String content) throws FileNotFoundException {
        return write(path, content, true);
    }

    @Override
    public boolean touch(String path) throws FileNotFoundException {
        File file = check(path);
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<File> find(String searchKey, String startPointPath) {
        return null;
    }

    private boolean write(String path, String content, boolean appendFlag) throws FileNotFoundException {
        File file = check(path);
        if (content != null) {
            try (Writer wr = new PrintWriter(new BufferedWriter(new FileWriter(file, appendFlag)))) {
                if (appendFlag) {
                    wr.append("\n").append(content);
                } else{
                    wr.write(content);
                }
                wr.flush();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private File check(String path) throws FileNotFoundException {
        File file = new File(path);
        File file1 = new File(currentDir + "/" + path);

        if (file.exists()) {
            return file;
        } else if (file1.exists()) {
            return file1;
        } else {
            throw new FileNotFoundException();
        }
    }
}
