package com.indsys.SpringBootBackEnd.configurations;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailOffice365 {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

//    private static final String SERVER_SMTP = "smtp.office365.com";
//    private static final int PORT_SERVER_SMTP = 587;
    private static final String MAIL_ID = "ilabeltesting@outlook.com";
    private static final String PASSWORD_MAIL_ID = "";

    private final String from = "ilabeltesting@outlook.com";
    private final String to = "habitha@indsys.holdings";

    private final String subject = "Test";
    private final String messageContent = "Test Message";

    public void sendEmail() {
        final Session session = Session.getInstance(this.getEmailProperties(), new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MAIL_ID, PASSWORD_MAIL_ID);
            }

        });

        try {
            final Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(messageContent);
            message.setSentDate(new Date());
            Transport.send(message);
        } catch (final MessagingException ex) {
            LOGGER.log(Level.WARNING, "Error Message: " + ex.getMessage(), ex);
        }
    }

    public Properties getEmailProperties() {
        final Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
//        config.put("mail.smtp.host", SERVER_SMTP);
//        config.put("mail.smtp.port", PORT_SERVER_SMTP);
        return config;
    }

    public static void main(final String[] args) {
        new SendEmailOffice365().sendEmail();
    }

}
