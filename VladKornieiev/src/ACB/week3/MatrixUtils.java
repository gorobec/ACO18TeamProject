package ACB.week3;

/**
 * Created by vladkorneev on 23.12.16.
 */
public class MatrixUtils {

    public static int[][] generateMatrix(int rows, int cols, int range) {
        int [][] matrix = new int[rows][cols];
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = randomInt(range);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int randomInt(int range){
        return (int)(Math.random()*range);
    }


}
