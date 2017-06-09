package compsg.cn.msgboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import compsg.cn.msgboard.bean.Users;
import compsg.cn.msgboard.utils.DBUtil;

public class UsersDao {

	/**
	 * 通过用户id查找用户对象，找到则返回Users对象，否则返回null
	 * @param id 用户id
	 * @return 用户对象
	 */
	public Users findUserById(int id){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		Users user = null;
		
		try {
			pstat = con.prepareStatement("select * from users where userId = ?");
			pstat.setInt(1, id);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				user = new Users();
				user.setUserId(id);
				user.setUserName(rs.getString("userName"));
				user.setUserNickName(rs.getString("userNickName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserMobile(rs.getString("userMobile"));
				user.setUserMail(rs.getString("userMail"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.CloseResource(con, pstat, rs);
		}
		return null;
	}
	
	/**
	 * 通过用户的登录名查找用户对象，找到则返回Users对象，否则返回null
	 * @param name 用户登录名
	 * @return 用户对象
	 */
	public Users findUserByName(String name){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		Users user = null;
		
		try {
			pstat = con.prepareStatement("select * from users where userName = ?");
			pstat.setString(1, name);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				user = new Users();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(name);
				user.setUserNickName(rs.getString("userNickName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserMobile(rs.getString("userMobile"));
				user.setUserMail(rs.getString("userMail"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.CloseResource(con, pstat, rs);
		}
		return null;
	}
	
	/**
	 * 向数据库加入用户，加入成功返回true，否则返回false
	 * @param user 用户对象
	 * @return 是否加入成功
	 */
	public boolean addUser(Users user){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstat = null;
		try {
			pstat = con.prepareStatement("insert into users values" +
					"(users_seq.nextval,?,?,?,?,?,?)");
			pstat.setString(1, user.getUserName());
			pstat.setString(2, user.getUserNickName());
			pstat.setString(3, user.getUserPassword());
			pstat.setDate(4, user.getUserBirthday());
			pstat.setString(5, user.getUserMobile());
			pstat.setString(6, user.getUserMail());
			
			if(pstat.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.CloseResource(con, pstat, null);
		}
		return false;
	}
}
