package ACB.week3;

import static ACB.week3.MatrixUtils.printMatrix;

/*
Создать логическую матрицу по следующим критериям,
если і равно j, то элементом будет true
 */
public class task32 {
    public static void main(String[] args) {
        boolean[][] mat = new boolean[5][5];

        for (int i = 0; i < mat.length ; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (i == j) ? true : mat[i][j];
            }
        }
        // check
        printMatrix(mat);
    }


}
