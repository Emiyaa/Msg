package compsg.cn.msgboard.utils;

import java.io.UnsupportedEncodingException;

public class CheckUtil {
	
	/**
	 * 判断输入项是否超长
	 * @param field 用户名、用户昵称或者密码
	 * @return 是否超长
	 */
	public static boolean checkLength(String field){
		try {
			if(field.getBytes("gbk").length<=16)
				return true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断用户输入的日期是否符合格式
	 * @param userBirthday 用户生日日期字符串
	 * @return 是否符合日期格式
	 */
	public static boolean checkBirthday(String userBirthday){
		String regex = "[12]\\d{3}-[01]?\\d-[0-3]?\\d";
		return userBirthday.matches(regex);
	}
	
	/**
	 * 判断用户输入的手机号是否符合格式
	 * @param userMobile 用户手机号
	 * @return 是否符合手机号格式
	 */
	public static boolean checkMobile(String userMobile){
		String regex = "^1[3-578]\\d{9}$";
		return userMobile.matches(regex);
	}
	
	/**
	 * 判断用户输入的邮箱是否符合格式
	 * @param userMail 用户邮箱地址
	 * @return 是否符合邮箱地址格式
	 */
	public static boolean checkMail(String userMail){
		String regex="^[\\w]+@[\\w]+(\\.[a-zA-Z]+){1,3}$";
		return userMail.matches(regex);
	}
	
	/**
	 * 判断输入字符串是否为空或空串
	 * @param str 检验字符串
	 * @return 返回是否为空
	 */
	public static boolean checkSpace(String str){
		if(str != null && !"".equals(str))
			return false;
		return true;
	}
}
