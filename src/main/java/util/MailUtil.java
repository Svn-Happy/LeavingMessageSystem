package util;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;

public class MailUtil {

    private String host = ""; // smtp服务器
    private String from = ""; // 发件人地址
    private String to = ""; // 收件人地址
    private String affix = ""; // 附件地址
    private String affixName = ""; // 附件名称
    private String user = ""; // 用户名
    private String pwd = ""; // 密码
    private String subject = ""; // 邮件标题
    private int VCode;

    public int getVCode(){
        return VCode;
    }

    public void setAddress(String from, String to, String subject) {
        this.from = from;
        this.to = to;
        this.subject = subject;
    }

//    public void setAffix(String affix, String affixName) {
//        this.affix = affix;
//        this.affixName = affixName;
//    }

    public void send(String host, String user, String pwd) {
        this.host = host;
        this.user = user;
        this.pwd = pwd;

        Properties props = new Properties();

        // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.host", host);
        // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", true);

        props.setProperty("mail.transport.protocol", "smtps");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //props.setProperty("java.net.preferIPv4Stack", "true");
        props.setProperty("mail.smtp.ssl.enable","true");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props);

        // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
        // 用（你可以在控制台（console)上看到发送邮件的过程）
        session.setDebug(true);

        // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session);
        try {
            // 加载发件人地址
            message.setFrom(new InternetAddress(from));
            // 加载收件人地址
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 加载标题
            message.setSubject(subject);

            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 设置邮件的文本内容
            VCode = (int) ((Math.random() * 9 + 1) * 100000);
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText("您的验证码为："+VCode);
            multipart.addBodyPart(contentPart);
            // 添加附件
            //BodyPart messageBodyPart = new MimeBodyPart();
            //DataSource source = new FileDataSource(affix);
            // 添加附件的内容
            //messageBodyPart.setDataHandler(new DataHandler(source));
            // 添加附件的标题
            // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
            //sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
            //messageBodyPart.setFileName("=?GBK?B?" + enc.encode(affixName.getBytes()) + "?=");
            //multipart.addBodyPart(messageBodyPart);

            // 将multipart对象放到message中
            message.setContent(multipart);
            // 保存邮件
            message.saveChanges();
            // 发送邮件
            Transport transport = session.getTransport("smtp");
            // 连接服务器的邮箱
            transport.connect(host, user, pwd);
            // 把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
////        MailUtil cn = new MailUtil();
////        // 设置发件人地址、收件人地址和邮件标题
////        cn.setAddress("cc5281@126.com", "cc5282@126.com", "一个带附件的JavaMail邮件");
////        // 设置要发送附件的位置和标题
////        //cn.setAffix("/mailcontent.txt", "mailcontent.txt");
////
////        /**
////         * 设置smtp服务器以及邮箱的帐号和密码
////         * 用QQ 邮箱作为发生者不好使 （原因不明）
////         * 163 邮箱可以，但是必须开启  POP3/SMTP服务 和 IMAP/SMTP服务
////         * 因为程序属于第三方登录，所有登录密码必须使用163的授权码
////         */
////        cn.send("smtp.126.com", "cc5281@126.com", "BLVJCVTCHDECUIRG");
//        MailUtil mailUtil=new MailUtil();
//        //mailUtil.setAddress("cc@chohee.top", "1120923182@qq.com", "留言站注册码");
//        mailUtil.setAddress("cc5281@126.com", "cc5282@126.com", "留言站注册码");
//        /**
//         * 设置smtp服务器以及邮箱的帐号和密码
//         * 用QQ 邮箱作为发生者不好使 （原因不明）
//         * 163 邮箱可以，但是必须开启  POP3/SMTP服务 和 IMAP/SMTP服务
//         * 因为程序属于第三方登录，所有登录密码必须使用163的授权码
//         */
//        mailUtil.send("smtp.126.com", "cc5281@126.com", "BLVJCVTCHDECUIRG");
//        //mailUtil.send("smtp.chohee.top", "cc@chohee.top", "123123");
//    }
}