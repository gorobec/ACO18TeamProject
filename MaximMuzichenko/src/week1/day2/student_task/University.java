package week1.day2.student_task;

/**
 * Created by gorobec on 22.01.17.
 */
public class University {
    private String name;
    private Group[] groups;

    public University(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }

    public void showGroups() {
        for (Group group : groups) {
            System.out.println(group.getName());
        }
    }

    public void showStudents() {
        for (Group group : groups) {
            group.showStudents();
        }
    }
}
