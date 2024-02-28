package com.xworkz.vendorManagement.service;

import java.time.LocalDate;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vendorManagement.entity.VendorEntity;
import com.xworkz.vendorManagement.repository.VendorRepository;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository repository;

	public VendorServiceImpl() {
		System.out.println("created a VendorServiceImpl...");
	}

	@Override
	public VendorEntity save(VendorEntity entity) {
		entity.setCreatedBy(entity.getOwnerName());
		entity.setCreatedDate(LocalDate.now());

		this.repository.saveRepo(entity);
		return entity;
	}

	@Override
	public String isExistByNameOrMailOrSite(String vendorName, String email, String website) {
		VendorEntity entity = repository.isExistByNameOrMailOrSite(vendorName, email, website);
		if (entity != null) {
			if (entity.getVendorName().equals(vendorName)) {
				return "Name already exist";
			} else if (entity.getEmail().equals(email)) {
				return "Email already exist";
			} else if (entity.getWebsite().equals(website)) {
				return "Website already exist";
			}
			System.out.println("Details not present save it");
		}
		return null;
	}

	@Override
	public boolean sendMail(String email) {
		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = "sushma098@outlook.in";
		String password = "S@sushma123";
		String to = email;
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Email Vaidation");
			message.setText("Please verify...");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return false;
	}
}
