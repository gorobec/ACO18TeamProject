package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Известны две скорости, одна в километрах в час, другая в метрах в секун-
 ду. Какая из них больше?
 */
public class Task_4_2_4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double V1 = sc.nextDouble();
        double V2 = sc.nextDouble();
        V1 = V1*1000/60/60; //Переводим в м/с

        if (V1>V2) {
            System.out.println("V1>V2");
        } else if (V1<V2){
            System.out.println("V1<V2");
        } else {
            System.out.println("V1=V2");
        }
        sc.close();
    }
}
