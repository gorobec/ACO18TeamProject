package ACO.week4.stream_practice;

/**
 * Created by v21k on 12.02.17.
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }
}
