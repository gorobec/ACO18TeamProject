package to;

import model.Ticket;
import model.User;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kseniya on 22.02.2017.
 */
public class MailSenderTest {
    MailSender mailSender = new MailSender();

    @Test
    public void sendMailTest(){
        User user = new User("ksyashka19@gmail.com", "123456", "4444", "Kiev");
        Ticket ticket = new Ticket(user,5);
        assertTrue(mailSender.sendMail(ticket));
    }

}
