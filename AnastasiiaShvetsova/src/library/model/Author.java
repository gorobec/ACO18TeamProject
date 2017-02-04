package library.model;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Author {
    String name;
    String surname;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public String toString() {
        return  name + surname;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Author)) return false;
        Author tmp = (Author) obj;
        return (this.name.equals(tmp.name) && (this.surname.equals(tmp.surname)));

    }
}
