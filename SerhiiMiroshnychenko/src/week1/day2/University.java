package week1.day2;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class University {
    private String name;
    private Group[] groups;

    public University(String name) {
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    public void setGroups(Group[] groups) {
        if (groups == null) return;
        this.groups = groups;
    }

    public void showGroups() {
        for (int i = 0; i < groups.length; i++) {
            System.out.println(groups[i].getName());
        }
    }
        public void showStudents(){
        for (int i = 0; i < groups.length; i++) {
            for (int j = 0; j < groups[i].getStudents().length; j++) {
                System.out.println(groups[i].getStudents()[j].toString());
            }
        }
    }
}
