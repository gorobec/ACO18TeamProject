package ACB.week3;

/*
Создать массив, который будет состоять из диагонали матрици
*/

import static ACB.week2.ArrayUtils.printArr;
import static ACB.week3.MatrixUtils.generateMatrix;
import static ACB.week3.MatrixUtils.printMatrix;

public class task34 {
    public static void main(String[] args) {
        int[][] mat = generateMatrix(5,5,5);
        int[] output = new int[mat.length];

        printMatrix(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length ; j++) {
                output[i] = (i == j) ? mat[i][j] : output[i];
            }
        }

        printArr(output);

    }
}
