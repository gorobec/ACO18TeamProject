package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Edition {
     String name;
     int kolvo;

    public Edition(String name, int kolvo) {
        this.name = name;
        this.kolvo = kolvo;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "name='" + name + '\'' +
                ", kolvo=" + kolvo +
                '}';
    }
}
