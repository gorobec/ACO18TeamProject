package view;

import container.IDB.IDataBase;
import container.IDB.IUserDataBase;
import container.ProductDB;
import container.TicketDB;
import container.UserDB;
import controller.IService;
import controller.ServiceImpl;
import exception.*;
import model.*;
import utils.DataBaseConverter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by v21k on 19.02.17.
 */
public class ViewUtils {
    private static final Scanner sc = new Scanner(System.in);
    private static final Path productDB = Paths.get("Team1/resources/database/productsDB.json");
    private static final Path ticketDB = Paths.get("Team1/resources/database/ticketDB.json");
    private static final Path userDB = Paths.get("Team1/resources/database/userDB.json");
    private static String token;

    public static void initService(IService iService) {
        Product product = new Product(1, "IPhone", new Coordinates(50.427994, 30.484166));
        Product product2 = new Product(2, "Samsung", new Coordinates(50.397031, 30.634899));
        Product product3 = new Product(3, "Xaiomi", new Coordinates(50.066428, 31.445213));

        iService.addProduct(product);
        iService.addProduct(product2);
        iService.addProduct(product3);
    }

    public static int buy(IService iService) throws NoSuchProductException, InvalidTokenException, InvalidInputParameters {
        if (iService.getUserByToken(token) == null){
            return -1;
        }

        System.out.println("Choose product ID");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Enter city");
        String city = sc.nextLine();
        System.out.println("Enter street ");
        String street = sc.nextLine();
        System.out.println("Enter house number:");
        int number = Integer.parseInt(sc.nextLine());
        Address address = new Address(city, street, number);

        System.out.println("Enter credit cart (12 digits):");
        String creditCardnumber = sc.nextLine();
        System.out.println("Enter cvv2-code");
        int cvv = Integer.parseInt(sc.nextLine());
        System.out.println("Valid until (year and months ): ");
        System.out.println("FORMAT : XXXX-XX");
        String valid = sc.nextLine();
        YearMonth yearMonth = YearMonth.parse(valid);
        BankCard bankCard = new BankCard(creditCardnumber, cvv, yearMonth);

        int userID = iService.getUserByToken(token).getId();

        return iService.buy(userID, id, address, bankCard);


    }

    public static String getProductById(IService iService) throws InvalidIdException {
        System.out.println("Enter an ID");
        int id = sc.nextInt();
        return iService.getProductById(id).toString();
    }

    public static String getTicketById(IService iService) throws InvalidIdException, UserLoginException {
        System.out.println("Enter an ID");
        int id = sc.nextInt();
        return iService.getTicketById(id, token).toString();
    }

    public static String showProducts(IService iService) {
        return iService.getProducts().stream().map(Object::toString).collect(Collectors.joining());

    }

    public static String register(IService iService) throws InvalidIdException, InvalidInputParameters {

        System.out.println("Enter a name");
        String name = sc.nextLine();
        System.out.println("Enter a password ");
        String pass = sc.nextLine();
        System.out.println("Enter an email:");
        String email = sc.nextLine();

        iService.signUp(name, pass, email);

        return "OK";

    }

    public static String login(IService iService) throws InvalidIdException, InvalidInputParameters {

        System.out.println("Enter a name");
        String name = sc.nextLine();
        System.out.println("Enter a password ");
        String pass = sc.nextLine();

        token = iService.logIn(name, pass);
        return token != null ? "OK" : "FAILED";
    }

    public static String logOut(){
        token = "";
        return "OK";
    }

    public static void save(IService iService) throws IOException {
        DataBaseConverter.saveToFile(iService.getProductDB(), productDB);
        DataBaseConverter.saveToFile(iService.getTicketDB(), ticketDB);
        DataBaseConverter.saveToFile(iService.getUserDB(), userDB);
    }

    public static IService load() throws IOException {
        IDataBase<Product> products = DataBaseConverter.loadFromFile(productDB, ProductDB.class);
        IDataBase<Ticket> tickets = DataBaseConverter.loadFromFile(ticketDB, TicketDB.class);
        IUserDataBase users = DataBaseConverter.loadFromFile(userDB, UserDB.class);

        return new ServiceImpl(products, tickets, users);
    }
}
