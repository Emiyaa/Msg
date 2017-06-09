package compsg.cn.msgboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import compsg.cn.msgboard.bean.Users;
import compsg.cn.msgboard.service.MessagesService;
import compsg.cn.msgboard.utils.PageUtil;

@WebServlet(name = "OpMessageAction")
public class OpMessageAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MessagesService messagesService = new MessagesService();
        //获取操作字符串
        String op = request.getParameter("op");
        //获取当前页码
        String str_pageNow = request.getParameter("str_pageNow");
        //获取查询关键字
        String condition = request.getParameter("condition");

        //如果是查询操作
        if("search".equals(op)){
            //把该关键字存到request中
            request.getSession().setAttribute("condition", condition);
        }

		/*在此添加如果是添加操作的代码*/
        if("add".equals(op)){
            Users user =(Users) request.getSession().getAttribute("user");
            String msgContent = request.getParameter("msgContent");
            if(msgContent != null && !"".equals(msgContent)){
                messagesService.addMessages(user.getUserId(),msgContent);
            }
            request.getSession().removeAttribute("condition");
            request.getSession().removeAttribute("page");
        }

        //获取页面对象
        PageUtil page = messagesService.getPageInfo(5, str_pageNow,
                (String)request.getSession().getAttribute("condition"));
        request.getSession().setAttribute("page", page);
        //跳转到显示留言的servlet处理
        request.getRequestDispatcher("/ShowMessagesAction").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
