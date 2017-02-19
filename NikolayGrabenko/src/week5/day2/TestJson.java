package week5.day2;

/**
 * Created by User on 19.02.2017.
 */
public class TestJson {

    public static void main(String[] args) {

        CatJson cat1 = new CatJson("cat",1);

        Gson catJson = new Gson (cat1);

    }
}
