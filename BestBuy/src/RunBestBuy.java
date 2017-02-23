
import controller.BestBuy;
import to.MapDataBaseHelper;
import view.LoginWindow;

public class RunBestBuy {

    public static void main(String[] args) {


        BestBuy service = new BestBuy();
        service.loadDatabase();

        LoginWindow log = new LoginWindow(service);

        //этот метод надо вызвать при закрытии формы
//        service.saveDatabase();
    }
}
