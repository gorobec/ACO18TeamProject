
import controller.Service;
import model.DataBase;
import model.Product;
import model.Ticket;
import to.Serializer;
import to.SuperFileReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ksyashka on 19.02.2017.
 */
public class RunBestBuy {
    public static void main(String[] args) {
        Product pr1 = new Product("Iron", 1, 300.00);
        Product pr2 = new Product("Cup", 2, 100);
        Product pr3 = new Product("Phone", 3, 3000);
        Product pr4 = new Product("HDD", 4, 1000);
        Product pr5 = new Product("SSD", 5, 2000);
        Map<Integer, Product> baseProd = new HashMap<>();
        Ticket t1 = new Ticket(1, 1, "Kyiv", "4444 4444 4444 4444");
        Map<Integer, Ticket> baseTick = new HashMap<>();
        DataBase db = new DataBase(baseProd,baseTick);
        Service service;
        baseProd.put(pr1.getId(),pr1);
        baseProd.put(pr2.getId(),pr2);
        baseProd.put(pr3.getId(),pr3);
        baseProd.put(pr4.getId(),pr4);
        baseProd.put(pr5.getId(),pr5);
        baseTick.put(t1.getId(),t1);
        service = new Service(db);
        System.out.println(new File(".").getAbsoluteFile());
        Serializer serializer = new Serializer();
        SuperFileReader sp = new SuperFileReader();
        try {
            sp.writeToFile(serializer.convertProductToJson(baseProd));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
