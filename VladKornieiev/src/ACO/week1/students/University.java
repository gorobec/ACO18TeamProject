package ACO.week1.students;

/**
 * Created by v21k on 24.01.17.
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

    // homework after this line

    public void addGroup(Group group) {

        // validation if we have this student already
        for (Group gr : groups) {
            if (gr.equals(group)) {
                System.out.println("Already in the university!");
                return;
            }
        }
        if (group != null) {
            int updatedSize = groups.length;
            Group[] tempGroups = new Group[updatedSize + 1];
            System.arraycopy(groups, 0, tempGroups, 0, updatedSize);
            tempGroups[updatedSize] = group;
            groups = tempGroups;
            System.out.println("Done, group added");
            return;
        }
        System.out.println("Wrong input parameter (null)");
    }

    public void removeLastGroup() {
        if (groups.length >= 1) {
            int updatedSize = groups.length - 1;
            Group[] tempGroups = new Group[updatedSize];
            System.arraycopy(groups, 0, tempGroups, 0, updatedSize);
            groups = tempGroups;
            System.out.println("Done removing");
            return;
        }
        System.out.println("No groups to remove.");
    }

    public void removeGroupByName(String name) {
        for (int i = 0; i < groups.length; i++) {
            if (name.equals(groups[i].getName())) {
                // if found, replace this group with the last, the last -> null.
                groups[i] = groups[groups.length - 1];
                groups[groups.length - 1] = null;

                //creating new array(smaller) without last element (which is null in <group> array now)
                int updatedSize = groups.length;
                Group[] tempGroup = new Group[updatedSize - 1];
                System.arraycopy(groups, 0, tempGroup, 0, updatedSize - 1);
                groups = tempGroup;
                System.out.printf("Done, group %s at index %d deleted\n", name, i);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
