package ACB.week2;

import java.util.Scanner;
import static ACB.week2.ArrayUtils.generateMas;

/*
Посчитать сколько цифр(цифра задается пользователем) в массиве
 */
public class task44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int counter = 0;
        int[] arr = generateMas(50, 10);

        for (int element : arr) {
            counter += (element == number) ? 1 : 0;
        }


        System.out.println("The number " + number + " repeats "
                + counter + " time(s).");
    }
}
