package com.kbe.homework.exams.clientserver;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * class Message
 * @author Boris Krinitsky
 * @version 1.1
 */
public class SimpleMessage implements Serializable {

    private String text;
    private String sender;
    private LocalDateTime dateTime;


    public SimpleMessage(String text, String sender) {
        this.text = Objects.requireNonNull(text, "text is not be null");
        this.sender = Objects.requireNonNull(sender, "sender is not be null");
        this.dateTime = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }



    @Override
    public String toString() {
        return dateTime
                + "\n"
                + sender
                + ": "
                + text
                + "\n";
    }
}
