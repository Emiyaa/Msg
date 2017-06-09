package compsg.cn.msgboard.service;

import compsg.cn.msgboard.bean.Users;
import compsg.cn.msgboard.dao.UsersDao;

public class LoginService {
	private UsersDao dao = new UsersDao();
	
	/**
	 * 判断用户名和密码是否正确，正确则返回true，如果用户不存在或者密码错误则返回false
	 * @param userName 用户登录名
	 * @param userPassword 密码
	 * @return 是否登陆成功
	 */
	public Users checkUser(String userName, String userPassword){
		Users user = dao.findUserByName(userName);
		
		if(user!=null){
			if(user.getUserPassword().equals(userPassword))
				return user;
		}
		return null;
	}
}
