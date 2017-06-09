package compsg.cn.msgboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import compsg.cn.msgboard.bean.Users;
import compsg.cn.msgboard.service.LoginService;

@WebServlet(name = "LoginAction")
public class LoginAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginService loginService = new LoginService();

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String op = request.getParameter("op");
        if("regist".equals(op)){
            request.getRequestDispatcher("/WEB-INF/page/regist.jsp").forward(request, response);
            return;
        }

        //判断用户名和密码是否正确
        Users user = loginService.checkUser(userName, userPassword);
        if(user != null){
            request.getSession().setAttribute("user", user);

            //正确则进入留言板界面
            HttpSession session = request.getSession();
            session.setAttribute("userNickName", user.getUserNickName());
            request.getRequestDispatcher("/OpMessageAction").forward(request, response);
            return;
        }
        request.getSession().setAttribute("message", "用户名或密码错误！");
        //否则重新跳转到登陆界面
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
