package view;

import controller.IService;
import exception.InvalidIdException;
import model.Address;
import model.Product;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by v21k on 19.02.17.
 */
public class ViewUtils {
    private static Scanner sc = new Scanner(System.in);

    public static boolean buy(IService iService){
        System.out.println("Choose product ID");
        int id = sc.nextInt();

        System.out.println("Enter city");
        String city = sc.nextLine();
        System.out.println("Enter street ");
        String street = sc.nextLine();
        System.out.println("Enter house number:");
        int number = sc.nextInt();
        System.out.println("Enter credit cart (12 digits):");
        String creditCard = sc.nextLine();
        Address address = new Address(city, street, number);

        return iService.buy(id, address, creditCard);
    }

    public static String getProductById(IService iService) throws InvalidIdException {
        System.out.println("Enter an ID");
        int id = sc.nextInt();
        return iService.getProductById(id).toString();
    }

    public static String getTicketById(IService iService){
        System.out.println("Enter an ID");
        int id = sc.nextInt();
        return iService.getTicketById(id).toString();
    }

    private static String showProducts(IService iService){
       return iService.getProducts().stream().map(Object::toString).collect(Collectors.joining());

    }
}
