package view;

import container.ProductDB;
import container.IDataBase;
import controller.IService;
import controller.ServiceImpl;
import exception.InvalidIdException;
import exception.NoSuchProductException;

import java.util.Scanner;

/**
 * Created by v21k on 19.02.17.
 */
public class View {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InvalidIdException, NoSuchProductException {
        IDataBase iDataBase = new ProductDB();
        IService iService = new ServiceImpl(iDataBase);

        ViewUtils.initService(iService);

        boolean exit = false;

        while (!exit){
            viewMenu();
            System.out.println("Hello! What do you want to do? Enter '0' to exit");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println(ViewUtils.showProducts(iService));
                    break;
                case 2:
                    System.out.println(ViewUtils.getProductById(iService));
                    break;
                case 3:
                    System.out.println(ViewUtils.buy(iService));
                    break;
                case 4:
                    System.out.println("Your ticket ID is: " + ViewUtils.getTicketById(iService));
                    break;
                case 6:
                    System.out.println(ViewUtils.register(iService));
                    break;
                case 7:
                    System.out.println(ViewUtils.login(iService));
                    break;
                case 0:
                    System.out.println("Bye");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong input.");
                }

            }

        }

    public static void viewMenu(){
        System.out.println("1. Get all products");
        System.out.println("2. Get products by ID");
        System.out.println("3. Buy");
        System.out.println("4. Show ticket by ID");
        System.out.println("6. Register");
        System.out.println("7. Login");
    }
}


