package ACB.week1;

import java.util.Scanner;

/*
4) Известны две скорости, одна в километрах в час, другая в метрах в секун-
ду. Какая из них больше?
*/

public class task54 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double kmPerHour, mPerSec;
        System.out.print("Enter km per hour speed: ");
        kmPerHour = sc.nextDouble();
        System.out.print("Enter m per seconds speed: ");
        mPerSec = sc.nextDouble();

        if (kmPerHour > mPerSec/1000*3600) {
            System.out.println(kmPerHour + " km per hour is bigger");
        } else {
            System.out.println(mPerSec + " m per seconds is bigger" );
        }
    }
}
