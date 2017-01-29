package oop.weak1.inheritance;

/**
 * Created by fmandryka on 22.01.2017.
 */
public class Manager extends Person {
    private String company;
    private Codder[] coders;

    public Manager(String name, String surname, int age, String company, Codder[] coders) {
        super(name, surname, age);
        this.company = company;
        this.coders = coders;
    }

    @Override
    public String asString() {
        String output = String.format("Manager name = %s, Company = %s", name, company);

        for (int i = 0; i < coders.length; i++) {
            output = output + "\n" + String.format("Codder Name%d = %s", i + 1, coders[i].getName());
        }
        return output;
    }

    public void work() {
        System.out.println("I'm manager. I'm working!");
        for (int i = 0; i < coders.length; i++) {
         coders[i].work();
        }
    }

}
