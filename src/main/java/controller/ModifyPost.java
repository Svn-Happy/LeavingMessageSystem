package controller;

import model.UserDAO;
import pojo.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/modifypost")
public class ModifyPost extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int num = (int)session.getAttribute("num");
        System.out.println("要修改的留言id是"+num);
        //留言内容
        String text=req.getParameter("text");
        System.out.println("要修改的留言内容是"+text);

        Message message=new Message();
        message.setNum(num);
        message.setMessage(text);

        UserDAO userDAO=new UserDAO();
        int st = userDAO.UpdateMessage(message);

        //重定向
        resp.sendRedirect("/readall");
    }
}
