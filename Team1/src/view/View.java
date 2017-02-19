package view;

import controller.DB;
import controller.IDataBase;
import controller.IService;

/**
 * Created by v21k on 19.02.17.
 */
public class View {
    public static void main(String[] args) {
        IDataBase iDataBase = new DB();
        IService iService = new ServiceImpl(DB);

        boolean exit = false;

        while (!exit){
            viewMenu();
        }
    }

    public static void viewMenu(){
        System.out.println("1. Get all products");
        System.out.println("2. Get products by ID");
        System.out.println("3. Buy");
        System.out.println("4. Show ticket by ID");
    }
}


