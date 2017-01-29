package ACB.week3;

/**
 * Created by vladkorneev on 23.12.16.
 */
public class task33 {
    public static void main(String[] args) {
        // check
        String str1 = "ololo";
        String str2 = "hey";
        String str3 = "!A hOhOh HoHoH a!";

        System.out.println(isPal(str1));
        System.out.println(isPal(str2));
        System.out.println(isPal(str3));

    }

    public static boolean isPal(String str){
        String reversed = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reversed += str.substring(i,i+1);
        }
        return str.toLowerCase().equals(reversed.toLowerCase());
    }
}
