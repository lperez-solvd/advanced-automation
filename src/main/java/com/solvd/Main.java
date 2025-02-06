package com.solvd;

import com.solvd.mail.EmailReceiver;
import com.solvd.mail.EmailSender;

public class Main {
    public static void main(String[] args) {
        System.out.println("Receiving mails");

        EmailReceiver emailReceiver = new EmailReceiver();
        emailReceiver.getMails();

        EmailSender emailSender = new EmailSender();
        emailSender.sendMail("This is a test mail!");

    }
}