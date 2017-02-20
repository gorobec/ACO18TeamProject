package ACO.week5;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        File newPath = getFile(path);

        if (newPath.isDirectory()) {
            currentDir = newPath;
            return pwd();
        }
        return null;
    }

    @Override
    public List<File> ls() {
        return Arrays.stream(currentDir.listFiles()).collect(Collectors.toList());
    }

    @Override
    public boolean mkdir(String dirPath) {
        return getFile(dirPath).mkdir();
    }

    @Override
    public String cat(String path) throws NoSuchFileException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        File file = getFile(path);

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
    public boolean touch(String path) throws IOException {
        return getFile(path).createNewFile();
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
    public List<File> find(String searchKey, String startPointPath) throws IOException {

        return Files.walk(Paths.get(getFile(startPointPath).getAbsolutePath()))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .filter(s -> s.getAbsolutePath().toLowerCase()
                        .startsWith(getFile(searchKey).getAbsolutePath().toLowerCase()))
                .collect(Collectors.toList());

    }

    private boolean write(String path, String content, boolean appendFlag) throws FileNotFoundException {
        File file = getFile(path);

        if (content != null) {
            try (Writer wr = new PrintWriter(new BufferedWriter(new FileWriter(file, appendFlag)))) {
                if (appendFlag) {
                    wr.append("\n").append(content);
                } else {
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

    private File getFile(String path) {
        File file = new File(path);
        return file.isAbsolute() ? file : new File(pwd() + "/" + path);
    }
}
