package com.utils;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import com.DAO.UserDAO;
import com.entity.User;
import com.entity.Email;






public class EmailUtils {
	
		private UserDAO userDao=new UserDAO();
	    public void send(Email email,HttpServletRequest request) {
	 
	        // Get properties object
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", MailConfig.HOST_NAME);
	        props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.port", MailConfig.SSL_PORT);
	 
	        // get Session
	        Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getFrom(), email.getFromPassword());
			}
	        }
	        );
	 
	        // compose message
	        try {
	        	String emailfg = request.getParameter("email");
	            User userlg = userDao.selectByEmail(emailfg);
	            MimeMessage message = new MimeMessage(session);
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailConfig.RECEIVE_EMAIL));
	            message.setSubject("Forget Password");
	            StringBuilder sb = new StringBuilder();
	            sb.append("Dear Ms/Mr. "+userlg.getFullname());
	            sb.append("       Welcome");
	            sb.append("       Admin : son");
	            
	            List<User> list= userDao.findAll();
	            
	           
	            for (User user : list) {
					if(user.getId() == userlg.getId()) {
						sb.append("      Your password : "+ user.getPassword());
					}
				}
	            message.setText(sb.toString());
	            
	            // send message
	            Transport.send(message);
	 
	            System.out.println("Message sent successfully");
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}

