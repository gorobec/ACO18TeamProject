package week2.day1;

import week1.day1.Student;
import week1.day2.Group;

import java.util.Arrays;

/**
 * Created by serhiim on 28-Jan-17.
 */
public class StudentCompare {

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", "Petrov", 20, 15);
        Student student2 = new Student("Petr", "Ivanov", 21, 20);
        Student student3 = new Student("Vasilii", "Semenov", 20, 10);
        Student student4 = new Student("Serhii", "Lobov", 25, 12);
        Student student5 = new Student("Yaroslav", "Petrov", 23, 10);
        Student student6 = new Student("Maksim", "Litvininko", 19, 11);
        Student student7 = new Student("Alex", "Ivanov", 19, 14);
        Student student8 = new Student("Semen", "Baguk", 19, 13);

        Student[] students = {student1, student2, student3, student4,student5, student6, student7, student8};
       /* System.out.println(student1);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new AgeComparator());*/

        Group group = new Group("", students);
        group.groupToString();
        System.out.println("***********");
        group.sort(new SurnameComparator());
        group.groupToString();

    }
}
