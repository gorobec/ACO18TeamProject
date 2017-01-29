package week1.day1;

/**
 * Created by gorobec on 21.01.17.
 */
public class Student {
    private String name;
    private String surname;
    private int age;
    private double averageMark;
    private Cat cat;

//    public Student(){}

    public Student(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
//        validation
        if(name == null || name.isEmpty()) return;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String asString(){
//        return "Student name - " + name + ", age - " + age;
        return String.format("Student name - %s, age - %d, cat - %s", name, age, cat.asString());
    }
}
