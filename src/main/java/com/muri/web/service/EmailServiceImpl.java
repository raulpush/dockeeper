package com.muri.web.service;

import com.muri.web.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(Email seq){
        MimeMessage message = mailSender.createMimeMessage();

        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(seq.getFrom());
            helper.setTo(seq.getTo());
            helper.setSubject(seq.getTitle());
            helper.setText(String.format(
                    seq.getText(), seq.getText()));

            FileSystemResource file = new FileSystemResource(seq.getFile());
            helper.addAttachment(file.getFilename(), file);

        }catch (MessagingException e) {
            throw new MailParseException(e);
        }
        mailSender.send(message);
    }

    public void sendSimpleEmail(Email seq){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(seq.getTo());
        email.setSubject(seq.getTitle());
        email.setText(seq.getText());
        email.setFrom(seq.getFrom());
        // sends the e-mail
        mailSender.send(email);
    }



}
