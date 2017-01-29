package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Написать программу вычисления стоимости переговоров, если по суббо-
 там и воскресеньям предоставляется 20% скидка. Ввести продолжитель-
 ность разговора и день недели (цифра от 1 до 7).
 */
public class Task_4_2_10 {
    public static void main(String args[]){
        double price = 1.5;
        Scanner sc = new Scanner(System.in);
        int Time = sc.nextInt();
        int Day = sc.nextInt();

        if (Day == 6 || Day ==7) {
            System.out.println("Стоимость переговоров " + (Time*price*0.8) + " грн");
        } else {
            System.out.println("Стоимость переговоров " + (Time*price) + " грн");
        }
        sc.close();
    }
}
