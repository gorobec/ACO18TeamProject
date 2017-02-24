package data_structures;

import org.junit.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * Created by gorobec on 29.01.17.
 */
public class MyArrayListTest extends MyListTest{

    @Before
    public void setUp() {
        list = new MyArrayList<>();
    }

}
