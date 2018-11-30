package com.meiman.meimanwallet.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author zeng_
 * @Date 2018/11/28
 */
public class MailUtil {
    private static JavaMailSenderImpl javaMailSender;
    static {
        javaMailSender = new JavaMailSenderImpl();
        //链接服务器
        javaMailSender.setHost(PropertiesUtils.readProperty("mail.smtp"));
        //账号
        javaMailSender.setUsername(PropertiesUtils.readProperty("mail.user"));
        //密码
        javaMailSender.setPassword(PropertiesUtils.readProperty("mail.pass"));
        javaMailSender.setDefaultEncoding("UTF-8");
        Properties properties = new Properties();
        //设置通过ssl协议使用465端口发送、使用默认端口（25）时下面三行不需要
        //开启认证
        properties.setProperty("mail.smtp.auth", "true");
        //设置ssl端口
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailSender.setJavaMailProperties(properties);
    }

    /**
     * 根据标题内容和收件人发送邮件
     * @param title   发送邮件标题
     * @param content 邮件内容
     * @param toMail  收件人
     */
    public static void sendEmail(final String title, final String content, final String toMail) {
        //todo 由于发送邮件响应较慢，需要用线程池等待，这里需要优化

        if (StringUtils.isNotBlank(toMail)) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(PropertiesUtils.readProperty("mail.user"));
            mailMessage.setSubject(title);
            mailMessage.setText(content);
            String[] toAddress = toMail.split(",");
            mailMessage.setTo(toAddress);
            //发送邮件
            javaMailSender.send(mailMessage);
        }
    }
}
