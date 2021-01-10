package controller;

import model.UserDAO;
import pojo.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/readall")
public class ReadAllMassage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询allMessage");
        UserDAO userDAO=new UserDAO();
        List<Message> messageList = userDAO.FindAllMessage();
//        for (Message m:messageList) {
//            System.out.println(m.getMessage());
//        }
        req.setAttribute("message",messageList);
        req.setAttribute("size",messageList.size());
        req.getRequestDispatcher("leavingMessage.jsp").forward(req,resp);
    }
}
