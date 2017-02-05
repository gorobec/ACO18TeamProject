package arrayListCat;

import java.util.ArrayList;

/**
 * Created by anastasiia.shvetsova on 2/3/2017.
 */
public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        cats.add(this);
    }

    public String printCats(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cats.size(); i++) {

//            concat with String create new object at every iteration and it's very slowly
//            String str = "";
//            str = str +cats.get(i).toString();

//            String Builder create object only one time and addes values to current object
            stringBuilder.append(cats.get(i).toString() + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return  "{Cat's name - " + name + ", age - " + age + "}";
    }
}
