package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName="RegFilter",urlPatterns = "/reg")
public class RegFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email=request.getParameter("email");
        String uservcode=request.getParameter("uservcode");
        if(username==null||username.length()<=0){
            System.out.println("注册时用户名为空");
            request.setAttribute("warning","用户名不能为空！");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
        if(password==null||password.length()<=0){
            System.out.println("注册时密码为空");
            request.setAttribute("warning","密码不能为空！");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
        if(email==null||email.length()<=0){
            System.out.println("注册时邮箱为空");
            request.setAttribute("warning","邮箱不能为空！");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
        if(uservcode==null||uservcode.length()<=0){
            System.out.println("注册时验证码为空");
            request.setAttribute("warning","验证码不能为空！");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
