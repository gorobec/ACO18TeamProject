package week1.medicine;

/**
 * Created by Reed on 25.01.2017.
 */
public class Neurosurgeon extends Surgeon {
    public Neurosurgeon(){
        super("Nueorsurgeon");
    }

    public StringBuilder doctorType(){
        return new StringBuilder("I`m a neurosurgeon");
    }
}
