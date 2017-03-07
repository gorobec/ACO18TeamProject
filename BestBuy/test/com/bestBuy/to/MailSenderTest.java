package com.bestBuy.to;

import com.bestBuy.model.Ticket;
import com.bestBuy.model.User;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kseniya on 22.02.2017.
 */
public class MailSenderTest {
    MailSender mailSender = MailSender.getInstance();

    public MailSenderTest() throws IOException {

    }

    @Test
    public void sendMailTest(){
        User user = new User("ksyashka19@gmail.com", "123456", "4444", "Kiev");
        Ticket ticket = new Ticket(user.getEmail(),5);
        assertTrue(mailSender.sendMail(ticket));
    }

}
