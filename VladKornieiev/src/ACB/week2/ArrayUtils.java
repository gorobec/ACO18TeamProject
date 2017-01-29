package ACB.week2;

public class ArrayUtils {


    public static void printArr(int[] arr){
        // fori
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void printArr(String[] arr){
        // fori
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ";");
        }
        System.out.println();

    }


    public static int[] generateMas(int size, int range){
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = genRandomNum(range);
        }

        return mas; // end method

        //System.out.println("sdfdsf");

    }

    public static int genRandomNum(int range) {
        return (int)(Math.random() * range);
    }


    public static int[] genRandomMasEvenNum(int size, int range){
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            int random = genRandomNum(range);
            // ternary operator
            mas[i] = random % 2 == 0 ? random : random + 1;
        }

        return mas;
    }

    public static int[] genRandomMasOddNum(int size, int range){
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            int random = genRandomNum(range);
            // ternary operator
            mas[i] = random % 2 != 0 ? random : random + 1;
        }

        return mas;
    }

    public static String convert(int[] mas){
        String res = "";
        for (int i = 0; i < mas.length; i++) {
            res = res + mas[i] + ",";
        }
        return res;
    }


}