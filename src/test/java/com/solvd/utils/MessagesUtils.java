package com.solvd.utils;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;

import java.util.Arrays;

public class MessagesUtils {

    public boolean checkForExpectedMailFrom(String mailAddress, Message[] messages) {
        return Arrays.stream(messages).anyMatch(m -> {

            try {
                return m.getFrom()[0].toString().contains(mailAddress);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
