/*
 * Computer Systems 2 Coursework.
 */
package misc;

import java.util.Date;
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
 * 
 * 
 * @author Ashley Moore (6304397)
 * @author Ian Weeks (6204848)
 */
public class Email
{
    private String host, from, to, message;
    
    public Email(String to, String message)
    {
        this.host = "smtp.gmail.com";
        this.from = "festival.project.ashleyandian@gmail.com";
        this.to = to;
        this.message = message;
    }
    
    public void sendEmail()
    {
        //Set email sending settings.
        Properties myProps = new Properties();
        myProps.put("mail.smtp.host", host);
        myProps.put("mail.smtp.port", "465");
        myProps.put("mail.debug", "true");
        myProps.put("mail.smtp.auth", true);
        myProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        myProps.put("mail.smtp.starttls.enable", "true");
        
        //Set username and password
        Session mySession = Session.getInstance(myProps, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("festival.project.ashleyandian@gmail.com", "festivalprojectashleyandian");
            }
        });
        
        try
        {
            Message theMsg = new MimeMessage(mySession);
            theMsg.setFrom(new InternetAddress(from));
            InternetAddress sendTo = new InternetAddress(to);
            theMsg.setRecipient(Message.RecipientType.TO, sendTo);
            theMsg.setSubject("Admin alert.");
            theMsg.setSentDate(new Date());
            theMsg.setContent(message, "text/plain");
            Transport.send(theMsg);
            
        } catch (MessagingException me)
        {
            System.err.println("Error: Email not sent. " + me);
        }
    }
}

