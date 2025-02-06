package com.solvd.mail;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {

    Dotenv dotenv = Dotenv.load();

    // Email credentials and server details
    String host = "smtp.gmail.com";
    String username = dotenv.get("MAIL_USER");
    String password = dotenv.get("MAIL_PASS");
    String to = dotenv.get("MAIL_TO");

    Properties props = new Properties();

    private void setUpProperties() {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
    }


    public String sendMail(String body) {
        setUpProperties();

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Test Email from Jakarta Mail");
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully!");
            return "Email sent successfully!";
        } catch (
                MessagingException e) {
            System.out.println("Error sending email: " + e);
        }
        return "Error sending email";
    }

}