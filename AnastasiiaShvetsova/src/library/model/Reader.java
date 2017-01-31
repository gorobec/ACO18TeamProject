package library.model;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Reader{
    String name;
    String surname;
    int age;
    int conutBooks;
    PrintEdition[] readerPrintEditions;

    public Reader(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "{name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age + "}";
    }
}
