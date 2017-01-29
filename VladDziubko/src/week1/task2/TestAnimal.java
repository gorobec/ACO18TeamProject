package week1.task2;

public class TestAnimal {
    public static void main(String[] args) {
        Puppy puppy = new Puppy();
        puppy.setName("Jimmy");
        puppy.setAgeMonth(8);
        puppy.setSpecies("haski");
        puppy.setWeight(3);

        puppy.jump();
        puppy.bark();
        puppy.bite();
        puppy.run();
        System.out.print(puppy.showName());
    }
}
