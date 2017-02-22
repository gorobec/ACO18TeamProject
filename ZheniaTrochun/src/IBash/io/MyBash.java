package IBash.io;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenia on 18.02.17.
 */
public class MyBash implements IBash{

    private String currentPath;

    public MyBash(){
        currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);
    }

    @Override
    public String cat(String path) throws IOException {
        if(path == null) return null;

        File myFile = new File(path);

        try{
            if(!myFile.isFile()) throw new NoSuchFileException("Invalid path");

            BufferedReader rd = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();

            String str = "";

            while ((str = rd.readLine()) != null){
                sb.append(str + "\n");
            }

            rd.close();

            return sb.toString();
        } catch (FileNotFoundException e){

            throw new NoSuchFileException("File not found");
        }
    }

    @Override
    public String pwd() {
        return currentPath;
    }

    @Override
    public String cd(String path) {
        if(path == null) return null;

        File file = new File(path);

        if(!file.exists()) return null;

        if(file.isAbsolute()) currentPath = path;
        else currentPath += "/" + path;

        return currentPath;
    }

    @Override
    public List<File> ls() {
        File currDir = new File(currentPath);

        if(!currDir.isDirectory()) return null;

        List<File> res = new ArrayList<>();

        for (File file : currDir.listFiles()) {
            res.add(file);
            System.out.println(file.getName());
        }

        return res;
    }

    private File absolutisePath(String path){
        File file = new File(path);

        if(!file.isAbsolute()){
            path = currentPath + "/" + path;
            file = new File(path);
        }

        return file;
    }

    @Override
    public boolean writeInto(String path, String content) {
        if(path == null || path.length() == 0) return false;

        File file = absolutisePath(path);

        if(file.isDirectory()) return false;

        Writer writer = null;

        try{
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), "utf-8"));
            writer.write(content);
        }catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                writer.close();
            } catch (IOException e){
                System.out.println("Error with closing file");
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean append(String path, String content) {
        File file = absolutisePath(path);

        if(file.isDirectory()) return false;

        FileWriter printer = null;

        try {
            printer = new FileWriter(file.getPath(), true);

            printer.append(content);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                printer.close();
            } catch (IOException e){

            }
        }

        return true;
    }

    @Override
    public boolean touch(String path) {
        if(path == null || path.length() == 0) return false;

        return writeInto(path, "");
    }

    @Override
    public boolean mkdir(String dirPath) {
        if(dirPath == null || dirPath.length() == 0) return false;

        File file = new File(dirPath);

        if(!file.isAbsolute()){
            dirPath = currentPath + "/" + dirPath;
            file = new File(dirPath);
        }

        if(file.exists()) return false;

        if(file.getName().indexOf(".") != -1) return false;

        file.mkdir();

        return true;
    }

    @Override
    public List<File> find(String searchKey, String startPointPath) throws InvalidPathException {
        if(searchKey == null || searchKey.length() == 0) return null;

        if(cd(startPointPath) == null) throw new InvalidPathException(startPointPath,
                "Directory don't exists or not enough rights");

        File file = absolutisePath(startPointPath);

        if(file.isFile()) return null;

        List<File> res = null;

        for (File f : file.listFiles()) {
            if(f.getName().equals(searchKey)){
                if(res == null) res = new ArrayList<>();

                res.add(f);
            }

            List<File> tmp = find(searchKey, f.getPath());

            if(tmp != null){
                for (File resFile : tmp) {
                    if(res == null){
                        res = new ArrayList<>();
                    }

                    res.add(resFile);
                }
            }
        }

        return res;
    }
}
