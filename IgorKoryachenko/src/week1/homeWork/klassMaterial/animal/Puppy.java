package week1.homeWork.klassMaterial.animal;

/**
 * Created by Игорь on 23.01.2017.
 */
public class Puppy extends Dog {
    private boolean fluffy;
    private boolean sexMale;

    public Puppy(String name, String breed, boolean fluffy, boolean sexMale) {
        super(name, breed);
        this.fluffy = fluffy;
        this.sexMale = sexMale;
    }

    @Override
    public void jump(){
        System.out.println("Прыгаю как серна");
    }

    @Override
    public void run() {
        System.out.println("Бегаю как угорелый");
    }

    @Override
    public void voice() {
        System.out.println("Тяв-тяв");
    }

    @Override
    public void biting() {
        System.out.println("Я не умею кусаться");
    }
}
