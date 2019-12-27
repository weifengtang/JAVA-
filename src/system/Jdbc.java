package system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



/**
 * ���ݿ���� ������ 
 * @author 
 *
 */
public class Jdbc {
	static String JDriver;// SQL���ݿ�����    
	static String URl;
	static String userName;
	static String userPwd;
	//��̬����� �������ʱ����
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
	/******** �������ݲ��� **********/
	public static void insert(String sql) throws ClassNotFoundException,SQLException {
		Connection con=getconnection();
		Statement stmt = con.createStatement();
		int num = stmt.executeUpdate(sql);
		// 5.��������� ��ʾ���
		if (num >= 1) {
			System.out.print("ִ��executeUpdate�ɹ�");
		} else {
			System.out.print("ִ��executeUpdateʧ��");
		}
		close(con, stmt,null);
	}

	/******* �޸����ݲ��� **********/
	public static void update(String sql) throws ClassNotFoundException,SQLException {
		
		Connection con = getconnection();
		Statement stmt = con.createStatement();
		int num = stmt.executeUpdate(sql);
		if (num >= 1) {
			System.out.print("ִ��executeUpdate�ɹ�");
		} else {
			System.out.print("ִ��executeUpdateʧ��");
		}
		close(con, stmt,null);
	}

	/******** ��ѯ���ݲ��� **********/
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

	 /*******��ȡ���ݿ�����con********/
	public static Connection getconnection() {
		Connection con = null;
		try {
			Class.forName(JDriver); // ���ݿ�
			con = DriverManager.getConnection(URl, userName, userPwd);
		} catch (Exception e) {
		}
		return con;
	}

	/* �ر����ݿ� con,stmt rs ���� */
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
