/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherfunction;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class EmailSender {
    
    //sending welcome email
    public void welcomeEmailSender(String useremail,String name){
        

        
            
         // Recipient's email ID needs to be mentioned.
        String to =useremail;

        // Sender's email ID needs to be mentioned
        String from = "usermanagement7@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("usermanagement7@gmail.com", "Usermanagement123");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Welcome "+name);

            // actual message
            message.setContent(
              "<h4>Dear User,<br>Thank you for choosing Usermanagement System made by Exousia TEAM.Now welcome to our UMS family.<br> Regards,<br> UMS Team(EXOUSIA)</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    //OTP code sender
    public void passwordEmailSender(String useremail,String randompassword){
        

        
            
         // Recipient's email ID needs to be mentioned.
        String to =useremail;

        // Sender's email ID needs to be mentioned
        String from = "usermanagement7@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("usermanagement7@gmail.com", "Usermanagement123");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Pssword Reset Code Alert!!!");

            //  actual message
            message.setText(
              "Dear User,\n Your new password reset code is:"+randompassword);

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    //removed infromation email sender
     public void removeEmailSender(String useremail,String username){
        

        
            
         // Recipient's email ID needs to be mentioned.
        String to =useremail;

        // Sender's email ID needs to be mentioned
        String from = "usermanagement7@gmail.com";

        // sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("usermanagement7@gmail.com", "Usermanagement123");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject("Sorry "+username);

            //actual message
            message.setContent(
              "<h4>Dear User,<br>Sorry,Your Account has been successfully removed from UMS System due to inappropriate activity.<br> Regards,<br> UMS Team(EXOUSIA)</h4>",
             "text/html"
            
            );

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
}
