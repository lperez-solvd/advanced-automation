package com.solvd.mails;

import com.solvd.mail.EmailReceiver;
import com.solvd.mail.EmailSender;
import com.solvd.utils.MessagesUtils;
import jakarta.mail.Message;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailTests {

    String MAIL_TESTER_ADDRESS = "noreply@sendtestemail.com";
    String SUCCESS_SENT_MAIL_MESSAGE = "Email sent successfully!";
    MessagesUtils messagesUtils = new MessagesUtils();

    @Test
    public void receiveMailFromSendTestMail() {
        EmailReceiver emailReceiver = new EmailReceiver();
        Message[] messages = emailReceiver.getMails();

        Assert.assertTrue(messagesUtils.checkForExpectedMailFrom(MAIL_TESTER_ADDRESS, messages), "The expected message hasn't been received");
    }

    @Test
    public void sendMail() {
        EmailSender emailSender = new EmailSender();
        String response = emailSender.sendMail("This is a test mail");

        Assert.assertEquals(response, SUCCESS_SENT_MAIL_MESSAGE, "The mail sent wasn't OK");
    }
}
