package com.solvd.mail;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.*;

import java.util.Properties;

public class EmailReceiver {

    Dotenv dotenv = Dotenv.load();

    String host = "imap.gmail.com";
    String username = dotenv.get("MAIL_USER");
    String password = dotenv.get("MAIL_PASS");

    Properties props = new Properties();

    private void setProperties() {
        props.put("mail.store.protocol", "imaps");
        props.put("mail.imap.host", host);
        props.put("mail.imap.port", "993");
    }

    public void getMails() {
        setProperties();
        try {
            Session session = Session.getInstance(props);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            System.out.println("Total emails: " + messages.length);
            for (Message message : messages) {
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Content: " + message.getContent().toString());
                System.out.println("---------------------------");
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            System.out.println("Error when receiving mails: " + e);
        }
    }
}