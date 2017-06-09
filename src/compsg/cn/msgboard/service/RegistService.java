package compsg.cn.msgboard.service;

import java.sql.Date;

import compsg.cn.msgboard.bean.Users;
import compsg.cn.msgboard.dao.UsersDao;
import compsg.cn.msgboard.utils.CheckUtil;

public class RegistService {
	private UsersDao dao = new UsersDao();
	
	/**
	 * 判断注册表单的各输入项是否符合规定的格式要求
	 * @param userName 用户登录名
	 * @param userNickName 用户昵称
	 * @param userPassword 密码
	 * @param userBirthday 用户生日字符串
	 * @param userMobile 手机号
	 * @param userMail 邮箱地址
	 * @return 注册表单信息是否符合格式要求
	 */
	public void checkRegistInfo(String userName, String userNickName, String userPassword, 
			String userBirthday, String userMobile, String userMail){
		if(CheckUtil.checkSpace(userName)||!CheckUtil.checkLength(userName))
			throw new RuntimeException("用户名不能为空或必须小于16位！");
		if(dao.findUserByName(userName)!=null)
			throw new RuntimeException("用户名已存在！");
		if(CheckUtil.checkSpace(userNickName)||!CheckUtil.checkLength(userNickName))
			throw new RuntimeException("昵称不能为空或必须小于16位！");
		if(CheckUtil.checkSpace(userPassword)||!CheckUtil.checkLength(userPassword))
			throw new RuntimeException("密码不能为空或必须小于16位");
		if(CheckUtil.checkSpace(userBirthday)||!CheckUtil.checkBirthday(userBirthday))
			throw new RuntimeException("日期不能为空或格式不正确！");
		if(CheckUtil.checkSpace(userMobile)||!CheckUtil.checkMobile(userMobile))
			throw new RuntimeException("手机不能为空或格式不正确！");
		if(CheckUtil.checkSpace(userMail)||!CheckUtil.checkMail(userMail))
			throw new RuntimeException("邮箱不能为空或格式不正确！");
	}
	
	/**
	 * 注册该用户的信息到数据库
	 * @param user 用户对象
	 * @return 是否注册成功
	 */
	public boolean addUser(String userName, String userNickName, String userPassword, 
			String userBirthday, String userMobile, String userMail){
		Users user = new Users(userName, userNickName, userPassword, 
				Date.valueOf(userBirthday), userMobile, userMail);
		return dao.addUser(user);
	}
}
