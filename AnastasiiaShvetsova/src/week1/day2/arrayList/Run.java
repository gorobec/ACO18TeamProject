package week1.day2.arrayList;
//import java.util.MyArrayList;

/**
 * Created by Nastia on 28.01.17.
 */
public class Run {
    public static void main(String[] args) {
        ArrayList colors = new ArrayList(5);

        colors.add("red");
        colors.add("black");
        colors.add("gray");
        colors.add("yellow");
        colors.printList();

        colors.add(1,"orange");
        colors.printList();
        System.out.println(colors.get(5));
        colors.remove(2);
        colors.printList();
        colors.remove("black");
        colors.printList();
        colors.set(0, "green");
        colors.printList();
        System.out.println(colors.contains("white"));
        System.out.println(colors.contains("red"));

        System.out.println(colors.size());


    }
}
