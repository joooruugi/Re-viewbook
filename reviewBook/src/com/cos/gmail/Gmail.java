package com.cos.gmail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("reviewbook.rvb@gmail.com", "jkbsjkbs!123");
	}
}
