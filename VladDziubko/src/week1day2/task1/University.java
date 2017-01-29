package week1day2.task1;

public class University {
    private String name;
    private Group[] group;
    private Student[] students;

    public University(Student[] students) {
        this.students = students;
    }

    public University(String name) {
        this.name = name;
    }

    public University(Group[] group) {
        this.group = group;
    }

    public University(String name, Group[] group) {
        this.name = name;
        this.group = group;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Group[] getGroup() {
        return group;
    }

    public void setGroup(Group[] group) {
        this.group = group;
    }

    public void showStudents() {
        System.out.println("University " + name);
        for (int i = group.length; i >= 0; i--) {
            group[i].showStudents();
        }
    }

    public Group addGroup(String name) {
        return new Group(name);
    }

}
