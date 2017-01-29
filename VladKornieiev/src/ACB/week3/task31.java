package ACB.week3;
import static ACB.week3.MatrixUtils.*;

/*
Заменить все числа, которые делятся на 5 без остачи в двухмерной матрице на 8
 */



public class task31 {
    public static void main(String[] args) {
        int[][] mat = generateMatrix(10, 10, 10);
        printMatrix(mat);

        for (int i = 0; i < mat.length ; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (mat[i][j] % 5 == 0) ? mat[i][j] = 8 : mat[i][j];
            }
        }
        printMatrix(mat);
    }
}
