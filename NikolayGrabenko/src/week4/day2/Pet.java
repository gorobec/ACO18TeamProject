package week4.day2;

public class Pet {

    private String name;
    private int age;
    private String petType;

    public String generateName() {
        String[] names = {"A", "B", "C", "D"};
        name = names[(int) Math.random() * 3];
        return name;
    }

    public int generateAge() {
        return age = (int) Math.random() * 3 + 1;
    }

    public String generatePetType() {
        String[] types = {"Dog", "Cat", "Rat"};
        petType = types[(int) Math.random() * 2];
        return petType;
    }

    public Pet generatePet() {
        Pet pet = new Pet();
        pet.name = generateName();
        pet.age = generateAge();
        pet.petType = generatePetType();
        return pet;
    }

}
