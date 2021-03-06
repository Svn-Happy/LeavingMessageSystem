package controller;

import model.UserDAO;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收字符转码
        //接收用户名和密码
        //创建DAO
        //检查用户的密码是否正确
            //正确进入留言界面
            //不正确进行提示
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAO userDAO=new UserDAO();

        User user = userDAO.FindUser(username);
        if(user==null){//不存在
            req.setAttribute("warning","用户不存在!");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            System.out.println("用户不存在!");
        }else{//存在
            if(user.getPassword().equals(password)){//密码正确
                req.setAttribute("name",username);//用户名
                req.getRequestDispatcher("/readall").forward(req,resp);//跳转
                //req.getRequestDispatcher("leavingMessage.jsp").forward(req,resp);
                System.out.println("密码正确");
                System.out.println(username);

            }else {//密码错误
                req.setAttribute("warning","密码错误!");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                System.out.println("密码错误!");
            }
        }
    }
}
