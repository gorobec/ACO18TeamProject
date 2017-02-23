
import controller.BestBuy;
import to.MapDataBaseHelper;
import view.LoginWindow;

public class RunBestBuy {

    public static void main(String[] args) {


        MapDataBaseHelper dbHelper = new MapDataBaseHelper();

        dbHelper.loadDataBase();

        BestBuy service = new BestBuy(dbHelper.getDb());

        LoginWindow log = new LoginWindow(service);

        dbHelper.unloadDataBase();
    }
}
