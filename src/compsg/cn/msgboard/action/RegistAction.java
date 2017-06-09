package compsg.cn.msgboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import compsg.cn.msgboard.service.RegistService;

@WebServlet(name = "RegistAction")
public class RegistAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RegistService registService = new RegistService();

        String userName = request.getParameter("userName");
        String userNickName = request.getParameter("userNickName");
        String userPassword = request.getParameter("userPassword");
        String userBirthday = request.getParameter("userBirthday");
        String userMobile = request.getParameter("userMobile");
        String userMail = request.getParameter("userMail");

        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
        session.setAttribute("userNickName", userNickName);
        session.setAttribute("userPassword", userPassword);
        session.setAttribute("userBirthday", userBirthday);
        session.setAttribute("userMobile", userMobile);
        session.setAttribute("userMail", userMail);
        try{
            //检查用户输入是否合法
            registService.checkRegistInfo(userName, userNickName,
                    userPassword, userBirthday, userMobile, userMail);
        } catch(RuntimeException e){
            //存入不合法的错误信息
            request.setAttribute("reg_message", e.getMessage());
            //重新跳转到当前页面
            request.getRequestDispatcher("/WEB-INF/page/regist.jsp").forward(request, response);
            return;
        }

        //注册用户
        boolean isAdd = registService.addUser(userName, userNickName,
                userPassword, userBirthday, userMobile, userMail);
        if(isAdd)
            request.getSession().setAttribute("reg_message", "注册成功！");
        else{
            request.getSession().setAttribute("reg_message", "注册失败！");
        }

        //跳转回登陆界面
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
