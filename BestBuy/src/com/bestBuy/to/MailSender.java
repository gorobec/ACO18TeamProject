package com.bestBuy.to;

import com.bestBuy.model.Configuration;
import com.bestBuy.model.Ticket;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    private static MailSender mailSender;
    private String email;
    private String emailPassword;

    private MailSender() throws IOException {
        email = Configuration.getConfig().getProperty("email");
        emailPassword = Configuration.getConfig().getProperty("email_password");
    }

    public static MailSender getInstance() throws IOException {
        if (MailSender.mailSender == null) {
            mailSender = new MailSender();
        }
        return mailSender;
    }


    public boolean sendMail(Ticket ticket) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, emailPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@no-spam.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(ticket.getUser().getEmail()));
            message.setSubject("New Order №" + ticket.getId());
            message.setText("Dear buyer,\nyour order has been sent, please wait.\nThank you\n" + ticket.toString());

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
