
import controller.Service;
import model.DataBase;
import model.Product;
import model.Ticket;
import to.DataBaseHelper;
import to.Serializer;
import to.FileHelper;
import view.ViewBestBuy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RunBestBuy {

    public static void main(String[] args) {


        DataBaseHelper dbHelper = new DataBaseHelper();
        dbHelper.loadDataBase();

        Service service= new Service(dbHelper.getDb());

        ViewBestBuy viewBestBuy = new ViewBestBuy(service);

        dbHelper.unloadDataBase();
    }
}
