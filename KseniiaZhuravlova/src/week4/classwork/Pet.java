package week4.classwork;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name - %s, age - %d, i am %s \n", name, age, petType);
    }
}
