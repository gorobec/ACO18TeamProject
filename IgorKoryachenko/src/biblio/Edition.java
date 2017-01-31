package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Edition {
    private String name;

    public Edition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "name='" + name + '\'' +
                '}';
    }
}
