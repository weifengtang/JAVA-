package system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

//***********信息界面***************	
class AddstuFrame extends JFrame implements ActionListener {
	JLabel lbsno, lbpwd, lbpwd1, lbname;
	JTextField jtname, jtsex, jtdept, jtmajor, jtsno, jtpwd, jtpwd1;
	String sql;
	StudentinfoModel sm;

	/* 增加成绩信息界面 */
	public AddstuFrame() {
		this.setTitle("增加学生成绩信息");
		this.setSize(500, 400);
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel();
		JPanel jp = new JPanel(new GridLayout(7, 10, 0, 5));
		JButton btn1 = new JButton("确定");
		lbsno = new JLabel("                      学  号:");
		jtsno = new JTextField(10);
		lbname = new JLabel("                   姓  名:");
		jtname = new JTextField(10);
		JLabel lbsex = new JLabel("              JAVA成绩:");
		jtsex = new JTextField(10);
		JLabel lbdept = new JLabel("             数据库成绩:");
		jtdept = new JTextField(10);
		JLabel lbmajor = new JLabel("            英语成绩:");
		jtmajor = new JTextField(10);
		lbpwd = new JLabel("    	      总 分:");
		jtpwd = new JTextField(10);

		// 设置文本框字体颜色
		jtsex.setForeground(Color.red);
		jtmajor.setForeground(Color.red);
		jtname.setForeground(Color.red);
		jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		// 设置文本框字体大小
		jtname.setFont(new Font("Dialog", 0, 22));
		jtsex.setFont(new Font("Dialog", 0, 22));
		jtdept.setFont(new Font("Dialog", 0, 22));
		jtmajor.setFont(new Font("Dialog", 0, 22));
		jtpwd.setFont(new Font("Dialog", 0, 22));
		jtsno.setFont(new Font("Dialog", 0, 22));
		// 设置标签字体大小
		lbsno.setFont(new Font("Dialog", 1, 22));
		lbname.setFont(new Font("Dialog", 1, 22));
		lbsex.setFont(new Font("Dialog", 1, 22));
		lbdept.setFont(new Font("Dialog", 1, 22));
		lbpwd.setFont(new Font("Dialog", 1, 22));
		lbmajor.setFont(new Font("Dialog", 1, 22));
		// 添加组件到面板

		jp.add(lbsno);
		jp.add(jtsno);
		jp.add(lbname);
		jp.add(jtname);
		jp.add(lbsex);
		jp.add(jtsex);
		jp.add(lbdept);
		jp.add(jtdept);
		jp.add(lbmajor);
		jp.add(jtmajor);
		jp.add(lbpwd);
		jp.add(jtpwd);
		jp2.add(btn1);
		jp1.add(jp, BorderLayout.CENTER);
		jp1.add(jp2, BorderLayout.SOUTH);
		btn1.addActionListener(this);
		btn1.setActionCommand("btn1");
		jp2.add(btn1);
		jp1.add(jp, BorderLayout.CENTER);
		jp1.add(jp2, BorderLayout.SOUTH);

		this.add(jp1);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btn1")) {
			int resOne = JOptionPane.showConfirmDialog(this, "确定增加成绩信息", "成绩",
					JOptionPane.OK_CANCEL_OPTION);
			if (resOne == 0) {
				String sno = jtsno.getText().trim();
				String n = jtname.getText().trim();
				String s = jtsex.getText().trim();
				String d = jtdept.getText().trim();
				String m = jtmajor.getText().trim();
				String p = jtpwd.getText().trim();
				try {
					String sql = "INSERT INTO gradestudent(Sno,Sname,Grade1,Grade2,Grade3,TotalGrade)values('"
							+ sno
							+ "','"
							+ n
							+ "','"
							+ s
							+ "','"
							+ d
							+ "','"
							+ m + "','" + p + "')";
					Jdbc.insert(sql);
					this.dispose();
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		}

	}
}

class AddstuFrame2 extends JFrame implements ActionListener {
	JLabel lbsno, lbpwd, lbpwd1, lbname;
	JTextField jtname, jtsex, jtdept, jtmajor, jtsno, jtpwd, jtpwd1;
	String sql;
	StudentinfoModel sm;
	String sno, name, sex, dept, major, pwd;// Grade1,Grade2,Grade3,TotalGrade;

