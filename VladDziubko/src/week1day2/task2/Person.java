package week1day2.task2;

public class Person {
    protected String name;
    protected String surname;
    private int age;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int age(){
        return age;
    }

    public String asString(){
        return String.format("%s %s, %d", name, surname, age);
    }

    public void work(){
        System.out.println("I`m working!");
    }
}
