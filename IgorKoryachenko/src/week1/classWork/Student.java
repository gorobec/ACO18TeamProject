package week1.classWork;

/**
 * Created by Игорь on 22.01.2017.
 */
public class Student implements Comparable{

    private String name;
    private String surname;
    private int age;



    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String asString(){
        return "Name is - " + name + "  Surname - " + surname + "  age - " + age;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Student other = (Student) obj;
        return age == other.age &&
                (surname ==other.surname || (surname != null && surname.equals(other.getSurname()))) &&
                        (name == other.name || (name != null && name.equals(other.getName())));
    }



    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;

        return surname.compareTo(student.surname);
    }
}
