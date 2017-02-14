package week4;

/**
 * Created by ksyashka on 12.02.2017.
 */
public class Pet {
    private String name;
    private int age;
    private PetType petType;

    public Pet(String name, int age, PetType petType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
    }

    @Override
    public String toString() {
        return "";
    }
}
