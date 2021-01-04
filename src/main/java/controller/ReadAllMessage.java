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

@WebServlet(urlPatterns = "/read")
public class ReadAllMessage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建DAO
        //查询用户的所有留言
        String username = req.getParameter("username");
        UserDAO userDAO=new UserDAO();
        List<Message> list = userDAO.FindMessage("username");
        req.setAttribute("list",list);
        req.getRequestDispatcher("").forward(req,resp);
    }
}
