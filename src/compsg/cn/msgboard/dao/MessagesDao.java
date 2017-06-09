package compsg.cn.msgboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import compsg.cn.msgboard.bean.Messages;
import compsg.cn.msgboard.utils.DBUtil;

public class MessagesDao {
	
	/**
	 * 根据指定的关键字进行查询（模糊匹配留言内容或用户昵称），如果指定条件为null则返回所有留言
	 * @param condition 指定查询的关键字
	 * @return 存有留言对象的List集合
	 */
	public List<Messages> findPageMessagesByCondition(String condition, int pageNow, int pageSize){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;

		String sql = "select * from messages m "
				+ "left outer join users u on m.userId = u.userId "
				+ "where u.userNickName like ? or m.msgContent like ?"
				+ "order by m.msgTime desc limit "
				+ ((pageNow - 1) * pageSize) + " , "
				+ pageSize;
		try {
			pstat = con.prepareStatement(sql);
			if(condition == null){
				pstat.setString(1, "%%");
				pstat.setString(2, "%%");
			}
			else{
				pstat.setString(1, "%" + condition + "%");
				pstat.setString(2, "%" + condition + "%");
			}
			rs = pstat.executeQuery();
			
			List<Messages> msgList = new ArrayList<Messages>();
			Messages msg = null;
			while(rs.next()){
				msg = new Messages();
				msg.setMsgId(rs.getInt("msgId"));
				msg.setUser(new UsersDao().findUserById(rs.getInt("userId")));
				msg.setMsgTime(rs.getString("msgTime"));
				msg.setMsgContent(rs.getString("msgContent"));
				msgList.add(msg);
			}
			return msgList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.CloseResource(con, pstat, rs);
		}

		return null;
	}
	
	/**
	 * 根据条件获取留言总数，如果条件为null则返回所有留言总数
	 * @param condition 指定查询关键字
	 * @return 留言总数
	 */
	public int getTotalRows(String condition){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "select count(*) from messages m "
				+ "left join users u on m.userId = u.userId "
				+ "where u.userNickname like ? or m.msgContent like ? "
				+ "order by m.msgtime asc";
		try {
			pstat = con.prepareStatement(sql);
			if(condition == null){
				pstat.setString(1, "%%");
				pstat.setString(2, "%%");
			}
			else{
				pstat.setString(1, "%" + condition + "%");
				pstat.setString(2, "%" + condition + "%");
			}
			rs = pstat.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询留言总数失败！");
		} finally{
			DBUtil.CloseResource(con, pstat, rs);
		}
	}
	public boolean addMessage(Messages msg){
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into messages "
					+ "(userId,msgTime,msgContent) values(?,?,?)");
			ps.setInt(1, msg.getUser().getUserId());
			ps.setTimestamp(2 ,null);
			ps.setString(3, msg.getMsgContent());
			if (ps.executeUpdate() == 1)
				return true;
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.CloseResource(con,ps,null);
		}
		return false;
	}
}
