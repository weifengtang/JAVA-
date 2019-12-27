package system;
// 教师操作主界面
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TeacherMainFrame extends JFrame implements ActionListener {
	JLabel lbsno, lbname, lbsex, lbdept, lbmajor, lbpwd, lbGrade1, lbGrade2,
			lbGrade3, lbTotal;
	JTextField jtf, jtsno, jtname, jtsex, jtdept, jtmajor, jtpwd, jtGrade1,
			jtGrade2, jtGrade3, jtTotal;
	JPanel jp1, jp2, cardpanel, teainfojp, teainfoupjp, stuinfojp, gradejp,
			updatejp;
	JButton teainfobtn, teainfoupbtn, stuinfobtn, gradebtn, exitbtn, upbtn;
	JButton findbtn, addbtn, debtn, updatebtn, findbtn1, addbtn1, debtn1,
			gxbtn, gxbtn1, updatebtn1,pxbtn;
	CardLayout card;
	JTable jt = null;
	JTable jt1 = null;
	JScrollPane jsp = null;
	StudentinfoModel sm;
	GradeModel sm1;
	// 定义操作数据库参数
	static String JDriver = "com.mysql.jdbc.Driver";// SQL数据库引擎
	static String URl = "jdbc:mysql://127.0.0.1:3306/student";
	static String userName = "root";
	static String userPwd = "123";
	String sql;
	Connection ct = null;
	PreparedStatement ps;
	ResultSet rs;
	String number = null;
	String name, sex, dept, major, pwd, Grade1, Grade2, Grade3, TotalGrade;
	String sno;
	int row, row1;

	public static Connection getconnection() {
		Connection con = null;
		try {
			Class.forName(JDriver); // 数据库
			con = DriverManager.getConnection(URl, userName, userPwd);
		} catch (Exception e) {
		}
		return con;
	}

	// 查看老师个人信息界面

	public JPanel teainfojp() {
		try {
			sql = "select * from infoteacher where ID='" + number + "' "; // 带参数的sql语句
			ct = getconnection();
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// jtname.setText(rs.getString("Sname"));
				// name=rs.getString("Sname");
				sex = rs.getString("Ssex");
				dept = rs.getString("Sdept");
				pwd = rs.getString("Password");
			}
		} catch (Exception c) {
		}
		lbsno = new JLabel("                      工  号:");
		jtsno = new JTextField(number);
		lbname = new JLabel("                      姓  名:");
		jtname = new JTextField(name);
		lbsex = new JLabel("                      性  别:");
		jtsex = new JTextField(sex);
		lbdept = new JLabel("                      学  院:");
		jtdept = new JTextField(dept);
		lbpwd = new JLabel("                    登录密码:");
		jtpwd = new JTextField(pwd);
		// 设置文本框字体颜色
		jtsno.setForeground(Color.YELLOW);
		jtsex.setForeground(Color.red);
		jtname.setForeground(Color.red);
		jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		jtsno.setBackground(Color.gray);
		// 设置文本框字体大小
		jtsno.setFont(new Font("Dialog", 1, 22));
		jtname.setFont(new Font("Dialog", 1, 22));
		jtsex.setFont(new Font("Dialog", 1, 22));
		jtdept.setFont(new Font("Dialog", 1, 22));
		jtpwd.setFont(new Font("Dialog", 1, 22));
		// 设置标签字体大小
		lbsno.setFont(new Font("Dialog", 1, 22));
		lbname.setFont(new Font("Dialog", 1, 22));
		lbsex.setFont(new Font("Dialog", 1, 22));
		lbdept.setFont(new Font("Dialog", 1, 22));
		lbpwd.setFont(new Font("Dialog", 1, 22));
		// 设置文本框不可编辑
		jtsno.setEnabled(false);
		jtname.setEnabled(false);
		jtsex.setEnabled(false);
		jtdept.setEnabled(false);
		jtpwd.setEnabled(false);
		teainfojp = new JPanel(new GridLayout(8, 10, 0, 5));
		teainfojp.add(lbsno);
		teainfojp.add(jtsno);
		teainfojp.add(lbname);
		teainfojp.add(jtname);
		teainfojp.add(lbsex);
		teainfojp.add(jtsex);
		teainfojp.add(lbdept);
		teainfojp.add(jtdept);
		teainfojp.add(lbpwd);
		teainfojp.add(jtpwd);
		return teainfojp;
	}

	// 修改老师个人信息
	public JPanel teainfoupjp() {
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel();
		teainfoupjp = new JPanel(new GridLayout(7, 10, 0, 5));
		try {
			sql = "select * from infoteacher where ID='" + number + "' "; // 带参数的sql语句
			ct = getconnection();
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// jtname.setText(rs.getString("Sname"));
				// name=rs.getString("Sname");
				sex = rs.getString("Ssex");
				dept = rs.getString("Sdept");
				pwd = rs.getString("Password");
			}
		} catch (Exception c) {
		}
		upbtn = new JButton("修改");

		lbsno = new JLabel("                      工  号:");
		jtsno = new JTextField(number);
		lbname = new JLabel("                      姓  名:");
		jtname = new JTextField(name);
		lbsex = new JLabel("                      性  别:");
		jtsex = new JTextField(sex);
		lbdept = new JLabel("                      学  院:");
		jtdept = new JTextField(dept);
		lbpwd = new JLabel("                    登录密码:");
		jtpwd = new JTextField(pwd);

		// 设置文本框字体颜色
		jtsno.setForeground(Color.red);
		jtsex.setForeground(Color.red);
		jtname.setForeground(Color.red);
		jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		// 设置文本框字体大小
		jtname.setFont(new Font("Dialog", 0, 22));
		jtsex.setFont(new Font("Dialog", 0, 22));
		jtdept.setFont(new Font("Dialog", 0, 22));
		jtpwd.setFont(new Font("Dialog", 0, 22));
		jtsno.setFont(new Font("Dialog", 0, 22));
		// 设置标签字体大小
		lbsno.setFont(new Font("Dialog", 1, 22));
		lbname.setFont(new Font("Dialog", 1, 22));
		lbsex.setFont(new Font("Dialog", 1, 22));
		lbdept.setFont(new Font("Dialog", 1, 22));
		lbpwd.setFont(new Font("Dialog", 1, 22));
		jtsno.setEnabled(false);// 设置文本框不可编辑
		// 添加组件到面板
		jp2.add(upbtn);
		teainfoupjp.add(lbsno);
		teainfoupjp.add(jtsno);
		teainfoupjp.add(lbname);
		teainfoupjp.add(jtname);
		teainfoupjp.add(lbsex);
		teainfoupjp.add(jtsex);
		teainfoupjp.add(lbdept);
		teainfoupjp.add(jtdept);
		teainfoupjp.add(lbpwd);
		teainfoupjp.add(jtpwd);
		jp1.add(teainfoupjp, BorderLayout.CENTER);
		jp1.add(jp2, BorderLayout.SOUTH);
		return jp1;
	}

	// 学生信息界面
	public JPanel stuinfojp() {

		/******* 上层界面 *******/
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		jtf = new JTextField(30);
		findbtn = new JButton("查询");
		
		jp1.add(jtf);
		jp1.add(findbtn);
		
		/******* 下层界面 *******/
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		addbtn = new JButton("增加");
		updatebtn = new JButton("修改");
		debtn = new JButton("删除");
		gxbtn = new JButton("刷新");
		gxbtn.addActionListener(new ActionListener() { // 刷新表
			public void actionPerformed(ActionEvent e) {
				sm = new StudentinfoModel();
				jt.setModel(sm);
			}
		});
		jp2.add(addbtn);
		jp2.add(updatebtn);
		jp2.add(debtn);
		jp2.add(gxbtn);
		sm = new StudentinfoModel(); // 实例化一个数据模型对象
		jt = new JTable(sm); // 初始化JTable
		jt.setRowHeight(25);
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = jt.getSelectedColumn(); // 获取选中的列号（记录）
				System.out.println(row);
			}
		});
		// jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// //设置JTable自动调整列表的状态，此处设置为关闭
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 单元格渲染器
		tcr.setHorizontalAlignment(JLabel.CENTER);// 居中显示
		jt.setDefaultRenderer(Object.class, tcr);// 设置渲染器
		jsp = new JScrollPane(jt);
		updatebtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = jt.getSelectedColumn(); // 获取选中的列号（记录）
				System.out.println(row);

			}
		});
		updatebtn.addActionListener(new ActionListener() { // 修改
					public void actionPerformed(ActionEvent e) {
						try {
							if (row != -1) {
								String sno1 = jt.getValueAt(row, 0).toString();// 读取你获取行号的（1，0）的值
								String name1 = jt.getValueAt(row, 1).toString();
								String sex1 = jt.getValueAt(row, 2).toString();
								String dept1 = jt.getValueAt(row, 3).toString();
								String major1 = jt.getValueAt(row, 4).toString();
								String pwd1 = jt.getValueAt(row, 5).toString();
								AddteaFrame2 frame2 = new AddteaFrame2(sno1,name1, sex1, dept1, major1, pwd1);
								frame2.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "请选择一行！",
										"错误！", JOptionPane.ERROR_MESSAGE);
							}

						} catch (Exception x) {
							x.printStackTrace();
						}

					}
				});

		findbtn.addActionListener(new ActionListener() { // 模糊查询 学号

			public void actionPerformed(ActionEvent e) {
				String num = jtf.getText().trim();
				String sql = "select *from infostudent where binary Sno like '%"
						+ num + "%'"; // binary 转换成字符串类型时，长度是8Byte
				// String
				// sql2="select * from infostudent where Sname like '%"+num+"%'";
				if (num.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入查询条件", "错误！",
							JOptionPane.ERROR_MESSAGE);
				} else {
					StudentinfoModel sm2 = new StudentinfoModel(sql);
					jt.setModel(sm2);

				}

			}
		});

		debtn.addActionListener(new ActionListener() { // 删除
			public void actionPerformed(ActionEvent e) {
				try {
					if (row != -1) {
						sno = jt.getValueAt(row, 0).toString();// 读取你获取行号的（1，1）的值
						try {
							String sql = "delete from infostudent where Sno='"
									+ sno + "'";
							Connection cn = Jdbc.getconnection();
							PreparedStatement ps = cn.prepareStatement(sql);
							ps.executeUpdate();
							System.out.println("数据删除成功");
						} catch (Exception s) {
							s.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(null, "请选择一行！", "错误！",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception x) {
					x.printStackTrace();
				}

			}
		});
		JPanel jp3 = new JPanel(new BorderLayout());
		jp3.add(jp1, BorderLayout.NORTH);
		jp3.add(jsp, BorderLayout.CENTER);
		jp3.add(jp2, BorderLayout.SOUTH);
		return jp3;
	}

	// 学生成绩界面
	public JPanel gradejp() {

		// 实例化一个数据模型对象
		sm1 = new GradeModel();
		jt1 = new JTable(sm1);
		jt1.setRowHeight(25);
		

		/******* 上层界面 *******/
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		JTextField jtf2 = new JTextField(30);
		findbtn1 = new JButton("查询");
		pxbtn = new JButton("排序");
		findbtn1.addActionListener(new ActionListener() { // 模糊查询 学号
			public void actionPerformed(ActionEvent e) {
				String num = jtf2.getText().trim();
				String sql = "select *from gradestudent where binary Sno like '%"
						+ num + "%'"; // binary 转换成字符串类型时，长度是8Byte
				// String
				// sql2="select * from gradestudent where Sname like '%"+num+"%'";
				if (num.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入查询条件", "错误！",
							JOptionPane.ERROR_MESSAGE);
				} else {
					StudentinfoModel sm2 = new StudentinfoModel(sql);
					jt1.setModel(sm2);

				}
			}
		 });
		pxbtn.addActionListener(new ActionListener() { // 排序 按总分高低 表
			public void actionPerformed(ActionEvent e) {
				String sql=" slect * from gradestudent ORDER BY TotalGrade DESC";
				GradeModel cm = new GradeModel(sql);
				jt1.setModel(cm);
			}
		});
		
		jt1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row1 = jt1.getSelectedColumn(); // 获取选中的列号（记录）

			}
		});
		
		jp1.add(jtf2);
		jp1.add(findbtn1);
		//jp1.add(pxbtn);
		/******* 下层界面 *******/
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		addbtn1 = new JButton("增加");
		updatebtn1 = new JButton("修改");

		updatebtn1.addActionListener(new ActionListener() { // 修改
					public void actionPerformed(ActionEvent e) {
						try {

							if (row1 != -1) {

								String sno1 = jt1.getValueAt(row1, 0)
										.toString();// 读取你获取行号的（1，0）的值
								String name1 = jt1.getValueAt(row1, 1)
										.toString();
								String sex1 = jt1.getValueAt(row1, 2)
										.toString();
								String dept1 = jt1.getValueAt(row1, 3)
										.toString();
								String major1 = jt1.getValueAt(row1, 4)
										.toString();
								String pwd1 = jt1.getValueAt(row1, 5)
										.toString();
								AddstuFrame2 frame2 = new AddstuFrame2(sno1,
										name1, sex1, dept1, major1, pwd1);
								frame2.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "请选择一行！",
										"错误！", JOptionPane.ERROR_MESSAGE);
							}

						} catch (Exception x) {
							x.printStackTrace();
						}

					}
				});
		debtn1 = new JButton("删除");
		debtn1.addActionListener(new ActionListener() { // 删除成绩
			public void actionPerformed(ActionEvent e) {
				try {
					if (row1 != -1) {
						sno = jt1.getValueAt(row1, 0).toString();// 读取你获取行号的（1，1）的值
						try {
							String sql = "delete from gradestudent where Sno='"
									+ sno + "'";
							Connection cn = Jdbc.getconnection();
							PreparedStatement ps = cn.prepareStatement(sql);
							ps.executeUpdate();
						} catch (Exception s) {
							s.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(null, "请选择一行！", "错误！",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception x) {
					x.printStackTrace();
				}

			}
		});
		gxbtn1 = new JButton("刷新");
		gxbtn1.addActionListener(new ActionListener() { // 刷新数据
			public void actionPerformed(ActionEvent e) {
				GradeModel sm1 = new GradeModel();
				jt1.setModel(sm1);
			}
		});

		jp2.add(addbtn1);
		jp2.add(updatebtn1);
		jp2.add(debtn1);
		jp2.add(gxbtn1);

		// 初始化JTable
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 单元格渲染器
		tcr.setHorizontalAlignment(JLabel.CENTER);// 居中显示
		jt1.setDefaultRenderer(Object.class, tcr);// 设置渲染器
		jsp = new JScrollPane(jt1);

		JPanel jp3 = new JPanel(new BorderLayout());
		jp3.add(jp1, BorderLayout.NORTH);
		jp3.add(jsp, BorderLayout.CENTER);
		jp3.add(jp2, BorderLayout.SOUTH);
		return jp3;
	}

	// ***********注册事件监听器***************
	public void Listener() {
		teainfobtn.setActionCommand("teainfobtn");
		teainfobtn.addActionListener(this);
		stuinfobtn.setActionCommand("stuinfobtn");
		stuinfobtn.addActionListener(this);
		gradebtn.setActionCommand("gradebtn");
		gradebtn.addActionListener(this);
		teainfoupbtn.setActionCommand("teainfoupbtn");
		teainfoupbtn.addActionListener(this);
		exitbtn.setActionCommand("exitbtn");
		exitbtn.addActionListener(this);
		upbtn.setActionCommand("upbtn"); // 老师信息修改按钮
		upbtn.addActionListener(this);

		addbtn.setActionCommand("addbtn"); // 增加学生按钮
		addbtn.addActionListener(this);
		addbtn1.setActionCommand("addbtn1"); // 增加成绩按钮
		addbtn1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("teainfobtn")) {
			card.show(cardpanel, "1");
		} else if (e.getActionCommand().equals("teainfoupbtn")) {
			card.show(cardpanel, "2");
		} else if (e.getActionCommand().equals("stuinfobtn")) {
			card.show(cardpanel, "3");
		} else if (e.getActionCommand().equals("gradebtn")) {
			card.show(cardpanel, "4");
		} else if (e.getActionCommand().equals("exitbtn")) {// 退出
			this.setVisible(false);
			EnterMainFrame frame1 = new EnterMainFrame();
			frame1.setVisible(true);
		} else if (e.getActionCommand().equals("upbtn")) {// 修改老师信息功能
			name = jtname.getText().trim();
			sex = jtsex.getText().trim();
			dept = jtdept.getText().trim();
			pwd = jtpwd.getText().trim();
			String message = "确定修改" + name + "的信息";
			int resOne = JOptionPane.showConfirmDialog(this, message, "修改信息",
					JOptionPane.OK_CANCEL_OPTION);
			System.out.println(JOptionPane.OK_CANCEL_OPTION);
			if (resOne == 0) {
				try {
					sql = "update infoteacher set Sname='" + name + "',Ssex='"
							+ sex + "',Sdept='" + dept + "',Password='" + pwd
							+ "' where ID='" + number + "'";
					Statement stmt = ct.createStatement();
					int num = stmt.executeUpdate(sql);
					this.dispose();
					if (num >= 1) {

						System.out.print("执行executeUpdate成功");
					} else {
						System.out.print("执行executeUpdate失败");
					}

				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		} else if (e.getActionCommand().equals("addbtn")) {// 增加学生信息功能
			AddteaFrame frame = new AddteaFrame();
			frame.setVisible(true);

		} else if (e.getActionCommand().equals("addbtn1")) {// 增加成绩功能
			AddstuFrame frame = new AddstuFrame();
			frame.setVisible(true);

		}
	}

	public TeacherMainFrame(String number, String name) {
		this.name = name;
		this.number = number;
		this.setTitle("您好！" + name + "老师");
		this.setSize(900, 600);
		this.setLayout(new BorderLayout());
		jp2 = new JPanel(new GridLayout(1, 3, 2, 1));
		// 卡片布局
		card = new CardLayout();
		cardpanel = new JPanel(card);
		cardpanel.add("1", teainfojp());
		cardpanel.add("2", teainfoupjp());
		cardpanel.add("3", stuinfojp());
		cardpanel.add("4", gradejp());
		teainfobtn = new JButton("个人信息");
		stuinfobtn = new JButton("学生信息");
		teainfoupbtn = new JButton("修改个人信息");
		gradebtn = new JButton("学生成绩");
		exitbtn = new JButton("退出");
		// stuinfoupbtn=new JButton("修改学生信息");
		// gradeupbtn=new JButton("修改学生成绩");
		jp2.add(teainfobtn);
		jp2.add(teainfoupbtn);
		jp2.add(stuinfobtn);
		jp2.add(gradebtn);
		jp2.add(exitbtn);
		Listener();
		this.add(jp2, BorderLayout.NORTH);
		this.add(cardpanel, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

/*
 * 
 * class ChangeFrame extends JFrame { private static final long serialVersionUID
 * = -1928970409928880648L;
 * 
 * JLabel jlnumber = new JLabel("学号："); JLabel jlname = new JLabel("姓名：");
 * JLabel jlsex = new JLabel("性别："); JLabel jldept = new JLabel("学院："); JLabel
 * jlmajor = new JLabel("专业：");
 * 
 * JTextField jtnumber = new JTextField("",20); JTextField jtname = new
 * JTextField("",20); JTextField jtsex = new JTextField("",20); JTextField
 * jtdept = new JTextField("",20); JTextField jtmajor = new JTextField("",20);
 * 
 * JButton buttonchange = new JButton("修改"); JButton buttonreturn = new
 * JButton("返回"); public ChangeFrame() { JPanel jpnumber = new JPanel(); JPanel
 * jpname = new JPanel(); JPanel jpsex = new JPanel(); JPanel jpdept = new
 * JPanel(); JPanel jpmajor = new JPanel(); JPanel jpforbutton = new JPanel(new
 * GridLayout(1,1)); jpnumber.add(jlnumber); jpnumber.add(jtnumber);
 * jpname.add(jlname); jpname.add(jtname); jpsex.add(jlsex); jpsex.add(jtsex);
 * 
 * jpdept.add(jldept); jpdept.add(jtdept);
 * 
 * 
 * jpmajor.add(jlmajor); jpmajor.add(jtmajor);
 * 
 * jpforbutton.add(buttonchange); jpforbutton.add(buttonreturn);
 * 
 * buttonchange.addActionListener(new ActionListener(){ public void
 * actionPerformed(ActionEvent e){ String number = jtnumber.getText(); String
 * name = jtname.getText(); String sex = jtsex.getText(); String dept =
 * jtdept.getText(); String major = jtmajor.getText();
 * 
 * Connection conn = null; ResultSet res = null; Statement stat = null;
 * 
 * String sql = "SELECT number,name,sex,birthday,department FROM student;"; try{
 * Class.forName("com.mysql.jdbc.Driver");
 * 
 * }catch(Exception d){ System.out.println("jdbc fall"); d.printStackTrace(); }
 * try{
 * conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaStu","root"
 * ,"123"); stat=conn.createStatement(); res=stat.executeQuery(sql); while
 * (res.next()) { //change if (res.getString(1).equals(jtnumber.getText())) {
 * try{ Class.forName("com.mysql.jdbc.Driver"); }catch(Exception d){
 * System.out.println("jdbc fall"); d.printStackTrace(); }
 * 
 * String
 * sql2="UPDATE student SET Sname='"+name+"'  WHERE number='"+jtnumber.getText
 * ()+"'"; String
 * sql3="UPDATE student SET Ssex='"+sex+"'  WHERE number='"+jtnumber
 * .getText()+"'"; String
 * sql4="UPDATE student SET Sdept='"+dept+"'  WHERE number='"
 * +jtnumber.getText()+"'"; String
 * sql5="UPDATE student SET Smajor='"+major+"'  WHERE number='"
 * +jtnumber.getText()+"'"; try {
 * conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaStu"
 * ,"root","123"); stat=conn.createStatement(); stat.executeUpdate(sql2);
 * stat.executeUpdate(sql3); stat.executeUpdate(sql4); stat.executeUpdate(sql5);
 * } catch (SQLException g) { // TODO Auto-generated catch block
 * g.printStackTrace(); }try{ stat.close(); conn.close(); }catch(SQLException
 * ar){ ar.printStackTrace(); }
 * 
 * break; }
 * 
 * //change end } }catch (SQLException e1) { // TODO Auto-generated catch block
 * e1.printStackTrace();
 * 
 * 
 * } finally{ try{ conn.close(); }catch(SQLException ar){ ar.printStackTrace();
 * }
 * 
 * }
 * 
 * }
 * 
 * 
 * });
 * 
 * 
 * buttonreturn.addActionListener(new ActionListener(){ public void
 * actionPerformed(ActionEvent e){ Window window = new Window(); } });
 * 
 * this.setTitle("修改学生信息"); this.setLayout(new GridLayout(9,1));
 * this.add(jpnumber); this.add(jpname); this.add(jpsex); this.add(jpmajor);
 * this.add(jpdept); this.add(jpforbutton); this.setLocation(400,300);
 * this.setSize(350,300); this.setVisible(true);
 * 
 * 
 * }
 * 
 * 
 * }
 */
