package ACB.week2;

import java.util.Scanner;

/*
Посчитать колличество букв 'a' в строке (искомый символ может быть разным)
 */
public class task73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a char: ");
        String ch = sc.next();

        int count = 0;

        String test = "dhfskdfhbvkjshuhfhlsaasdfasfdsjkfhdsfkljsaaaasdfs"; // a-7

        for (int i = 0; i < test.length(); i++) {
            count += (test.substring(i,i+1).equals(ch)) ? 1 : 0;
        }

        System.out.println("Char " + ch + " found in text " + count + " times.");
    }
}
