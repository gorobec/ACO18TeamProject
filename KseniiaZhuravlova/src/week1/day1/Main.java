package week1.day1;

import week2.day1.*;

/**
 * Created by ksyashka on 22.01.2017.
 */
public class Main {
    public static void main(String arg[]) {
     /*   Student stud1 = new Student ("Bob", "Dilan", 19);
        Student stud2 = new Student ("John", "Lenon", 18);
        Student stud3 = new Student ("Sara", "Parker", 18);
        Student stud4 = new Student ("Kate", "Smith", 20);
        Student stud5 = new Student ("Anna", "Adams", 18);
        Student stud6 = new Student ("Nina", "Richy", 26);
        Student stud7 = new Student ("Anna", "Ivanova", 18);
        Student stud8 = new Student ("Petr", "Petrov", 17);
     */

        Group group1 = new Group ("501", 3);
        group1.addStudent("John", "Lenon", 18);
        group1.addStudent("Sara", "Parker", 18);
        group1.addStudent("Sara", "Parker", 18);
        group1.addStudent("Bob", "Dilan", 19);
        group1.addStudent("Johnny", "Depp", 18);

        group1.showStudents();
        group1.delStudent(1);
        group1.addStudent("Johnny", "Depp", 18);
        group1.showStudents();

        Group group2 = new Group("502", 5);
        group2.addStudent("Kate", "Smith", 20, 5.0);
        group2.addStudent("Anna", "Adams", 18, 2.1);
        group2.addStudent("Nina", "Richy", 26, 3.4);
        group2.addStudent("Anna", "Ivanova", 22, 4.5);
        group2.addStudent("Petr", "Petrov", 17, 4.0);

        /*group2.delStudent(2);

        University university = new University("KPI", 2);
        university.addGroup(group1);
        university.addGroup(group2);
        university.addGroup(group2);

        university.showGroups();
        university.showStudents();

        university.delGroup(0);

        university.showGroups();

        group2.searchStudent("Anna");
        group1.searchStudent("Ivan");
*/
        group2.sort();
        group2.showStudents();

        group2.sort(new AgeComparator());
        group2.showStudents();

        group2.sort(new SurnameComparator());
        group2.showStudents();

    }
}
