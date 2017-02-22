import org.junit.Assert;
import org.junit.Test;
import week5.IOUtils;

public class TestIOUtils {
    IOUtils utils = new IOUtils();

    @Test
    public void testPwd(){
        Assert.assertTrue(utils.pwd() == "");
    }
}
