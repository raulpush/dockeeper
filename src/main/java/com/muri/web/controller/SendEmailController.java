package com.muri.web.controller;

import com.muri.web.model.Email;
import com.muri.web.model.User;
import com.muri.web.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SendEmailController {

	@Autowired
	private EmailService emailService;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		return "EmailForm";
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "sendEmail", method = RequestMethod.POST)
	public String doSendEmail(HttpServletRequest request) {
		Email em = new Email();
		em.setTo(request.getParameter("recipient"));
		em.setTitle(request.getParameter("subject"));
		em.setText(request.getParameter("message"));
		emailService.sendSimpleEmail(em);
		// forwards to the view named "Result"
		return "Result";
	}


}