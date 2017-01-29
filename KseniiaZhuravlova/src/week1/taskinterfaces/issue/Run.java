package week1.taskinterfaces.issue;

/**
 * Created by ksyashka on 25.01.2017.
 */
public class Run {
    public static void main(String[] args) {

        Issue directory = new Directory("Yellow Pages", 3487);
        Issue schoolbook = new Schoolbook("Math", 421);

        Issue[] issues = {directory, schoolbook};
        IssuesToPrint toPrint = new IssuesToPrint(issues);

        toPrint.showIssuesToPrint();

    }
}
