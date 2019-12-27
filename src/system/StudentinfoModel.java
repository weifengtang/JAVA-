package system;
//学生信息  数据模型
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class StudentinfoModel extends AbstractTableModel {
	// rowData用来存放行数据
	// columnNames 存放列名
	Vector rowData;
	Vector columnNames;
	Vector hang;
	// 定义操作数据库参数
	String JDriver = "com.mysql.jdbc.Driver";// SQL数据库引擎
	String URl = "jdbc:mysql://127.0.0.1:3306/student";
	String userName = "root";
	String userPwd = "123";
	// String sql;
	// 定义连接数据库的变量
	Connection ct = null;
	Statement stmt = null;
	ResultSet rs = null;

	public void init(String sql) {
		if (sql.equals("")) {
			sql = "Select * From infostudent ORDER BY Sno ASC";
		}
		// 设置列名
		columnNames = new Vector(10);
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("学院");
		columnNames.add("专业");
		columnNames.add("登入密码");
		// 存放多行
		rowData = new Vector(10);
		try {
			ct = Jdbc.getconnection();
			stmt = ct.createStatement();// 创建stat对象
			rs = stmt.executeQuery(sql);// 查询结果
			while (rs.next()) {
				Vector hang = new Vector(10);
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				rowData.add(hang);
			}

		} catch (Exception r) {
		}
		Jdbc.close(ct, stmt, rs);

	}

	// 增加学生函数
	public void addStudent(String sql) {

	}

	// 第二个构造函数，通过传递的sql语句来获得数据模型
	public StudentinfoModel(String sql) {
		this.init(sql);
	}

	// 构造函数，用于初始化我的数据模型（表）
	public StudentinfoModel() {
		this.init("");
	}

	// 得到行数
	@Override
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.rowData.size();
	}

	// 得到列数
	@Override
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		return this.columnNames.size();
	}

	// 得到数据
	@Override
	public Object getValueAt(int row, int column) {
		// TODO 自动生成的方法存根
		return ((Vector) (this.rowData.get(row))).get(column);
	}

	// 得到属性名字
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}
}
