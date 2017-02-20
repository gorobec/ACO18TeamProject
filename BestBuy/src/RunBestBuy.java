
import controller.Service;
import model.DataBase;
import model.Product;
import model.Ticket;
import to.Serializer;
import to.SuperFileReader;
import view.ViewBestBuy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RunBestBuy {
    public static void main(String[] args) {


        Product pr1 = new Product("Iron", 1, 300.00);
        Product pr2 = new Product("Cup", 2, 100);
        Product pr3 = new Product("Phone", 3, 3000);
        Product pr4 = new Product("HDD", 4, 1000);
        Product pr5 = new Product("SSD", 5, 2000);

        Map<Integer, Product> baseProd = new HashMap<>();

        Ticket t1 = new Ticket(1, 1, "Kyiv", "4444 4444 4444 4444");
        Ticket t2 = new Ticket(2, 5, "Kyiv", "4444 5555 4444 4444");

        Map<Integer, Ticket> baseTick = new HashMap<>();

        DataBase db = new DataBase(baseProd,baseTick);

        Service service= new Service(db);

        db.addProduct(pr1);
        db.addProduct(pr2);
        db.addProduct(pr3);
        db.addProduct(pr4);
        db.addProduct(pr5);

        db.addTicket(t1);
        db.addTicket(t2);

        ViewBestBuy viewBestBuy = new ViewBestBuy(service);


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
