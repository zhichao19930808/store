package com.ed.utils;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
	public static void sendMail(String email, String emailMessage) {
        //创建一个程序与邮件服务器会话对象 session
        Properties properties = new Properties();
        //设置发送的协议
        properties.setProperty("mail.host", "localhost");
        properties.setProperty("mail.smtp.auth", "true");
        //创建验证器
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("Admin","aaa");
            }
        };
        Session session = Session.getInstance(properties, authenticator);
        //创建一个message，相当于邮件内容
        Message message = new MimeMessage(session);
        try {
            //发送者
            message.setFrom(new InternetAddress("Admin@store.com"));
            //发送方式及接收者
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
            //邮箱主题
            message.setSubject("用户激活");
            //邮箱内容
            message.setContent(emailMessage,"text/html;charset=utf-8");
            //创建 Transport 用于邮件发送
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
