package week1.day2.student_task;

import java.util.Arrays;

/**
 * Created by gorobec on 22.01.17.
 */
public class University {
    private String name;
    private int size;
    private Group[] groups;
    private int countGroup = 0;


    public University(String name,  int size) {
        this.name = name;
        this.size = size;
        this.groups = new Group[size];
    }

    public void showGroups() {
        System.out.println(Arrays.toString(groups));
    }

    public Group[] addGroup(Group group) {
        if (countGroup == size) {
            System.out.println("Group is full");
        }

        if (findGroup(group)) {
            System.out.println(group.toString() + " group is alredy in university");
            return groups;
        }

        groups[countGroup] = group;
        countGroup++;

        return groups;
    }
    public boolean findGroup(Group group) {
        if (group == null) return false;
        for (int i = 0; i < countGroup; i++) {
            if (groups[i].equals(group)) {
                return true;
            }
        }
        return false;
    }
}
