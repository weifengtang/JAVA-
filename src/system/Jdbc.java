package system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



/**
 * 数据库操作 工具类 
 * @author 
 *
 */
public class Jdbc {
	static String JDriver;// SQL数据库引擎    
	static String URl;
	static String userName;
	static String userPwd;
	//静态代码块 在类加载时出现
	static{
		ResourceBundle rb=ResourceBundle.getBundle("info");
		JDriver=rb.getString("JDriver");
		URl=rb.getString("URl");
		userName=rb.getString("userName");
		userPwd=rb.getString("userPwd");
		try {
			Class.forName(JDriver); 
		} catch (Exception e) {}
		
	}	
	/******** 插入数据操作 **********/
	public static void insert(String sql) throws ClassNotFoundException,SQLException {
		Connection con=getconnection();
		Statement stmt = con.createStatement();
		int num = stmt.executeUpdate(sql);
		// 5.遍历结果集 显示结果
		if (num >= 1) {
			System.out.print("执行executeUpdate成功");
		} else {
			System.out.print("执行executeUpdate失败");
		}
		close(con, stmt,null);
	}

	/******* 修改数据操作 **********/
	public static void update(String sql) throws ClassNotFoundException,SQLException {
		
		Connection con = getconnection();
		Statement stmt = con.createStatement();
		int num = stmt.executeUpdate(sql);
		if (num >= 1) {
			System.out.print("执行executeUpdate成功");
		} else {
			System.out.print("执行executeUpdate失败");
		}
		close(con, stmt,null);
	}

	/******** 查询数据操作 **********/
	public static void select(String sql) throws ClassNotFoundException,SQLException {
		Connection con=getconnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ResultSetMetaData rsmd=rs.getMetaData();
			int columnCount=rsmd.getColumnCount();
			for(int i=1;i<=columnCount;i++){
				String v=rs.getString(i);	
			}
		}
		close(con, stmt,null);
	}

	 /*******获取数据库连接con********/
	public static Connection getconnection() {
		Connection con = null;
		try {
			Class.forName(JDriver); // 数据库
			con = DriverManager.getConnection(URl, userName, userPwd);
		} catch (Exception e) {
		}
		return con;
	}

	/* 关闭数据库 con,stmt rs 方法 */
	public static void close(Connection con, Statement stmt,ResultSet rs) {
		try {
			if (rs != null) {
				try{
					rs.close();
				}catch(Exception ee){
					
				}
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
		}
	}
	
}
