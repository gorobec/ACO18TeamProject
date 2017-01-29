package week1.homeWork.klassMaterial.animal;

/**
 * Created by Игорь on 23.01.2017.
 */
public class RunAnimal {
    public static void main(String[] args) {
        Puppy puppy1 = new Puppy("Zhuzhik", "collie", true, true);
        Dog puppy2 = new Puppy("Belka", "collie", true, false);

        System.out.println(puppy1.getName());
        puppy1.jump();
        puppy1.run();
        puppy1.voice();
        puppy1.biting();
        System.out.println(puppy2.getName());
        puppy2.jump();
        puppy2.run();
        puppy2.voice();
        puppy2.biting();

        //Почему-то не сработало. Надо разобраться
    }
}
