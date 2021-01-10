package controller;

import model.UserDAO;
import pojo.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/modify")
public class ModifyMessage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("id");
        UserDAO userDAO=new UserDAO();
        Message message = userDAO.FindMessageByNum(num);
        req.setAttribute("id",message.getNum());
        req.setAttribute("content",message.getMessage());

        req.getRequestDispatcher("modify.jsp").forward(req,resp);
    }
    //    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //消息id
//        int massage_id = Integer.parseInt(req.getParameter("massage_id"));
//        //消息内容
//        String text = req.getParameter("text");
//
//        //封装
//        Message message=new Message();
//        message.setNum(massage_id);
//
//        UserDAO userDAO=new UserDAO();
//        userDAO.UpdateMessage(message);
//
//        //更新后重定向
//        resp.sendRedirect("leavingMessage.jsp");
//
//    }
}
