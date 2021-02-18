package com.project.give_back_in_good_hands.domain;

public class Email {

    private String to;
    private String recipientName;
    private String subject;
    private String text;
    private String senderName;
    private String templateEngine;

    public Email() {
    }

    public Email(String to, String recipientName, String subject, String text,
                 String senderName, String templateEngine) {
        this.to = to;
        this.recipientName = recipientName;
        this.subject = subject;
        this.text = text;
        this.senderName = senderName;
        this.templateEngine = templateEngine;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(String templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", senderName='" + senderName + '\'' +
                ", templateEngine='" + templateEngine + '\'' +
                '}';
    }
}
