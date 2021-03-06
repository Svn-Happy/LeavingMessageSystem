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
        String email=req.getParameter("email");
        String uservcode=req.getParameter("uservcode");
        HttpSession session = req.getSession();
        String vcode;

        //封装user
        User user=new User();
        user.setId(username);
        user.setPassword(password);
        user.setEmail(email);

        UserDAO userDAO=new UserDAO();

        //查询用户名是否唯一（能否注册）
            //唯一存储
            //不唯一提示
        User searcheduser = userDAO.FindUser(username);
        if(searcheduser==null){ //唯一
            if(session.getAttribute("vcode")==null){//未发送验证码
                req.setAttribute("warning","请发送验证码");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }else {//已经发送验证码
                vcode=String.valueOf((int) session.getAttribute("vcode"));
                if(vcode.equals(uservcode)) {//验证码一致
                    userDAO.SaveUser(user);
                    session.removeAttribute("vocode");
                    session.invalidate();
                    req.getRequestDispatcher("index.jsp").forward(req,resp);
                }else {//验证码不一致
                    req.setAttribute("warning","验证码错误!");
                    req.getRequestDispatcher("register.jsp").forward(req,resp);
                }
            }
        }else {//不唯一
            req.setAttribute("warning","用户名已被占用");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
//        if(uservcode.equals("")){//验证码空
//            req.setAttribute("warning","请填写验证码!");
//            req.getRequestDispatcher("register.jsp").forward(req,resp);
//        } else{//验证码不空
//            if(vcode.equals(uservcode)){//验证码一致
//                if(!password.equals("")){//密码非空
//                    if(!username.equals("")){//用户名非空
//                        User searcheduser = userDAO.FindUser(username);
//                        if(searcheduser==null){ //唯一
//                            userDAO.SaveUser(user);
//                            req.getRequestDispatcher("index.jsp").forward(req,resp);
//                        }else {//不唯一
//                            req.setAttribute("warning","用户名已被占用");
//                            req.getRequestDispatcher("register.jsp").forward(req,resp);
//                        }
//                    }else {//用户名空
//                        req.setAttribute("warning","用户名非法!");
//                        req.getRequestDispatcher("register.jsp").forward(req,resp);
//                    }
//                }else {//密码空
//                    req.setAttribute("warning","密码不能为空!");
//                    req.getRequestDispatcher("register.jsp").forward(req,resp);
//                }
//            }else {//验证码不一致
//                req.setAttribute("warning","验证码错误!");
//                req.getRequestDispatcher("register.jsp").forward(req,resp);
//            }
//        }

    }
}