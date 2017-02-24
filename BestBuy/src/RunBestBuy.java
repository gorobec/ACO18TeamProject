
import controller.BestBuy;
import dao.IDataBase;
import dao.MapDataBase;
import view.LoginWindow;

public class RunBestBuy {

    public static void main(String[] args) {

        BestBuy service = new BestBuy(new MapDataBase());
        service.loadDatabase();

        LoginWindow log = new LoginWindow(service);

        //этот метод надо вызвать при закрытии формы
//        service.saveDatabase();
    }
}
