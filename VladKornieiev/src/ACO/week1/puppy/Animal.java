package ACO.week1.puppy;

/**
 * Created by v21k on 24.01.17.
 */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s", name);
    }
}
