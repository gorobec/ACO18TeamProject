package week1day2.task1;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private int age;
    double averageMark;
    private Student[] students;

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Student(Student[] students) {
        this.students = students;
    }

    public Student(String name, String surname, int age, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.averageMark = averageMark;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
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

    public double getAverageMark() {
        return averageMark;
    }

    public String toString() {
        return String.format("Name -> %s, surname -> %s, age -> %d, average mark -> %.0f", name, surname, age, averageMark);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Student other = (Student) obj;
        return name == other.getName() && surname == other.getSurname() &&
                age == other.getAge() && averageMark == other.averageMark;
    }

    @Override
    public int compareTo(Student o) {
        int result = name.compareTo(o.name);
        if(result != 0){
            return result;
        }
        result = surname.compareTo(o.surname);
        if(result != 0){
            return result;
        }
        return 0;
    }

    // sort by name
    public void sortByName(Student[] students){
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if(students[i].name.compareTo(students[j].name) > 0){
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    // sort by surname
    public void sortBySurname(Student[] students){
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if(students[i].surname.compareTo(students[j].surname) > 0){
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
}
