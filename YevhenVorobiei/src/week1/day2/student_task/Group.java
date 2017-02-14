package week1.day2.student_task;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gorobec on 22.01.17.
 */
public class Group {
    private String name;
    private Student[] students;

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }
    public void showStudents(){
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public String getName() {
        return name;
    }
    
    public void sortByName(){
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - 1; j++) {
                if(students[j].compareTo(students[j + 1]) > 0){
                    swap(students, j);
                }
            }
        }
    }

    private void swap(Student[] students, int i) {
        Student tmp = students[i];
        students[i] = students[i + 1];
        students[i + 1] = tmp;
    }


    public void sort(Comparator<Student> comparator) {

       // Arrays.sort(students, comparator);

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - 1; j++) {
                if(comparator.compare(students[i], students[j + 1]) < 0){
                    swap(students, j);
                }
            }
        }
    }

    public Student[] getStudents() {
        return students;
    }
}
