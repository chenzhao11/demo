package mail;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;



import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

public  class Jmail {

	public Jmail() {
		// TODO Auto-generated constructor stub
	}
	
@Test
	public void  sendMail() throws MessagingException, IOException {
		Properties props=new Properties();
		props.put("mail.host", "smtp.163.com");
		props.put("mail.smtp.auth", "true");
		Authenticator authenticator=new Authenticator() {
			public javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication("zzuzhaochen", "zc199709193638");
			}
		};
		Session session=Session.getInstance(props, authenticator);
		MimeMessage mess=new MimeMessage(session);
		mess.setFrom(new InternetAddress("zzuzhaochen@163.com"));
		mess.addRecipients(javax.mail.Message.RecipientType.TO, "1318814182@qq.com");
		mess.setSubject("测试邮件！！"); 
		MimeMultipart mes=new MimeMultipart();
		mess.setContent(mes);
		MimeBodyPart mes1=new MimeBodyPart();
		mes1.setContent("这是一个测试的邮件！！！", "text/html;charset=utf-8");
		mes.addBodyPart(mes1);
		MimeBodyPart mes2= new MimeBodyPart();
		mes2.attachFile("C:\\Users\\zzuzh\\Desktop\\CHM\\2014最新W3CSchool文档.chm");
		mes2.setFileName(MimeUtility.encodeText("2014最新W3CSchool文档.chm"));
		mes.addBodyPart(mes2);
//		mess.saveChanges();
	    Transport.send(mess);
		}

}
