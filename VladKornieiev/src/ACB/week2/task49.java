package ACB.week2;

/*
Задать два массива случайными числами от 25 до 75.
Определить у какого из массивов больше парных елементов.
*/
public class task49 {
    public static void main(String[] args) {
        int[] arr1 = new int[50];
        int[] arr2 = new int[50];

        // filling an arrays
        for (int i = 0; i < arr1.length ; i++) {
            arr1[i] = (int) (Math.random()*50) + 25;
            arr2[i] = (int) (Math.random()*50) + 25;
        }

        int count1 = 0;
        int count2 = 0;

        // counting odd numbers in each array
        for (int i = 0; i < arr1.length; i++) {
            count1 += (arr1[i] % 2 == 0) ? 1 : 0;
            count2 += (arr2[i] % 2 == 0) ? 1 : 0;
        }

        int result = count1 > count2 ? 1 : 2;

        System.out.println(result + " array has more odd elements.");
    }
}
