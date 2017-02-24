
<<<<<<< HEAD
import controller.Service;
import model.DataBase;
import model.Product;
import model.Ticket;
import to.DataBaseHelper;
import to.Serializer;
import to.FileHelper;
=======
import controller.BestBuy;
import dao.IDataBase;
import dao.MapDataBase;
>>>>>>> c76d27dd9d564296fd56155b5fa253888c031950
import view.LoginWindow;
import view.RegistrationWindow;
import view.ViewBestBuy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RunBestBuy {

    public static void main(String[] args) {

<<<<<<< HEAD

        DataBaseHelper dbHelper = new DataBaseHelper();

        dbHelper.loadDataBase();

        Service service = new Service(dbHelper.getDb());
=======
        BestBuy service = new BestBuy(new MapDataBase());
        service.loadDatabase();
>>>>>>> c76d27dd9d564296fd56155b5fa253888c031950

        LoginWindow log = new LoginWindow(service);

        dbHelper.unloadDataBase();
    }
}
