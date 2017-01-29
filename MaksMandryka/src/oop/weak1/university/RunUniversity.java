package oop.weak1.university;

/**
 * Created by fmandryka on 21.01.2017.
 */
public class RunUniversity {
    public static void main(String[] args) {

        Student stud1 = new Student("Max", "M", 20, 10);
        Student stud2 = new Student("Alex", "S", 21, 9);
        Student stud3 = new Student("Olga", "T", 20, 11);
        Student stud4 = new Student("Serhii", "M", 22, 8);
        Student stud5 = new Student("Anna", "H", 22, 9);
        Student stud6 = new Student("Viktoria", "K", 21, 6);
        Student stud7 = new Student("Yevhen", "T", 20, 8);
        Student stud8 = new Student("Andrii", "A", 21, 10);

        Cat cat = new Cat("Q", 1);

        Group group1 = new Group("6800", 4);
        Group group2 = new Group("6801", 4);
        Group group3 = null;
        Group group4 = new Group("6800", 4);;

        System.out.printf("Студент %s добавлен в группу %s %b\n", stud1.getName(), group1.addStudent(stud1), group1.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud2.getName(), group1.addStudent(stud2), group1.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud3.getName(), group1.addStudent(stud3), group1.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud4.getName(), group1.addStudent(stud4), group1.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud5.getName(), group2.addStudent(stud5), group2.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud6.getName(), group2.addStudent(stud6), group2.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud7.getName(), group2.addStudent(stud7), group2.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud8.getName(), group2.addStudent(stud8), group2.getName());


        System.out.printf("Студент %s добавлен в группу %s %b\n", stud1.getName(), group4.addStudent(stud1), group4.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud2.getName(), group4.addStudent(stud2), group4.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud3.getName(), group4.addStudent(stud3), group4.getName());
        System.out.printf("Студент %s добавлен в группу %s %b\n", stud4.getName(), group4.addStudent(stud4), group4.getName());

        System.out.printf("Группа %s аналогична группе %s %b\n\n", group1.getName(), group4.getName(), group1.equals(group4));

        Group[] groups = new Group[2];

        groups[0] = group1;
        groups[1] = group2;

        University univ = new University("KNEU", groups);
//        univ.addGroup(group3);
//        univ.showGroups();
//        univ.showStudents();

//        group2.removeStudent(stud2);
//        group2.removeStudent(stud5);

//        univ.showStudents();

//        univ.removeGroup(group2);
//        univ.removeGroup(group2);
//        univ.removeGroup(group3);

//        ByAge comp1 = new ByAge();
//        BySurname comp2 = new BySurname();

        group1.sortStud();

        Student stud10 = group1.findStudBinary(stud1);
        System.out.printf("Студент %s %s, возраст %d найден в группе %s\n", stud10.getName(), stud10.getSurname(), stud10.getAge(), group4.getName());
        Student stud11 = group1.findStudBinary(stud2);
        System.out.printf("Студент %s %s, возраст %d найден в группе %s\n", stud11.getName(), stud11.getSurname(), stud11.getAge(), group4.getName());
        Student stud12 = group1.findStudBinary(stud3);
        System.out.printf("Студент %s %s, возраст %d найден в группе %s\n", stud12.getName(), stud12.getSurname(), stud12.getAge(), group4.getName());
        Student stud13 = group1.findStudBinary(stud4);
        System.out.printf("Студент %s %s, возраст %d найден в группе %s\n", stud13.getName(), stud13.getSurname(), stud13.getAge(), group4.getName());

//        group2.sort(comp1);
//        univ.showStudents();
//
//        group2.sort(comp1);
//        univ.showStudents();

//        group2.sortStud();

//        Student[] foundStudents = group1.findStudByName("Max");

//        univ.showStudents();


    }
}
