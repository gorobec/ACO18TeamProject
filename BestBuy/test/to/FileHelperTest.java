package to;

import org.junit.Assert;

import java.io.File;

/**
 * Created by ksyashka on 19.02.2017.
 */
public class FileHelperTest {

    private FileHelper fileHelper = new FileHelper();
    @org.junit.Test
    public void readFromFile() throws Exception {
        String str = fileHelper.readFromFile("C:/Users/ksyashka/IdeaProjects/" +
                "ACO18TeamProject/BestBuy/resources/test.txt");
        Assert.assertEquals(str, "Hello World! 1234466");

    }

    @org.junit.Test
    public void writeToFile() throws Exception {
        Assert.assertTrue(fileHelper.writeToFile("Hello World! 1234466","C:/Users/ksyashka/IdeaProjects/" +
                "ACO18TeamProject/BestBuy/resources/test.txt"));
    }

}