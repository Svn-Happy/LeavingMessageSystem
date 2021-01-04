package controller;

import model.UserDAO;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //明确接收字符编码集
        //接收用户注册信息
        //创建UserDAO对象
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //封装user
        User user=new User();
        user.setId(username);
        user.setPassword(password);

        UserDAO userDAO=new UserDAO();

        //查询用户名是否唯一（能否注册）
            //唯一存储
            //不唯一提示
        User searcheduser = userDAO.FindUser(username);
        if(searcheduser==null){ //唯一
            userDAO.SaveUser(user);
        }else {//不唯一
            req.setAttribute("warning","用户名不唯一");
            req.getRequestDispatcher("").forward(req,resp);
        }
    }
}
