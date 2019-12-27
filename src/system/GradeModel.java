package system;
//ѧ���ɼ�  ����ģ��
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
	// rowData�������������
	// columnNames �������
	Vector<Object> rowData1;
	Vector<Object> columnNames1;
	Vector<Object> hang;
	// ����������ݿ����
	String JDriver = "com.mysql.jdbc.Driver";// SQL���ݿ�����
	String URl = "jdbc:mysql://127.0.0.1:3306/student";
	String userName = "root";
	String userPwd = "123";
	String sql;

	public void init(String sql) {
		if(sql.equals("")){
			sql = "Select * From gradestudent ORDER BY Sno ASC";
		}
      
		// ��������
		columnNames1 = new Vector<Object>();
		columnNames1.add("ѧ��");
		columnNames1.add("����");
		columnNames1.add("JAVA�ɼ�");
		columnNames1.add("���ݿ�ɼ�");
		columnNames1.add("Ӣ��ɼ�");
		columnNames1.add("�ܷ�");
		// ��Ŷ���
		rowData1 = new Vector<Object>();
		try {
			Connection con = Jdbc.getconnection();
			Statement stmt = con.createStatement();// ����stat����
			ResultSet rs = stmt.executeQuery(sql);// ��ѯ���
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
	// �ڶ������캯����ͨ�����ݵ�sql������������ģ��
		public GradeModel(String sql) {
			this.init(sql);
		}

		// ���캯�������ڳ�ʼ���ҵ�����ģ�ͣ���
		public GradeModel() {
			this.init("");
		}
  
	
	// �õ�����
	@Override
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rowData1.size();
	}

	// �õ�����
	@Override
	public int getColumnCount() {
		// TODO �Զ����ɵķ������
		return this.columnNames1.size();
	}

	// �õ�����
	@Override
	public Object getValueAt(int row, int column) {
		// TODO �Զ����ɵķ������
		return ((Vector) (this.rowData1.get(row))).get(column);
	}

	// �õ���������
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames1.get(column);
	}
}
