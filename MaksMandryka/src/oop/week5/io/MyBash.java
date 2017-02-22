package oop.week5.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fmandryka on 18.02.2017.
 */
public class MyBash implements IBash {

    private File currentDir;

    public MyBash(String path) {

        File currDir = new File(path);

        if (currDir.exists() && currDir.isDirectory()) {
            this.currentDir = currDir;
        } else {
            throw new NoSuchDirectoryException("No such directory");
        }
    }

    @Override
    public String pwd() {
        return currentDir.getAbsolutePath();
    }

    @Override
    public String cd(String path) {
        File nextPath = new File(path);

            if (nextPath.isDirectory()) {
                currentDir = nextPath;
                return pwd();
            }

        return null;
    }

    @Override
    public List<File> ls() throws IOException {
        return Arrays.stream(currentDir.listFiles())
                .map(File::getAbsoluteFile)
                .collect(Collectors.toList());
    }

    @Override
    public String cat(String path) throws FileNotFoundException {

        File file = new File(path);
        StringBuilder sb = new StringBuilder();

        if (!file.exists()) {
            throw new FileNotFoundException("File not found");
        }

        if (file.isFile()) {
            String line;
            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))){
                while ((line = fileReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
        return null;
    }

    @Override
    public boolean writeInfo(String path, String content) {
        return write(path, content, false);
    }

    @Override
    public boolean append(String path, String content) {
        return write(path, content, true);
    }

    private boolean write(String path, String content, boolean append) {

        File file = new File(path);

        if (file.exists()) {
            try (BufferedWriter fr = new BufferedWriter(new FileWriter(file, append))) {
                fr.write(content);
                fr.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean touch(String path) {
        File file = new File(path);

        // check if file exists, if no - create file
        // in case of absolute path check if last directory exists, if yes - create file
        if (!file.exists() && file.getAbsoluteFile().getParentFile().exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean mkdir(String dirPath) {
        File file = new File(dirPath);

        if (!file.exists() && file.getAbsoluteFile().getParentFile().exists()) {

            file.mkdir();
            return true;
        }
        return false;
    }

    @Override
    public List<File> find(String searchKey, String startPointPath) {
        File startFile = new File(startPointPath);
        List<File> foundFiles = new ArrayList<>();

        if (startFile.isDirectory()) {
            File[] files = startFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (searchKey.toLowerCase().equals(files[i].getName().toLowerCase())) {
                    foundFiles.add(files[i].getAbsoluteFile());
                    if (files[i].isDirectory()) {
                        foundFiles.addAll(ls(files[i]));
                    }
                }
            }
        }
        return foundFiles;
    }


    public List<File> ls(File directory) {

        List<File> foundFiles = new ArrayList<>();

            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                for (int i = 0; i < files.length; i++) {
                    foundFiles.add(files[i].getAbsoluteFile());
                    if (files[i].isDirectory()) {
                        foundFiles.addAll(ls(files[i]));
                    }
                }
            }

        return foundFiles;
    }


}
