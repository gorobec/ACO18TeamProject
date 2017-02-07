package ACO.week3.homework.main.java.ua.com.artcode;

/**
 * Hello world!
 *
 */
public class Run
{
    public static void main( String[] args ) {
        Node<String> head = (Node<String>)ListUtils.createStringList();
        head.showList();
        head = (Node<String>)ListUtils.reversion(head);
        head.showList();
    }
}
