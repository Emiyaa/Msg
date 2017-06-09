package compsg.cn.msgboard.service;

import java.util.List;

import compsg.cn.msgboard.bean.Messages;
import compsg.cn.msgboard.bean.Users;
import compsg.cn.msgboard.dao.MessagesDao;
import compsg.cn.msgboard.dao.UsersDao;
import compsg.cn.msgboard.utils.PageUtil;

public class MessagesService {
	private MessagesDao mdao = new MessagesDao();
	private UsersDao udao = new UsersDao();
	
	/**
	 * 获得留言数和关于页码的所有信息
	 * @param pageSize 每页的记录行数
	 * @param str_pageNow 当前页码
	 * @param condition 查询关键字
	 * @return 页面信息
	 */
	public PageUtil getPageInfo(Integer pageSize, String str_pageNow, String condition){
		return new PageUtil(pageSize, mdao.getTotalRows(condition), str_pageNow);
	}
	
	/**
	 * 获得指定条件的留言记录
	 * @param pageSize 每页的记录行数
	 * @param str_pageNow 当前页码
	 * @param condition 指定的条件
	 * @return 一页大小的指定条件的留言记录
	 */
	public List<Messages> showMessages(int pageSize, String str_pageNow, String condition){
		return mdao.findPageMessagesByCondition(condition, Integer.valueOf(str_pageNow), pageSize);
	}
	
	/**
	 * 得到留言总数
	 * @param condition 指定查询关键字
	 * @return 留言总数
	 */
	public int getTotalRows(String condition){
		return mdao.getTotalRows(condition);
	}

	public boolean addMessages(int userId,String msgContent){
		Users user = udao.findUserById(userId);
		Messages msg = new Messages(msgContent,user);
		return mdao.addMessage(msg);
	}

}
