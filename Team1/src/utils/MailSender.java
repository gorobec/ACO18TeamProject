package utils;

import model.Product;
import model.Ticket;
import model.User;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by v21k on 23.02.17.
 */
public class MailSender {
    private static final String DEFAULT_PASS = "TeamProject18";
    private static final String DEFAULT_EMAIL = "aco18.test@mail.ru";

    public static void sendEmail(User user, Ticket ticket, Product product) {
        String productName = product.getName();

        String msgStr = String.format("You bought some cool stuff in our shop!\nIt`s %s\nTicket id - %d\nThank you!",
                productName, ticket.getId());

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("smtp.mail.ru", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(DEFAULT_EMAIL, DEFAULT_PASS);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(DEFAULT_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail().toLowerCase().trim()));
            message.setSubject("You bought some cool stuff");
            message.setText(msgStr);

            Transport.send(message);

        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }
}
