package week1.task2;

public class Dog extends Animal {
    private String species;

    public Dog(String name, int age, double weight, String kind, String species) {
        super(name, age, weight, kind);
        this.species = species;
    }

    public Dog(){
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public void run(){
        System.out.println("Dog " + getName() + " is running very fast.");
    }

    @Override
    public void jump(){
        System.out.println("Dog " + getName() + " is jumping.");
    }

    public void bark(){
        System.out.println("Dog " + getName() + " is barking.");
    }

    public void bite(){
        System.out.println("Dog " + getName() + " is bitten somebody.");
    }

    public String showName(){
        return String.format("%s ", getName());
    }
}
