package biblio;

import java.util.Comparator;

/**
 * Created by Игорь on 04.02.2017.
 */
public class NameComparator implements Comparator<Edition> {
    @Override
    public int compare(Edition o1, Edition o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
