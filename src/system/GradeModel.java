package system;
//学生成绩  数据模型
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class GradeModel extends AbstractTableModel {
	JTable jt = null;
	JScrollPane jsp = null;
	// rowData用来存放行数据
	// columnNames 存放列名
	Vector<Object> rowData1;
	Vector<Object> columnNames1;
	Vector<Object> hang;
	// 定义操作数据库参数
	String JDriver = "com.mysql.jdbc.Driver";// SQL数据库引擎
	String URl = "jdbc:mysql://127.0.0.1:3306/student";
	String userName = "root";
	String userPwd = "123";
	String sql;

	public void init(String sql) {
		if(sql.equals("")){
			sql = "Select * From gradestudent ORDER BY Sno ASC";
		}
      
		// 设置列名
		columnNames1 = new Vector<Object>();
		columnNames1.add("学号");
		columnNames1.add("姓名");
		columnNames1.add("JAVA成绩");
		columnNames1.add("数据库成绩");
		columnNames1.add("英语成绩");
		columnNames1.add("总分");
		// 存放多行
		rowData1 = new Vector<Object>();
		try {
			Connection con = Jdbc.getconnection();
			Statement stmt = con.createStatement();// 创建stat对象
			ResultSet rs = stmt.executeQuery(sql);// 查询结果
			while (rs.next()) {
				Vector<Object> hang = new Vector<Object>();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				rowData1.add(hang);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 第二个构造函数，通过传递的sql语句来获得数据模型
		public GradeModel(String sql) {
			this.init(sql);
		}

		// 构造函数，用于初始化我的数据模型（表）
		public GradeModel() {
			this.init("");
		}
  
	
	// 得到行数
	@Override
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.rowData1.size();
	}

	// 得到列数
	@Override
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		return this.columnNames1.size();
	}

	// 得到数据
	@Override
	public Object getValueAt(int row, int column) {
		// TODO 自动生成的方法存根
		return ((Vector) (this.rowData1.get(row))).get(column);
	}

	// 得到属性名字
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames1.get(column);
	}
}
