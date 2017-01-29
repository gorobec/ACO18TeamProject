package week1.classWork;

/**
 * Created by Игорь on 22.01.2017.
 */
public class University {

    private String name;
    private Group[] groups;


    public University(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }

    public void showGroups(){
        System.out.println(name);
        System.out.println();
        System.out.println();
        for (int i = 0; i < groups.length; i++) {

            System.out.println(groups[i].asSting());
        }
    }

    public void showStudents(){
        System.out.println(name);
        System.out.println();
        for (int i = 0; i < groups.length; i++) {

            System.out.println(groups[i].asStingAll());
        }
    }
}
