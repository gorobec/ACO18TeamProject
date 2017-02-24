package to;

import model.Ticket;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    //private User user;
    private Ticket ticket;

    public boolean sendMail(String userMail) {
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
                        return new PasswordAuthentication("bestbuyaco18@gmail.com", "BestBuy1234");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@no-spam.com"));
            message.setRecipients(Message.RecipientType.TO,
<<<<<<< HEAD
                    InternetAddress.parse("USER MAIL"));
            message.setSubject("New Order");
            message.setText("Текст сообщения");
=======
                    InternetAddress.parse(ticket.getUser().getEmail()));
            message.setSubject("New Order №" + ticket.getId());
            message.setText("Dear buyer,\nyour order has been sent, please wait.\nThank you\n" + ticket.toString());
>>>>>>> c76d27dd9d564296fd56155b5fa253888c031950

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
