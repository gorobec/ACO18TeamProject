package ACO.week1.puppy;

/**
 * Created by v21k on 24.01.17.
 */
public class Puppy extends Dog {
    public Puppy(String name) {
        super(name);
    }

    @Override
    public void bark() {
        System.out.println("I'm still learning com.bestBuy.to bark");
    }

    @Override
    public void bit() {
        System.out.println("I have no teeth com.bestBuy.to bite :(");;
    }
}
