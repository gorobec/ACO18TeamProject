package ACO.week5.day1;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Created by v21k on 18.02.17.
 */
public class TestIO {


    public static void main(String[] args) throws IOException {
        appendToFile("some NEW text");
    }

    private static void readFromFileExample() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/v21k/testIO/somefile.txt"));
        String s;
        StringBuilder stringBuilder = new StringBuilder();

        while ((s = br.readLine()) != null) {
            stringBuilder.append(s).append("\n");
        }
        br.close();
        System.out.println(stringBuilder.toString());
    }

    private static void readStdInExample() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a line");
        System.out.println(br.readLine());
    }

    private static void readFromMemory() throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("/home/v21k/testIO/newfile3.txt"));
        while (in.available() > 0) {
            System.out.print((char) in.read());
        }

    }
    //byte
    private static void writeToFile() {
        FileOutputStream fop = null;
        File file;
        String toWrite = "some string i want to write";

        try {
            file = new File("/home/v21k/testIO/newfile.txt");
            fop = new FileOutputStream(file);

            if (!file.exists()) {
                file.createNewFile();
            }

            byte[] strToByte = toWrite.getBytes();

            fop.write(strToByte);
            fop.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fop != null) {
                try {
                    fop.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // string
    private static void writeToFile2() {
        String s = "Some super cool string to write in a file";
        String temp;

        try (BufferedReader bf = new BufferedReader(new StringReader(s));
             Writer pw = new PrintWriter(new BufferedWriter(new FileWriter("/home/v21k/testIO/newfile2.txt")))) {

            while ((temp = bf.readLine()) != null) {
                pw.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDataToFile() {
        DataOutputStream dt = null;

        try {
            dt = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("/home/v21k/testIO/newfile3.txt")));

            dt.writeDouble(2.22);
            dt.writeUTF("Some text");
            dt.write(333);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dt != null)
                    dt.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void appendToFile(String s){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/v21k/testIO/newfile.txt", true))) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
