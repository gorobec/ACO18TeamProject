package oop.weak1.university;

/**
 * Created by fmandryka on 21.01.2017.
 */
public class University {
    private String name;
    private Group[] groups;


    public University(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }

    public Group[] getGroups() {
        return groups;
    }

    public String getName() {

        return name;
    }

    public boolean addGroup(Group group) {

        try {
            if (isInUniversity(group) == -1 && (hasSpace() != -1)) {
                groups[hasSpace()] = group;
                return true;

            } else {
                System.out.println("Группа не добавлена, лимит групп в Университете заполнен либо такая группа уже добавлена!");
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean removeGroup(Group group) {

        try {
            int groupPosition = isInUniversity(group);
            if (groupPosition != -1) {

                System.arraycopy(groups, groupPosition + 1, groups, groupPosition, groups.length - 1 - groupPosition);
                groups[groups.length - 1] = null;
                return true;

            } else {
                System.out.println("Группа не найдена в списке групп Университета!");
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }

    }

    public int isInUniversity(Group group) throws IllegalArgumentException {
        if (group != null) {

            for (int i = 0; i < groups.length; i++) {

                if (groups[i] != null && groups[i].equals(group)) {
                    return i;
                }
            }
        } else {
            throw new IllegalArgumentException("Группа не должна быть равна null");
        }
        return -1;
    }

    public int hasSpace() {

        for (int i = 0; i < groups.length; i++) {

            if (groups[i] == null) {
                return i;
            }
        }

        return -1;
    }


    public void showGroups() {

        System.out.println("university name = " + name + " groups:");

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != null) {
                System.out.println("Group name = " + groups[i].getName());
            }
        }

    }

    public void showStudents() {

        System.out.println("university name = " + name + " students:");

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != null) {
                groups[i].showStudents();
            }
        }

    }

}
