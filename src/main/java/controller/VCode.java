package controller;

import util.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/vcode")
public class VCode extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //目标邮箱
        String mail = req.getParameter("mail");
        MailUtil mailUtil=new MailUtil();
        mailUtil.setAddress("cc5281@126.com", mail, "留言站注册码");
        mailUtil.send("smtp.126.com", "cc5281@126.com", "BLVJCVTCHDECUIRG");
        /*
         * 设置smtp服务器以及邮箱的帐号和密码
         * 用QQ 邮箱作为发生者不好使 （原因不明）
         * 163 邮箱可以，但是必须开启  POP3/SMTP服务 和 IMAP/SMTP服务
         * 因为程序属于第三方登录，所有登录密码必须使用163的授权码
         */
        int vCode = mailUtil.getVCode();
        req.setAttribute("vode",vCode);
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }
}
