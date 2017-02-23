package view;

import container.*;
import container.IDB.IDataBase;
import container.IDB.IUserDataBase;
import controller.IService;
import controller.ServiceImpl;
import exception.*;
import model.Address;
import model.BankCard;
import model.Product;
import model.Ticket;
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
    private static Scanner sc = new Scanner(System.in);
    private static String token;

    private static final Path productDB = Paths.get("/home/v21k/Java/dev/ACO18TeamProject/Team1/resources/productsDB.txt");
    private static final Path ticketDB = Paths.get("/home/v21k/Java/dev/ACO18TeamProject/Team1/resources/ticketDB.txt");
    private static final Path userDB = Paths.get("/home/v21k/Java/dev/ACO18TeamProject/Team1/resources/userDB.txt");

    public static void initService(IService iService) {
        Product product = new Product(1, "IPhone");
        Product product2 = new Product(2, "Samsung");
        Product product3 = new Product(3, "Xaiomi");

        iService.addProduct(product);
        iService.addProduct(product2);
        iService.addProduct(product3);
    }

    public static int buy(IService iService) throws NoSuchProductException, InvalidTokenException, InvalidInputParameters {
        System.out.println("Choose product ID");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Enter city");
        String city = sc.nextLine();
        System.out.println("Enter street ");
        String street = sc.nextLine();
        System.out.println("Enter house number:");
        int number = Integer.parseInt(sc.nextLine());

        System.out.println("Enter credit cart (12 digits):");
        String creditCardnumber = sc.nextLine();
        System.out.println("Enter cvv2-code");
        int cvv = Integer.parseInt(sc.nextLine());
        System.out.println("Valid until (year and months ): ");
        System.out.println("FORMAT : XXXX-XX");
        String valid = sc.nextLine();

        YearMonth yearMonth = YearMonth.parse(valid);
        BankCard bankCard = new BankCard(creditCardnumber, cvv, yearMonth);
        Address address = new Address(city, street, number);

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
