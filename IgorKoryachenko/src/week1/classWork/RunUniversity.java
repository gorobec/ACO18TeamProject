package week1.classWork;

/**
 * Created by Игорь on 22.01.2017.
 */
public class RunUniversity {
    public static void main(String[] args) {
        Student student1 = new Student("Mark", "Bobrov", 23);
        Student student2 = new Student("Vova", "Kotov", 22);
        Student student3 = new Student("Vasia", "Koiko", 23);
        Student student4 = new Student("Lena", "Boiko", 20);
        Student student5 = new Student("Ira", "Esko", 21);
        Student student6 = new Student("Petya", "Kozak", 23);
        Student student7 = new Student("Max", "Babanin", 24);
        Student student8 = new Student("Natalia", "Ivanova", 22);

        Group group1 = new Group("ACO", new Student[]{student1, student2, student3, student4});
        Group group2 = new Group("ACB", new Student[]{student5, student6, student7, student8});

        University university = new University("KPI", new Group[]{group1, group2});

        /*university.showGroups();
        university.showStudents();
        group1.setStudents(group1.addStudent("Kolya", "Popov", 24));
        Group.sortByName(group1.getStudents());
        university.showStudents();
        System.out.println();
        group1.findStudentByName("Vova");
        group2.setStudents(group2.removeStudentByName("Max"));
        group2.showStudents();*/

        /*group1.sort(new AgeComparator());
        group1.showStudents();
        group1.sort(new SurnameComparator());
        group1.showStudents();*/

        Group.sortByName(group1.getStudents());
        group1.showStudents();
        System.out.println(group1.searchBinaryByName("Mark"));

    }

    //добавить/удалить группу - аналогично. Если успею до конца недели - доделаю, а заодно
    //и проверки в методах добавить/удалить на правильность ввода и имени
}
