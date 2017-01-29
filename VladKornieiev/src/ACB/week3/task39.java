package ACB.week3;

import static ACB.week2.ArrayUtils.printArr;
import static ACB.week3.MatrixUtils.generateMatrix;
import static ACB.week3.MatrixUtils.printMatrix;

/**
 * Created by vladkorneev on 25.12.16.
 */
public class task39 {
    public static void main(String[] args) {

           int[][] a = generateMatrix(3,5,5);
           int[][] b = generateMatrix(5,10,10);

           printMatrix(a);
           printMatrix(b);

           int[][] c = matrixMultiply(a,b);

           printMatrix(c);

    }

    public static int[][] matrixMultiply(int[][] matrixA, int[][] matrixB) {
        int[][] result = new int[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length ; i++) {

            for (int j = 0; j < matrixB[i].length ; j++) {
                // getting temp array of matrixB (we need column #<j>)
                int[] temp = tempArray(matrixB, j);
                // storing result = (row #i from matrix A) * (column #j from matrixB)
                result[i][j] = multArrays(matrixA[i], temp);
            }
        }

        return result;
    }

    // to get temp arr for multiplying
    public static int[] tempArray(int[][] matrix, int position){
            int[] temp = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                temp[i] = matrix[i][position];
            }
            return temp;
        }

    // multiplying 2 arrays (array1*array2 == x[i][j] element in output matrix)
    public static int multArrays (int[] a, int[] b){
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i]*b[i];
        }
        return result;

    }
}

