package ACB.week3;

import java.util.Scanner;
import static ACB.week3.MatrixUtils.printMatrix;

/*
Повернуть матрицу(Двухмерный массив). Матрица квадратная.
Пользователь вводит угол кратный 90.
*/
public class task42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter degree: ");
        int degree = sc.nextInt();

        // test matrix, works good with bigger ones too.
        int[][] matrix =    {{1,2,3},
                            {4,5,6},
                            {7,8,9}};

        printMatrix(matrix);
        printMatrix(rotateMatrix(matrix, degree));
    }

    public static int[][] rotateMatrix(int[][] matrix, int degree) {
        int[][] result = matrix;

        if (degree == 0 || degree % 90 != 0) {
            return result;
        } else {
            result = rotate90(matrix);
            while (degree != 90) {
                result = rotate90(result);
                degree -= 90;
            }
        }
        return result;
    }

    public static int[][] rotate90(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            // saving last row
            int temp[] = matrix[matrix.length-i-1];
            // moving last row ---> first column
            for (int j = 0; j < matrix.length ; j++) {
                result[j][i] = temp[j];
            }
        }
        return result;
    }
}
