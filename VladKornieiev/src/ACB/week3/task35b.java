package ACB.week3;

import static ACB.week3.MatrixUtils.generateMatrix;
import static ACB.week3.MatrixUtils.printMatrix;

/*
а) Поменять наибольшую строку массива с наименьшей в двухмерном массиве.
(Размер - сумма элементов в строке)
b) Поменять наибольший и наименьший столбик в двухмерном массиве.
*/

public class task35b {
    public static void main(String[] args) {
        // PART B in this task
        int range = 5;
        int rows = 2;
        int cols = 5;
        int[][] mat = generateMatrix(rows,cols,range);

        int max = mat[0][0];
        int maxIndex = 0;
        int min = range+1;
        int minIndex = 0;

        // looking for min/max.
        for (int i = 0; i < mat[0].length; i++) {
            int sumMax = 0;
            int sumMin = 0;
            for (int j = 0; j < mat.length; j++) {
                sumMax += mat[j][i];
                sumMin += mat[j][i];
            }
            max = (sumMax > max) ? sumMax : max;
            maxIndex = (sumMax == max) ? i : maxIndex;
            min = (sumMin < min) ? sumMin : min;
            minIndex = (sumMin == min) ? i : minIndex;
        }

        // check existing matrix
        printMatrix(mat);
        System.out.println(maxIndex + ", " + minIndex);

        // swap
        for (int i = 0; i < mat.length; i++) {
            int temp = mat[i][maxIndex];
            mat[i][maxIndex] = mat[i][minIndex];
            mat[i][minIndex] = temp;
        }

        // check
        printMatrix(mat);

    }
}
