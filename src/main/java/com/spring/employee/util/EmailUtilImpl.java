package com.spring.employee.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {

	@Autowired
	JavaMailSender sender;

	@Value("${com.employeeInfoSystem.itinerary.email.subject}")
	private String EMAIL_SUBJECT;

	@Value("${com.employeeInfoSystem.itinerary.email.body}")
	private String EMAIL_BODY;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtilImpl.class);

	@Override
	public void sendItinerary(String toAddress, String filePath) {
		LOGGER.info("Inside sendItinerary()");
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(EMAIL_SUBJECT);
			messageHelper.setText(EMAIL_BODY);
			messageHelper.addAttachment("Employee Details", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Exception inside sendItinerary() and the exception is: " + e);
		}
	}
}
