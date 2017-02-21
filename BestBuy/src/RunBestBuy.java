
import controller.BestBuy;
import to.DataBaseHelper;
import view.LoginWindow;

public class RunBestBuy {

    public static void main(String[] args) {


        DataBaseHelper dbHelper = new DataBaseHelper();

        dbHelper.loadDataBase();

        BestBuy service = new BestBuy(dbHelper.getDb());

        LoginWindow log = new LoginWindow(service);

        dbHelper.unloadDataBase();
    }
}
