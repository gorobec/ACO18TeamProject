package ACB.week3;

import java.util.Scanner;

/*
Строки. Ввод пароля.
		Написать программу ввода пароля пользователя. Пользователь вводит
		пароль 2 раза. Пароль должен удовлетворять следующим требованиям:
		- длинна пароля должна быть от 8 до 20 символов
		- в пароле должны быть как маленькие так и большие буквы
		- должны быть цифры
		- не должен содержать слов 'password', 'pass', 'gfhjkm'
		- генерировать случайный пароль используя символы: a-z A-Z 0-9
 */
public class task43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        System.out.print("Enter again: ");
        String password2 = sc.nextLine();



        if (password.equals(password2) && checkPass(password)) {
            System.out.println("Good!"); // check (true if okay)
        } else {
            System.out.println("Bad pass!");
        }

        // check for password generator
        System.out.println("Recommendation: " + generatePass(8));
        int i = 343432423;
        short b = (short) i;

    }

    public static boolean checkPass(String pass) {
        return !((pass.length() < 8 || pass.length() > 20) ||
                pass.toUpperCase().equals(pass) || pass.toLowerCase().equals(pass) ||
                pass.matches("^\\D*$") ||
                pass.contains("password") ||
                pass.contains("pass") ||
                pass.contains("gfhjkm"));
    }

    public static String generatePass(int passLen){
        if (passLen < 8) return "too short";
        String password = "";

        // array of symbol strings
        String[] symbols = {"abcdefghijklmnopqrstuvwxyz",
                            "abcdefghijklmnopqrstuvwxyz".toUpperCase(),
                            "0123456789"};

        // sequence of indexes (which symbol string to use). If not
        // contains all indexes (0,1,2) - loop again (as we need all 3(lower, upper, digit) symbols).
        int[] seq = passSeq(passLen);
        while(  !containsIndex(seq, 0) ||
                !containsIndex(seq, 1) ||
                !containsIndex(seq, 2)      ) {
            seq = passSeq(passLen);
        }

        // filling pass
        for (int i = 0; i < passLen; i++) {
            // choosing an element from symbols string (array[seq[i]]).
            int elementIndex = (int) (Math.random() * symbols[seq[i]].length());
            // adding an symbol from choosen string
            password += symbols[seq[i]].substring(elementIndex, elementIndex+1);
        }
        return password;
    }

    // creating an array with sequence of random numbers
    // in range (0,3). It used to get a random
    // element from 3 arrays (lower, upper, digits).
    public static int[] passSeq(int passLen) {
        int[] seq = new int[passLen];
        for (int i = 0; i < seq.length ; i++) {
            seq[i] = (int) (Math.random() * 3);
        }
        return seq;
    }

    // method to check if value in array.
    // to check if all indexes (0,1,2) in array for password generator
    public static boolean containsIndex(int[] array, int index){
        for (int element : array) {
            if(element==index){
                return true;
            }
        }
        return false;
    }
}