	/* 修改成绩信息界面 */
	public AddstuFrame2(String sno, String name, String sex, String dept,
			String major, String pwd) {
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.dept = dept;
		this.major = major;
		this.pwd = pwd;

		this.setTitle("修改学生成绩信息");
		this.setSize(500, 400);
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel();
		JPanel jp = new JPanel(new GridLayout(7, 10, 0, 5));
		JButton btn1 = new JButton("确定");
		btn1.setActionCommand("btn1");
		btn1.addActionListener(this);

		lbsno = new JLabel("                      学  号:");
		jtsno = new JTextField(sno, 10);
		lbname = new JLabel("                   姓  名:");
		jtname = new JTextField(name, 10);
		JLabel lbsex = new JLabel("           JAVA成绩:");
		jtsex = new JTextField(sex, 10);
		JLabel lbdept = new JLabel("           数据库成绩:");
		jtdept = new JTextField(dept, 10);
		JLabel lbmajor = new JLabel("           英语成绩:");
		jtmajor = new JTextField(major, 10);
		lbpwd = new JLabel("    	      总分:");
		jtpwd = new JTextField(pwd, 10);

		// 设置文本框字体颜色
		jtsex.setForeground(Color.red);
		jtmajor.setForeground(Color.red);
		jtname.setForeground(Color.red);
		jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		// 设置文本框字体大小
		jtname.setFont(new Font("Dialog", 0, 22));
		jtsex.setFont(new Font("Dialog", 0, 22));
		jtdept.setFont(new Font("Dialog", 0, 22));
		jtmajor.setFont(new Font("Dialog", 0, 22));
		jtpwd.setFont(new Font("Dialog", 0, 22));
		jtsno.setFont(new Font("Dialog", 0, 22));
		// 设置标签字体大小
		lbsno.setFont(new Font("Dialog", 1, 22));
		lbname.setFont(new Font("Dialog", 1, 22));
		lbsex.setFont(new Font("Dialog", 1, 22));
		lbdept.setFont(new Font("Dialog", 1, 22));
		lbpwd.setFont(new Font("Dialog", 1, 22));
		lbmajor.setFont(new Font("Dialog", 1, 22));
		// 添加组件到面板

		jp.add(lbsno);
		jp.add(jtsno);
		jp.add(lbname);
		jp.add(jtname);
		jp.add(lbsex);
		jp.add(jtsex);
		jp.add(lbdept);
		jp.add(jtdept);
		jp.add(lbmajor);
		jp.add(jtmajor);
		jp.add(lbpwd);
		jp.add(jtpwd);
		jp2.add(btn1);
		jp1.add(jp, BorderLayout.CENTER);
		jp1.add(jp2, BorderLayout.SOUTH);
		jp2.add(btn1);
		jp1.add(jp, BorderLayout.CENTER);
		jp1.add(jp2, BorderLayout.SOUTH);

		this.add(jp1);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btn1")) {
			int resOne = JOptionPane.showConfirmDialog(new AddstuFrame2(sno,
					name, sex, dept, major, pwd), "确定修改", "成绩",
					JOptionPane.OK_CANCEL_OPTION);
			if (resOne == 0) {
				String s = jtsno.getText().trim();
				String n = jtname.getText().trim();
				String x = jtsex.getText().trim();
				String d = jtdept.getText().trim();
				String m = jtmajor.getText().trim();
				String p = jtpwd.getText().trim();
				try {
					String sql = "update gradestudent set Sno='" + s
							+ "',Sname='" + n + "',Grade1='" + x + "',Grade2='"
							+ d + "',Grade3='" + m + "',TotalGrade='" + p
							+ "' where Sno='" + sno + "'";
					Jdbc.insert(sql);
					this.dispose();
				} catch (Exception ss) {
					ss.printStackTrace();
				}
			}

		}

	}

}
