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
        UserDAO userDAO=new UserDAO();
        List<Message> messageList = userDAO.FindAllMessage();
        req.setAttribute("list",messageList);
        req.getRequestDispatcher("").forward(req,resp);
    }
}
