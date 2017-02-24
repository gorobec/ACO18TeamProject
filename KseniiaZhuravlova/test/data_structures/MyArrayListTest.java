package data_structures;

import org.junit.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * Created by ksyashka on 29.01.2017.
 */
public class MyArrayListTest extends MyListTest {

    @Before
    public void setUp() {
        list = new MyArrayList();
    }

}
