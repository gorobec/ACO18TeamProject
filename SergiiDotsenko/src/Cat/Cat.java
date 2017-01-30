package Cat;

import java.util.ArrayList;

public class Cat {
    public String name;
    public static ArrayList<Cat> catStore = new ArrayList<>();

    public Cat(String name) {
        this.name = name;
        catStore.add(this);
    }

    public static void printAllCats() {
        for (int i = 0; i < catStore.size(); i++) {
            System.out.println("cat name is \'" + catStore.get(i).name+"\'");
        }
    }

    public String getName() {
        return name;
    }
}
