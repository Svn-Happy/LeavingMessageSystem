package controller;

import model.UserDAO;
import pojo.Message;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/save")
public class SaveMessage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //用户名
        String username = req.getParameter("user");
        //接收字符转码
        req.setCharacterEncoding("utf-8");
        //接收留言板信息
        String text = req.getParameter("message");
        Message message=new Message();
        message.setMessage(text);
        message.setDate(new Date(new java.util.Date().getTime()));
        //创建DAO
        UserDAO userDAO=new UserDAO();
        //存入数据库
        int st = userDAO.SavaMessage(username, message);
        System.out.println(st);
        resp.sendRedirect("/readall");
    }
}
