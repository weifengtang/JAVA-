package system;
//ѧ����Ϣ  ����ģ��
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
	// rowData�������������
	// columnNames �������
	Vector rowData;
	Vector columnNames;
	Vector hang;
	// ����������ݿ����
	String JDriver = "com.mysql.jdbc.Driver";// SQL���ݿ�����
	String URl = "jdbc:mysql://127.0.0.1:3306/student";
	String userName = "root";
	String userPwd = "123";
	// String sql;
	// �����������ݿ�ı���
	Connection ct = null;
	Statement stmt = null;
	ResultSet rs = null;

	public void init(String sql) {
		if (sql.equals("")) {
			sql = "Select * From infostudent ORDER BY Sno ASC";
		}
		// ��������
		columnNames = new Vector(10);
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("ѧԺ");
		columnNames.add("רҵ");
		columnNames.add("��������");
		// ��Ŷ���
		rowData = new Vector(10);
		try {
			ct = Jdbc.getconnection();
			stmt = ct.createStatement();// ����stat����
			rs = stmt.executeQuery(sql);// ��ѯ���
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

	// ����ѧ������
	public void addStudent(String sql) {

	}

	// �ڶ������캯����ͨ�����ݵ�sql������������ģ��
	public StudentinfoModel(String sql) {
		this.init(sql);
	}

	// ���캯�������ڳ�ʼ���ҵ�����ģ�ͣ���
	public StudentinfoModel() {
		this.init("");
	}

	// �õ�����
	@Override
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rowData.size();
	}

	// �õ�����
	@Override
	public int getColumnCount() {
		// TODO �Զ����ɵķ������
		return this.columnNames.size();
	}

	// �õ�����
	@Override
	public Object getValueAt(int row, int column) {
		// TODO �Զ����ɵķ������
		return ((Vector) (this.rowData.get(row))).get(column);
	}

	// �õ���������
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}
}
