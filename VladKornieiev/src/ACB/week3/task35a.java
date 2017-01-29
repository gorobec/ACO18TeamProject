package ACB.week3;

import static ACB.week3.MatrixUtils.generateMatrix;
import static ACB.week3.MatrixUtils.printMatrix;

/*
а) Поменять наибольшую строку массива с наименьшей в двухмерном массиве.
(Размер - сумма элементов в строке)
b) Поменять наибольший и наименьший столбик в двухмерном массиве.
 */
public class task35a {
    public static void main(String[] args) {
        // PART A in this task
        int range = 5;
        int rows = 3;
        int cols = 5;
        int[][] mat = generateMatrix(rows,cols,range); // range to generate rand matrix
        int max = mat[0][0];
        int maxIndex = 0;
        int min = range+1;
        int minIndex = 0;

        // looking for min/max
        for (int i = 0; i < mat.length; i++) {
            int sumMax = 0;
            int sumMin = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sumMax += mat[i][j];
                sumMin += mat[i][j];
            }
            max = (sumMax > max) ? sumMax : max;
            maxIndex = (sumMax == max) ? i : maxIndex;
            min = (sumMin < min) ? sumMin : min;
            minIndex = (sumMin == min) ? i : minIndex;
        }

        printMatrix(mat);

        // swap
        int[] temp = mat[maxIndex];
        mat[maxIndex] = mat[minIndex];
        mat[minIndex] = temp;

        // check
        printMatrix(mat);
    }
}
