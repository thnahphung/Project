package services;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {
    public static void sendMail(String subject, String content, String sendTo) {
        final String username = "20130356@st.hcmuaf.edu.vn";
        final String password = "ulnojephxsdbgtes";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("20130356@st.hcmuaf.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(sendTo)
            );
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendMail("hello", "tp la nguoi tuyet voi","qinhuuuuu@gmail.com");
    }
}