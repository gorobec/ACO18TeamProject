package to;

import java.io.*;

/**
 * Created by ksyashka on 19.02.2017.
 */
public class FileHelper {

    public String readFromFile(String path) throws IOException{
        StringBuilder result = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null)
                result.append(line);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result.toString();
    }


    public boolean writeToFile(String str, String path) throws IOException{

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
