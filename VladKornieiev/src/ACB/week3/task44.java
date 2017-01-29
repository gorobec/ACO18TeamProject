package ACB.week3;

/*
Написать морской бой(1 корабль).
Размер поля указывает пользователь. При промахе показывать подсказку
*/

import java.util.Scanner;
import static ACB.week3.MatrixUtils.printMatrix;

public class task44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows, columns;

        System.out.print("Enter number of rows: ");
        rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        columns = sc.nextInt();
        System.out.println();

        // empty field for gamer
        String[][] field = generateField(rows, columns);

        // field with ship
        String[][] ship = generateShip(field);
        printMatrix(field);

        while (!victory(ship)) {
            System.out.print("Enter row: ");
            int row = sc.nextInt();
            System.out.print("Enter column: ");
            int col = sc.nextInt();
            System.out.println();

            // change field ("." becomes "X", "0" or "-").
            field = fire(ship, field, row, col);
            printMatrix(field);

            // check if fire not ok - give a hint
            if (!ship[row-1][col-1].equals("X")) {
                System.out.println(hint(ship, row, col));
            }
        }
        System.out.println("Victory!");
    }

    // creating a sea battle field
    public static String[][] generateField(int rows, int columns) {
        String [][] field = new String[rows][columns];
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[i].length ; j++) {
                field[i][j] = ".";
            }
        }
        return field;
    }

    public static String[][] generateShip(String [][] field) {
        String[][] outputField = generateField(field.length, field[0].length);

        // position
        boolean horizontal = (Math.random() > 0.5);

        if (horizontal){
            // choosing random row
            int row = (int) (Math.random() * field.length);
            // random size (maximum is matrix.length - 1)
            int size = (int) (Math.random() * (field[row].length-1));
            size = (size <= 2) ? 3 : size;
            // place of the ship - index
            int startIndex = (int) (Math.random() * (field[row].length-size));
            size = (startIndex > size) ? startIndex+size : size;

            for (int i = startIndex; i <= size; i++) {
                outputField[row][i] = "0";
            }
        } else {
            // choosing random column
            int col = (int) (Math.random() * field[0].length);
            // random size (maximum is matrix.length - 1)
            int size = (int) (Math.random() * (field.length-1));
            size = (size <= 2) ? 3 : size;
            // place(start) of the ship - index
            int startIndex = (int) (Math.random() * (field.length-size));
            size = (startIndex > size) ? startIndex+size : size;

            for (int i = startIndex; i  <= size; i ++) {
                outputField[i][col] = "0";
            }
        }
        return outputField;
    }

    public static String[][] fire(String[][] field, String[][] clearField, int row, int col) {
        // replace "0" with "X" if ok
        // if not ---> "-".
        if (field[row-1][col-1].equals("0")) {
            clearField[row-1][col-1] = "X";
            field[row-1][col-1] = "X";
        } else if (field[row-1][col-1].equals(".")){
            clearField[row-1][col-1] = "-";
            field[row-1][col-1] = "-";
        }
        return clearField;
    }

    public static boolean victory(String[][] field) {
        // check if there are any "0" on the field
        // if no - return true
        for (String[] row : field) {
            for (String col : row) {
                if (col.equals("0")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String hint(String[][] field, int row, int col) {
        boolean found = false;
        int realRow = 0, realCol = 0;

        // looking for position of "0"
        for (int i = 0; i <  field.length; i++) {
            for (int j = 0; j < field[i].length ; j++) {
                if(field[i][j].equals("0")) {
                    found = true;
                    realRow = i;
                    realCol = j;
                    break;
                }
            }
        }

        // compare found position with our input
        if(found){
            if (realRow+1 == row) {
                return (realCol+1 < col) ? "Left" : "Right";
            } else if (realRow+1 < row) {
                return "Up";
            } else return "Down!";
        }
        return "No hint!";
    }
}
