package week1.task2;

public class Puppy extends Dog {
    private int ageMonth;

    public Puppy(String name, int age, double weight, String species, String kind, int ageMonth){
        super(name, age, weight, species, kind);
        this.ageMonth = ageMonth;
    }

    public Puppy(){
    }

    public int getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(int ageMonth) {
        this.ageMonth = ageMonth;
    }

    public void run(){
        System.out.println("Puppy " + getName() + " is running.");
    }

    public void jump(){
        System.out.println("Puppy " + getName() + " is jumping.");
    }

    public void bark(){
        System.out.println("Puppy " + getName() + " is barking.");
    }

    public void bite(){
        System.out.println("Puppy " + getName() + " is bitten somebody.");
    }

    public String showName(){
        return String.format("%s ", getName());
    }
}
