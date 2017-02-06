package week1.day1;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vasya", "red ");

        Student st1 = new Student("Ivan", "Petrov", 18, 4.5);
        Student st2 = new Student("Serg", "Ivanov", 19, 4.8);
        Student st3 = new Student("Ilya", "Sydoroff", 21, 4.1);
        Student st4 = new Student("Sasha", "Petrenko", 22, 4.0);
        Student st5 = new Student("Petro", "Stepanenko", 21, 4.4);

        Student[] students1 = new Student[2];
        students1[0] = st1;
        students1[1] = st2;

        Student[] students2 = new Student[3];
        students2[0] = st3;
        students2[1] = st4;
        students2[2] = st5;

        Group group1 = new Group("ACO18", students1);
        Group group2 = new Group("ACO19", students2);

        Group[] groups = new Group[3];
        groups[0] = group1;
        groups[1] = group2;

        University univer = new University("ItUniver", groups);

//        univer.showGroups(groups);
//        univer.showStudents(groups);

        Student[] students3 = new Student[5];
        students3[0] = st1;
        students3[1] = st2;
        students3[4] = st5;

        Group group3 = new Group("ACO20", students3);

//        univer.addGroup(groups, group3);
//        univer.showGroups(groups);
//        univer.showStudents(groups);
//        group3.showStudents();
//        group3.addStudent(st3);
//        group3.addStudent(students3, st4);  // to init last free cell in array remove comment
//        group3.showStudents();
//        group3.removeStudent(students3, st2);
//        group3.showStudents();

//        group3.sortStudentsByName();
//
//        group3.showStudents();
//        System.out.println();

//       this is how program works if no free places in the group(remove next comments)

//        group3.addStudent(students3, st1);
//        group3.showStudents();

        System.out.println(st1.equals(st1));

        group3.addStudent(st4);
        group3.addStudent(st1);
        group3.addStudent(st3);

//        group3.showStudents();
//        group3.removeStudent(st1);

        System.out.println();
//        group3.showStudents();//нет нулПоинтерЭкс

        group3.sortByComparator(new SurNameComparator());
        System.out.println("After SurNameComparator:");
        group3.showStudents();

        group3.sortUsingCompareTo();
        System.out.println("After sortUsingCompareTo (sorting by name) ");
        group3.showStudents();


    }
}
