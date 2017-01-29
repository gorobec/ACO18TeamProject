package week1.taskinterfaces.issue;

/**
 * Created by ksyashka on 25.01.2017.
 */
public class IssuesToPrint {
    Issue[] issues;

    public IssuesToPrint(Issue[] issues) {

        this.issues = issues;
    }

    public void showIssuesToPrint() {
        for (int i = 0; i < issues.length; i++)
            if (issues[i] != null)
                issues[i].print();
    }
}
