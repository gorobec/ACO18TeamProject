package week1.dynamicArray;

/**
 * Created by Reed on 27.01.2017.
 */
public class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String asString(){
        return String.format("%s %s", name, surname);
    }
}
