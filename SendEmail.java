import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    public static void main(String[] args) {
        String from = "your-email@gmail.com";
        String to = "recipient@example.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        final String username = "your-email@gmail.com";
        final String password = "your-app-password";

        try {
            Address toAddr = new InternetAddress(to);

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, toAddr);
            message.setSubject("Testing Subject");
            message.setText("Hello, this is a sample email sent using JavaMail API.");

            Transport.send(message);
            System.out.println("Sent message successfully.");
        } catch (AddressException ae) {
            System.err.println("Invalid address: " + ae);
        } catch (MessagingException me) {
            System.err.println("Messaging failure: " + me);
        }
    }
}
