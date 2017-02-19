package customer;

import editions.Edition;

import java.util.Comparator;

/**
 * Created by zhenia on 03.02.17.
 */
public class Customer implements java.lang.Comparable, Comparator<Customer> {
    private String name;
    private int age;
    private Edition[] borrowed = new Edition[0];

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Edition[] getBorrowed() {
        return borrowed;
    }

    public boolean borrowEdition(Edition e){
        if(borrowed.length >= 3) return false;

        Edition[] arr = new Edition[borrowed.length + 1];

        System.arraycopy(borrowed, 0, arr, 0, borrowed.length);
        arr[borrowed.length] = e;
        borrowed = arr;

        return true;
    }

    public Edition returnEdition(int index){
        if(index < 0 || borrowed.length <= index) return null;

        Edition tmp = borrowed[index];

        Edition[] arr = new Edition[borrowed.length - 1];

        System.arraycopy(borrowed, 0, arr, 0, index);
        System.arraycopy(borrowed, index + 1, arr, index, borrowed.length - index - 1);
        borrowed = arr;

        return tmp;
    }

    @Override
    public boolean equals(Object o){
        return ((Customer)o).name.equals(this.name) && ((Customer)o).age == this.age;
    }

    @Override
    public String toString(){
        return String.format("Name: %s, borrewed editions: %d", name, borrowed.length);
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Customer)o).name);
    }

    @Override
    public int compare(Customer o1, Customer o2){
        return o1.compareTo(o2);
    }
}
