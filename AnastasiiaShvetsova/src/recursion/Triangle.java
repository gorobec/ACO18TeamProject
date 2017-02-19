package recursion;

/**
 * Created by Nastia on 16.02.17.
 */
public class Triangle {
    public int triangle(int rows) {
        if (rows == 0) {
            return 0;
        }
        int res = rows;
        return res + triangle(rows - 1);
    }
}
