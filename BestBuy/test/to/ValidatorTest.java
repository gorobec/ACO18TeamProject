package to;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 20.02.2017.
 */
public class ValidatorTest {

    Validator validator = new Validator();


    @Test
    public void validEmail() throws Exception {
        Assert.assertEquals(true, validator.validEmail("a@a.aa"));
        Assert.assertEquals(true, validator.validEmail("A_Zsdd.s99@asd9_hds.asd"));
        Assert.assertEquals(false, validator.validEmail("aa.a"));
        Assert.assertEquals(false, validator.validEmail("a@aa"));

    }

    @Test
    public void validCard() throws Exception {
        Assert.assertEquals(true, validator.validCreditCard("5168755632007247"));
    }

}