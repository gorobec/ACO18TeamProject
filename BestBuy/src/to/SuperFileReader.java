package to;

import java.io.*;

/**
 * Created by ksyashka on 19.02.2017.
 */
public class SuperFileReader {

    public String readFromFile() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("BestBuy/resources/database.txt"));
        StringBuilder result = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null)
                result.append(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        return result.toString();
    }


    public boolean writeToFile(String str) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("BestBuy/resources/database.txt");
            bw = new BufferedWriter(fw);
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            bw.close();
            fw.close();
        }
        return true;
    }
}
