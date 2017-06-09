package compsg.cn.msgboard.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	/**
	 * 获取数据库连接对象
	 * @return 数据库连接Connection对象
	 */
	public static Connection getConnection(){
		try {
			Context envCtx = (Context) new InitialContext().lookup("java:/comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/msgboard");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭数据库资源
	 * @param con Connection对象
	 * @param stat Statement对象
	 * @param rs ResultSet对象
	 */
	public static void CloseResource(Connection con, Statement stat, ResultSet rs){
		try {
			if(con!=null && !con.isClosed())
				con.close();
			if(stat!=null)
				stat.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
