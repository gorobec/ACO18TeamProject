package to;

import dao.MapDataBase;
import model.Product;
import model.Ticket;
import model.User;

import java.io.IOException;
import java.util.Map;

public class MapDataBaseHelper {

    private MapDataBase db;

    private static String FILE_FOR_PRODUCTS = "BestBuy/resources/database_products.txt";
    private static String FILE_FOR_TICKETS = "BestBuy/resources/database_tickets.txt";
    private static String FILE_FOR_USERS = "BestBuy/resources/database_users.txt";

    private FileHelper fh = new FileHelper();
    private Serializer<Integer,Product> serProd = new Serializer<>();
    private Serializer<Integer,Ticket> serTicket = new Serializer<>();
    private Serializer<String,User> serUser = new Serializer<>();


    public MapDataBase getDb() {
        return db;
    }

    public void loadDataBase(){

        String jsonProduct = null;
        String jsonTicket = null;
        String jsonUser = null;

        try {
            jsonProduct = fh.readFromFile(FILE_FOR_PRODUCTS);
            jsonTicket = fh.readFromFile(FILE_FOR_TICKETS);
            jsonUser = fh.readFromFile(FILE_FOR_USERS);
        }catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, Product> baseProd = serProd.convertJsonToProduct(jsonProduct);
        Map<Integer, Ticket> baseTick = serTicket.convertJsonToTicket(jsonTicket);
        Map<String, User> baseUser = serUser.convertJsonToUser(jsonUser);

        db = new MapDataBase(baseProd, baseTick,baseUser);
    }

    public void unloadDataBase(){

        try {
            fh.writeToFile(serProd.convertObjectToJson(db.getAllProducts()), FILE_FOR_PRODUCTS);
            fh.writeToFile(serTicket.convertObjectToJson(db.getAllTickets()), FILE_FOR_TICKETS);
            fh.writeToFile(serUser.convertObjectToJson(db.getAllUsers()), FILE_FOR_USERS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
