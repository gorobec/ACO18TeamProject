package to;

import org.junit.Assert;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by ksyashka on 19.02.2017.
 */
public class SuperFileReaderTest {

    private SuperFileReader superFileReader = new SuperFileReader();
    @org.junit.Test
    public void readFromFile() throws Exception {
        String str = superFileReader.readFromFile();
        Assert.assertEquals(str, "Hello World! 1234466");

    }

    @org.junit.Test
    public void writeToFile() throws Exception {
        Assert.assertTrue(superFileReader.writeToFile("Hello World! 1234466"));

    }

}