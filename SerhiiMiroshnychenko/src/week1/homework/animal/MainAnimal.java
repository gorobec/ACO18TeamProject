package week1.homework.animal;

/**
 * Created by serhiim on 23-Jan-17.
 */
public class MainAnimal {

    public static void main(String[] args) {
        Animal dog = new Dog();
        System.out.println("Dog name is:");
        dog.name = "Bim";
        dog.printName();
        dog.bite();
        dog.jump();
        dog.ran();
        dog.voice();
        System.out.println("*************************");
        Dog puppy = new Puppy();
        puppy.name = "Jack";
        System.out.println("Puppy name is:");
        puppy.printName();
        puppy.bite();
        puppy.jump();
        puppy.ran();
        puppy.voice();
    }
}
