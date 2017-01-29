package week1.day1;

/**
 * Created by ksyashka on 22.01.2017.
 */
public class University {
    private String name;
    private Group[] groups;
    private int size;


    public University() {};

    public University(String name, int size) {
        this.name = name;
        this.groups = new Group[size];
    }


    /*public boolean addGroup(Group group) {
        for (int i = 0; i < groups.length; i++)
            if (groups[i] == null) {
                groups[i] = group;
                System.out.println("New group is " + groups[i].asString());
                i = groups.length;
                return true;
            }
        System.out.println("Sorry! University is ful!");
        return false;
    }
    */
    public boolean addGroup(Group group) {
        if (isDuplicateGroup(group)) {
            System.out.println("A group is already in the university");
            return false;
        }
        if (size == groups.length) {
            System.out.println("Sorry! Unversity is ful!");
            return false;
        }
        groups[size++] = group;
        return true;
    }

    public boolean isDuplicateGroup(Group group) {
        if (group == null) return false;
        for (int i = 0; i < size; i++)
            if (groups[i].equals(group)) return true;
        return false;
    }

    public void delGroup(int index) {
        if (index < 0 || index > groups.length || groups[index] == null) {
            System.out.println("A student doesn't exist!");
            return;
        }
        System.arraycopy(groups, index + 1, groups, index, groups.length - index - 1);
        groups[groups.length - 1] = null;
        size--;
    }

    public void showGroups(){
        System.out.println(name);
        for (int i=0; i<groups.length;i++)
            if (groups[i] != null)
                System.out.println(groups[i].asString());
    }

    public void showStudents(){
        for (int i=0;i<groups.length;i++)
            if (groups[i] != null)
                groups[i].showStudents();
    }

}
