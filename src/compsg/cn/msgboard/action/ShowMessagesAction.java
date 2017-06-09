package compsg.cn.msgboard.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import compsg.cn.msgboard.bean.Messages;
import compsg.cn.msgboard.service.MessagesService;
import compsg.cn.msgboard.utils.PageUtil;

@WebServlet(name = "ShowMessagesAction")
public class ShowMessagesAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MessagesService messagesService = new MessagesService();
        //获取查询关键字
        String condition = (String) request.getSession().getAttribute("condition");
        //得到页面工具类对象
        PageUtil page = (PageUtil) request.getSession().getAttribute("page");
        //得到要显示的留言集合
        List<Messages> msgList = messagesService.showMessages(page.getPageSize(),
                String.valueOf(page.getPageNow()), condition);

        request.getSession().setAttribute("msgList", msgList);

        request.getRequestDispatcher("/WEB-INF/page/msg_board.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
