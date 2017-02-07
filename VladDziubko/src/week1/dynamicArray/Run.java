package week1.dynamicArray;

public class Run {
    public static void main(String[] args) {
        NewArrayList list = new NewArrayList();
        list.add("cat");
        list.add(1, "dog");

        System.out.println(list.size());

        list.remove(0);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();
        System.out.println(list.get(0));

    }
}

