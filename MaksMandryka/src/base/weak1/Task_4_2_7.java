package base.weak1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Ввести с экрана число от 1 до 12. По номеру месяца выдать сообщение о
 времени года. Если пользователь введет недопустимое число, программа
 должна выдать сообщение об ошибке.
 */
public class Task_4_2_7 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(1,"Winter");
        hmap.put(2,"Winter");
        hmap.put(3,"Spring");
        hmap.put(4,"Spring");
        hmap.put(5,"Spring");
        hmap.put(6,"Summer");
        hmap.put(7,"Summer");
        hmap.put(8,"Summer");
        hmap.put(9,"Autumn");
        hmap.put(10,"Autumn");
        hmap.put(11,"Autumn");
        hmap.put(12,"Winter");

            if (hmap.get(M) != null) {
                System.out.println(hmap.get(M));
            } else {
                System.out.println("Error");
            }

        sc.close();
    }
}
