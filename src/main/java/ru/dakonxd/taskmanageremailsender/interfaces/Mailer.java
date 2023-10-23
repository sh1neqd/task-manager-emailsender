package ru.dakonxd.taskmanageremailsender.interfaces;

public interface Mailer {
    public void send(String recipientAdress, String title, String text);
}
