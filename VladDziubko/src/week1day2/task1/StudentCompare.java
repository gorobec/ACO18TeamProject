package week1day2.task1;

import java.util.Arrays;

/**
 * Created by Валерий on 28.01.2017.
 */
public class StudentCompare {
    public static void main(String[] args) {
        Student stud1 = new Student("Peter", "Ivanov", 30, 4);
        Student stud2 = new Student("Kolia", "Shishkin", 28, 5);

        Student[] students = {stud1, stud2};
        /*System.out.println("sort by age");
        Arrays.sort(students, new AgeComparator());
        System.out.println(Arrays.toString(students));
        System.out.println("sort by surname");
        Arrays.sort(students, new MarkComparator());
        System.out.println(Arrays.toString(students));
        System.out.println();
        System.out.println("sort by name"); //comparable
        stud1.sortByName(students);
        System.out.println(Arrays.toString(students));
        System.out.println("sort by surname"); // comparable
        stud1.sortBySurname(students);
        System.out.println(Arrays.toString(students));*/
        System.out.println("sort by name");
        Arrays.sort(students, new StringComparator());
        System.out.println(Arrays.toString(students));
    }
}
