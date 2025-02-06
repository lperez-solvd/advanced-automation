package com.solvd;

import com.solvd.mail.EmailReceiver;
import com.solvd.mail.EmailSender;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Receiving mails");





        EmailSender emailSender = new EmailSender();
        emailSender.sendMail("This is a test mail!");

    }
}