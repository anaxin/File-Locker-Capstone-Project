package filelocker;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Mail class contains methods for sending OTP mails to users for account and
 * file locks. Also, sends administrator email with user input in contact us
 * form. Uses external library jar file JavaMail and JAF activation.
 *
 * @author x
 */
public class Mail {

    /**
     * This method sends an email from the administrator the the user with the
     * associated OTP for the locked account or file.
     *
     * @param to the user's email
     * @param otp the one time password for the account or file
     * @param type 0 for user account or 1 for user file or 2 for reset password by user
     */
    public static void sendMail(String to, String otp, int type) {
        String from = "EMAIL_HERE";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "EMAIL_HERE"); // User name
        properties.put("mail.smtp.password", "PASSWORD_HERE"); // password
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "EMAIL_HERE", "PASSWORD_HERE");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("File Locker One Time Password");
            if (type == 0) {
                message.setText("Your account has been locked due to failed attempts to login. Please "
                        + "use the following One Time Password to login and change your password:\n "
                        + "One Time Password: " + otp);
            } else if (type == 1) {
                message.setText("Your file has been locked due to failed attempts to decrypt. Please "
                        + "use the following One Time Password to decrypt and change your password:\n "
                        + "One Time Password: " + otp);
            }
            else if (type == 2) {
                message.setText("Your account password has been reset by your request. Please "
                        + "use the following One Time Password to enter your account and"
                        + " change your password:\n "
                        + "One Time Password: " + otp);
            }
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
/**
 * Sends the administrator and email with user message from the contact us tab.
 * @param sender username of the user sending message
 * @param subject the subject title of the email the user inputs
 * @param msg the main message of the email the user inputs
 */
    public static void contactUs(String sender, String subject, String msg) {
        String from = "EMAIL_HERE";
        String to = "EMAIL_HERE";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "EMAIL_HERE"); // User name
        properties.put("mail.smtp.password", "PASSWORD_HERE"); // password
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "EMAIL_HERE", "PASSWORD_HERE");
            }
        });
        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject(subject);
            message.setText("From: " + sender + "\n" + msg);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
