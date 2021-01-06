package com.SpringSecurityApp.service;

import javax.mail.MessagingException;

import com.SpringSecurityApp.context.AbstractEmailContext;

public interface EmailService {
	void sendMail(final AbstractEmailContext email) throws MessagingException;
}
