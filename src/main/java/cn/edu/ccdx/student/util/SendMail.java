package cn.edu.ccdx.student.util;


import java.util.Date;
import java.util.Properties;
import java.util.PropertyResourceBundle;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	/**
	 * @param tfrom 发送邮件的源地址
	 * @param tto 发送邮件的目的地址
	 * @param ttitle 邮件的题目
	 * @param tcontent 邮件的内容
	 */
	public void send(String tfrom, String tto, String ttitle, String tcontent) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "localhost");
		props.put("mail.smtp.auth", "false");
		Session s = Session.getInstance(props, null);
		s.setDebug(true);
		Message message = new MimeMessage(s);
		try {
		
			Address from = new InternetAddress(tfrom);
			message.setFrom(from);
			Address to = new InternetAddress(tto);
			message.setRecipient(Message.RecipientType.TO, to);
			message.setSubject(ttitle);
			message.setContent(tcontent, "text/html;charset=utf-8");
			message.setSentDate(new Date());
			message.saveChanges();
			Transport transport = s.getTransport("smtp");
			transport.connect("localhost","","");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getEmailServiceIp
	 * @return EmailServiceIp
	 */
	public String getMailServiceIp(){
		String mailAddress = "";
		PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("email_service_ip");
		mailAddress = res.getString("mailAddress");
		return mailAddress;
	}
	public static void main(String[] args) {
		SendMail sm = new SendMail();
		sm.send("localhost", "lhbphp@hotmail.com", "test", "test");
	}
}
