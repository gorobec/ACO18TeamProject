
import controller.IService;
import controller.ServiceImpl;
import exception.InvalidIdException;
import exception.InvalidInputParameters;
import exception.NoSuchProductException;
import exception.UserLoginException;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v21k on 19.02.17.
 */

public class IServiceTest {

    private IService controller;
    private String token;

    @Before
    public void setUp() throws Exception{
        controller = new ServiceImpl();

        controller.addProduct(new Product(0, "product1"));
        controller.addProduct(new Product(1, "product2"));
        controller.addProduct(new Product(2, "product3"));
        controller.addProduct(new Product(3, "product4"));

        controller.signUp("username1", "Password1", "42004200zhenia@gmail.com");
        controller.signUp("username2", "Password1", "42004200zhenia@gmail.com");
        controller.signUp("username3", "Password1", "42004200zhenia@gmail.com");
        controller.signUp("username4", "Password1", "42004200zhenia@gmail.com");

        token = controller.logIn("username1", "Password1");

        try {
            controller.addTicket(new Ticket(0, new BankCard("1111111111111111", 111, YearMonth.parse("2017-01")), new Address("Kiev", "KPI", 1), 0));
            controller.addTicket(new Ticket(1, new BankCard("1111111111111111", 111, YearMonth.parse("2017-01")), new Address("Kiev", "KPI", 1), 0));
            controller.addTicket(new Ticket(2, new BankCard("1111111111111111", 111, YearMonth.parse("2017-01")), new Address("Kiev", "KPI", 1), 0));
            controller.addTicket(new Ticket(3, new BankCard("1111111111111111", 111, YearMonth.parse("2017-01")), new Address("Kiev", "KPI", 1), 0));
        } catch (InvalidInputParameters e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.Test
    public void getProducts() throws Exception {
        List<Product> exp = new ArrayList<>();

        exp.add(new Product(0, "product1"));
        exp.add(new Product(1, "product2"));
        exp.add(new Product(2, "product3"));
        exp.add(new Product(3, "product4"));

        Assert.assertEquals(exp, controller.getProducts());
    }

    @org.junit.Test
    public void getProductByIdTest1() throws Exception {
        Assert.assertEquals(new Product(0, "product1"), controller.getProductById(0));
    }

    @Test(expected = InvalidIdException.class)
    public void GetProductByIdTest2() throws Exception{
        controller.getProductById(-1);
    }

    @org.junit.Test
    public void buy() throws Exception {
        Assert.assertEquals(
                5,
                controller.buy(
                        new User.UserBuilder().setEmail("").setName("").setPass("").build().getId() - 2,
                            0,
                                new Address("Kiev", "KPI", 1),
                                    new BankCard("1111111111111111", 111, YearMonth.parse("2017-01"))));
    }

    @Test(expected = InvalidInputParameters.class)
    public void buyTest2() throws NoSuchProductException, InvalidInputParameters{
        controller.buy(0, -1, new Address("Kiev", "KPI", 1),
                new BankCard("1111111111111111", 111, YearMonth.parse("2017-01")));
        controller.buy(-1, 7, new Address("Kiev", "KPI", 1),
                new BankCard("1111111111111111", 111, YearMonth.parse("2017-01")));
    }

    @org.junit.Test
    public void showTicket() throws Exception {
        Assert.assertEquals(
                new Ticket(0, new BankCard("1111111111111111", 111, YearMonth.parse("2017-01")), new Address("Kiev", "KPI", 1), 0),
                controller.getTicketById(0, token));
    }

    @Test(expected = InvalidIdException.class)
    public void showTicketTest2() throws InvalidIdException, UserLoginException{
        controller.getTicketById(-1, token);
    }

    @Test(expected = InvalidInputParameters.class)
    public void validationTest() throws Exception {
        controller.signUp("", "Aa11111", "some@mail.ru");
    }

    @Test(expected = InvalidInputParameters.class)
    public void validationTest2() throws Exception {
        controller.signUp("username", "111", "some@mail.ru");
    }

    @Test(expected = InvalidInputParameters.class)
    public void validationTest3() throws Exception {
        controller.signUp("username", "Aa11111", "some_mail.ru");
    }

    @Test
    public void userMethodsTest() throws Exception {
        User user = controller.signUp("username", "Aa11111", "some@mail.ru");

        Assert.assertEquals(user, controller.getUserByToken(controller.logIn(user.getName(), user.getPass())));
    }
}

