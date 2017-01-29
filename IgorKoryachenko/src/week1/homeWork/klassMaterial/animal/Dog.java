package week1.homeWork.klassMaterial.animal;

/**
 * Created by Игорь on 23.01.2017.
 */
public class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public void jump(){
        System.out.println("Прыгаю");
    }
    public void run(){
        System.out.println("Бегаю");
    }
    public void voice(){
        System.out.println("Гав");
    }
    public void biting(){
        System.out.println("Отойди, укушу");
    }
}
