package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Edition {
     private String name;
     private int kolvo;

    public Edition(String name, int kolvo) {
        this.name = name;
        this.kolvo = kolvo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
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
