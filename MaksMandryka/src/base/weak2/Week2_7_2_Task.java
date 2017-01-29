package base.weak2;

/**
 * Created by Администратор on 13.12.2016.
 * Проверить или является число простым
 */
public class Week2_7_2_Task {

    public static void main(String[] args) {

        int number = 101;
        boolean isSimple = true;

        for (int i = number - 1; i > 1 && isSimple; i--) {
            if (number % i == 0) {
                isSimple = false;
            }
        }

        System.out.println("Число " + number + " простое? " + isSimple);
    }
}
