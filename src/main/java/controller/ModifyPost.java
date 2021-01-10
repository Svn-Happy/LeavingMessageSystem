package controller;

import model.UserDAO;
import pojo.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyPost extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("id");
        //留言内容
        String text=req.getParameter("message");

        Message message=new Message();
        message.setNum(Integer.parseInt(num));
        message.setMessage(text);

        UserDAO userDAO=new UserDAO();
        int st = userDAO.UpdateMessage(message);

        //重定向
        resp.sendRedirect("leavingMessage.jsp");
    }
}
