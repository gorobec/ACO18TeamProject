package week1.day1.student;

public class University {

    private String name;
    private Group[] groups;

    public University(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }

    public void showGroups() {

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != null)
                System.out.println(groups[i].asString());
            else {
                System.out.println("free array cell");
            }
        }
    }

    public void showStudents() {

        for (int i = 0; i < groups.length; i++) {
          if(groups[i]!= null)
              groups[i].showStudents();
          else
              System.out.println("free cell in array groups");
        }
    }

    public void addGroup(Group group) {
        int groupsCounter = 0;
        for (int i = 0; i < groups.length; i++) {
            if (group.equals(groups[i]))
                break;
            else if (groups[i] == null) {
                groups[i] = group;
                groupsCounter++;
                break;
            }
        }
        System.out.println(groupsCounter + " group(s) were added");
    }

    public void removeGroup(Group group) {
        for (int i = 0; i < groups.length; i++) {
            if (groups[i].equals(group)) {
                groups[i] = null;
                break;
            }
        }
        System.out.println(group.getName() + " " + group.getName() + " was removed");
    }

}
