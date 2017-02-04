package oop.weak1.university;

import oop.weak1.task_7_arrayList.MyArrayList;

/**
 * Created by fmandryka on 21.01.2017.
 */
public class Cat {
    private String name;
    private int age;
    public static MyArrayList cats = new MyArrayList();


    public Cat (String name, int age) {
        this.name = name;
        this.age = age;
        Cat.cats.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString (){
        return "Name = " + name + " age = " + age + " \n";
    }

    public String printCats() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cats.size() ; i++) {
            sb.append(cats.get(i));
        }
        return sb.toString();
    }

}
