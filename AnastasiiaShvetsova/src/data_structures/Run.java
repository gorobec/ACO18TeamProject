package data_structures;
//import java.util.MyArrayList;

/**
 * Created by Nastia on 28.01.17.
 */
public class Run {
    public static void main(String[] args) {
        MyArrayList colors = new MyArrayList(5);

        colors.add("red");
        colors.add("black");
        colors.add("gray");
        colors.add("yellow");
        colors.printList();

      //  colors.add(1,"orange");
       // colors.printList();
       // System.out.println(colors.get(5));
        //System.out.println(colors.remove(2));
        //colors.printList();
        System.out.println(colors.remove("blue"));
        colors.printList();
       // colors.set(0, "green");
       // colors.printList();
       // System.out.println(colors.contains("white"));
        //System.out.println(colors.contains("red"));

        //System.out.println(colors.size());


    }
}
