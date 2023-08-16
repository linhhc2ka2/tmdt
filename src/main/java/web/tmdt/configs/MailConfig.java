package web.tmdt.configs;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import web.tmdt.models.Mail;

@Service
public class MailConfig {
    List<Mail> mail = new ArrayList<>();

    @Autowired
    JavaMailSender javaMailSender;

    public void send(Mail mail) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, 1, "utf-8");

        messageHelper.setFrom(mail.getFrom());
        messageHelper.setTo(mail.getTo());
        messageHelper.setSubject(mail.getSubject());
        messageHelper.setText(mail.getBody());
        messageHelper.setReplyTo(mail.getFrom());

        for (String email : mail.getBcc()) {
            messageHelper.addBcc(email);
        }

        javaMailSender.send(message);
    }

    public void send(String to, String subject, String body) throws MessagingException {
        this.send(new Mail(to, subject, body));
    }

    public void queue(Mail mail) {
        this.mail.add(mail);
    }

    public void queue(String to, String subject, String body) {
        this.queue(new Mail(to, subject, body));
    }

    public void run() {
        while (!this.mail.isEmpty()) {
            Mail mail = this.mail.remove(0);
            try {
                this.send(mail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
