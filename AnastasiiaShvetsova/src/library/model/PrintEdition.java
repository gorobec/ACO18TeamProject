package library.model;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class PrintEdition{
    String name;
    Author author;
    int year;
    public PrintEdition(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "{" + name +
                '}';
    }
}
