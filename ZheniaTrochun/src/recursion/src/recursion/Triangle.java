package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class Triangle {
    public static int triangle(int rows){
        if(rows <= 0) return 0;

        return rows + triangle(rows - 1);
    }
}
