package data_structures;

/**
 * Created by ksyashka on 26.01.2017.
 */
public class Run {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("ab");
        myArrayList.add("bc");
        myArrayList.add(1, "cd");
        myArrayList.set(4,"kl");
        myArrayList.printArrayList();
        myArrayList.add("de");
        myArrayList.add("kl");
        myArrayList.add(3, "ed");
        myArrayList.printArrayList();
        System.out.println(myArrayList.get(2));
        myArrayList.remove(2);
        myArrayList.printArrayList();
        myArrayList.remove("ed");
        myArrayList.printArrayList();
        System.out.println(myArrayList.contains("ed"));
        System.out.println(myArrayList.contains(null));
        myArrayList.remove(null);
        myArrayList.remove(4);
        myArrayList.printArrayList();
        myArrayList.trimToSize();
        myArrayList.printArrayList();
        myArrayList.clear();
        myArrayList.printArrayList();
        myArrayList.trimToSize();
        myArrayList.printArrayList();

    }


}
