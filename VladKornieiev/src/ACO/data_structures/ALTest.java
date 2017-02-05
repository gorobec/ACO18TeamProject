package ACO.data_structures;

/**
 * Created by v21k on 05.02.17.
 */
public class ALTest {
    public static void main(String[] args) {
        MyList<String> al = new MyArrayList<>();
        al.add("A");
        al.add("B");
        al.add("C");
        al.add("D");
        for (String s : al) {
            System.out.println(s);
        }
    }


}
