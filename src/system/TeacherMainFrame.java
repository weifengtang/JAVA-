package system;
// ��ʦ����������
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
	// ����������ݿ����
	static String JDriver = "com.mysql.jdbc.Driver";// SQL���ݿ�����
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
			Class.forName(JDriver); // ���ݿ�
			con = DriverManager.getConnection(URl, userName, userPwd);
		} catch (Exception e) {
		}
		return con;
	}

	// �鿴��ʦ������Ϣ����

	public JPanel teainfojp() {
		try {
			sql = "select * from infoteacher where ID='" + number + "' "; // ��������sql���
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
		lbsno = new JLabel("                      ��  ��:");
		jtsno = new JTextField(number);
		lbname = new JLabel("                      ��  ��:");
		jtname = new JTextField(name);
		lbsex = new JLabel("                      ��  ��:");
		jtsex = new JTextField(sex);
		lbdept = new JLabel("                      ѧ  Ժ:");
		jtdept = new JTextField(dept);
		lbpwd = new JLabel("                    ��¼����:");
		jtpwd = new JTextField(pwd);
		// �����ı���������ɫ
		jtsno.setForeground(Color.YELLOW);
		jtsex.setForeground(Color.red);
		jtname.setForeground(Color.red);
		jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		jtsno.setBackground(Color.gray);
		// �����ı��������С
		jtsno.setFont(new Font("Dialog", 1, 22));
		jtname.setFont(new Font("Dialog", 1, 22));
		jtsex.setFont(new Font("Dialog", 1, 22));
		jtdept.setFont(new Font("Dialog", 1, 22));
		jtpwd.setFont(new Font("Dialog", 1, 22));
		// ���ñ�ǩ�����С
		lbsno.setFont(new Font("Dialog", 1, 22));
		lbname.setFont(new Font("Dialog", 1, 22));
		lbsex.setFont(new Font("Dialog", 1, 22));
		lbdept.setFont(new Font("Dialog", 1, 22));
		lbpwd.setFont(new Font("Dialog", 1, 22));
		// �����ı��򲻿ɱ༭
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

	// �޸���ʦ������Ϣ
	public JPanel teainfoupjp() {
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel();
		teainfoupjp = new JPanel(new GridLayout(7, 10, 0, 5));
		try {
			sql = "select * from infoteacher where ID='" + number + "' "; // ��������sql���
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
		upbtn = new JButton("�޸�");

		lbsno = new JLabel("                      ��  ��:");
		jtsno = new JTextField(number);
		lbname = new JLabel("                      ��  ��:");
		jtname = new JTextField(name);
		lbsex = new JLabel("                      ��  ��:");
		jtsex = new JTextField(sex);
		lbdept = new JLabel("                      ѧ  Ժ:");
		jtdept = new JTextField(dept);
		lbpwd = new JLabel("                    ��¼����:");
		jtpwd = new JTextField(pwd);

		// �����ı���������ɫ
		jtsno.setForeground(Color.red);
		jtsex.setForeground(Color.red);
		jtname.setForeground(Color.red);
		jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		// �����ı��������С
		jtname.setFont(new Font("Dialog", 0, 22));
		jtsex.setFont(new Font("Dialog", 0, 22));
		jtdept.setFont(new Font("Dialog", 0, 22));
		jtpwd.setFont(new Font("Dialog", 0, 22));
		jtsno.setFont(new Font("Dialog", 0, 22));
		// ���ñ�ǩ�����С
		lbsno.setFont(new Font("Dialog", 1, 22));
		lbname.setFont(new Font("Dialog", 1, 22));
		lbsex.setFont(new Font("Dialog", 1, 22));
		lbdept.setFont(new Font("Dialog", 1, 22));
		lbpwd.setFont(new Font("Dialog", 1, 22));
		jtsno.setEnabled(false);// �����ı��򲻿ɱ༭
		// �����������
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

	// ѧ����Ϣ����
	public JPanel stuinfojp() {

		/******* �ϲ���� *******/
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		jtf = new JTextField(30);
		findbtn = new JButton("��ѯ");
		
		jp1.add(jtf);
		jp1.add(findbtn);
		
		/******* �²���� *******/
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		addbtn = new JButton("����");
		updatebtn = new JButton("�޸�");
		debtn = new JButton("ɾ��");
		gxbtn = new JButton("ˢ��");
		gxbtn.addActionListener(new ActionListener() { // ˢ�±�
			public void actionPerformed(ActionEvent e) {
				sm = new StudentinfoModel();
				jt.setModel(sm);
			}
		});
		jp2.add(addbtn);
		jp2.add(updatebtn);
		jp2.add(debtn);
		jp2.add(gxbtn);
		sm = new StudentinfoModel(); // ʵ����һ������ģ�Ͷ���
		jt = new JTable(sm); // ��ʼ��JTable
		jt.setRowHeight(25);
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = jt.getSelectedColumn(); // ��ȡѡ�е��кţ���¼��
				System.out.println(row);
			}
		});
		// jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// //����JTable�Զ������б��״̬���˴�����Ϊ�ر�
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// ��Ԫ����Ⱦ��
		tcr.setHorizontalAlignment(JLabel.CENTER);// ������ʾ
		jt.setDefaultRenderer(Object.class, tcr);// ������Ⱦ��
		jsp = new JScrollPane(jt);
		updatebtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = jt.getSelectedColumn(); // ��ȡѡ�е��кţ���¼��
				System.out.println(row);

			}
		});
		updatebtn.addActionListener(new ActionListener() { // �޸�
					public void actionPerformed(ActionEvent e) {
						try {
							if (row != -1) {
								String sno1 = jt.getValueAt(row, 0).toString();// ��ȡ���ȡ�кŵģ�1��0����ֵ
								String name1 = jt.getValueAt(row, 1).toString();
								String sex1 = jt.getValueAt(row, 2).toString();
								String dept1 = jt.getValueAt(row, 3).toString();
								String major1 = jt.getValueAt(row, 4).toString();
								String pwd1 = jt.getValueAt(row, 5).toString();
								AddteaFrame2 frame2 = new AddteaFrame2(sno1,name1, sex1, dept1, major1, pwd1);
								frame2.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "��ѡ��һ�У�",
										"����", JOptionPane.ERROR_MESSAGE);
							}

						} catch (Exception x) {
							x.printStackTrace();
						}

					}
				});

		findbtn.addActionListener(new ActionListener() { // ģ����ѯ ѧ��

			public void actionPerformed(ActionEvent e) {
				String num = jtf.getText().trim();
				String sql = "select *from infostudent where binary Sno like '%"
						+ num + "%'"; // binary ת�����ַ�������ʱ��������8Byte
				// String
				// sql2="select * from infostudent where Sname like '%"+num+"%'";
				if (num.equals("")) {
					JOptionPane.showMessageDialog(null, "�������ѯ����", "����",
							JOptionPane.ERROR_MESSAGE);
				} else {
					StudentinfoModel sm2 = new StudentinfoModel(sql);
					jt.setModel(sm2);

				}

			}
		});

		debtn.addActionListener(new ActionListener() { // ɾ��
			public void actionPerformed(ActionEvent e) {
				try {
					if (row != -1) {
						sno = jt.getValueAt(row, 0).toString();// ��ȡ���ȡ�кŵģ�1��1����ֵ
						try {
							String sql = "delete from infostudent where Sno='"
									+ sno + "'";
							Connection cn = Jdbc.getconnection();
							PreparedStatement ps = cn.prepareStatement(sql);
							ps.executeUpdate();
							System.out.println("����ɾ���ɹ�");
						} catch (Exception s) {
							s.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(null, "��ѡ��һ�У�", "����",
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

	// ѧ���ɼ�����
	public JPanel gradejp() {

		// ʵ����һ������ģ�Ͷ���
		sm1 = new GradeModel();
		jt1 = new JTable(sm1);
		jt1.setRowHeight(25);
		

		/******* �ϲ���� *******/
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		JTextField jtf2 = new JTextField(30);
		findbtn1 = new JButton("��ѯ");
		pxbtn = new JButton("����");
		findbtn1.addActionListener(new ActionListener() { // ģ����ѯ ѧ��
			public void actionPerformed(ActionEvent e) {
				String num = jtf2.getText().trim();
				String sql = "select *from gradestudent where binary Sno like '%"
						+ num + "%'"; // binary ת�����ַ�������ʱ��������8Byte
				// String
				// sql2="select * from gradestudent where Sname like '%"+num+"%'";
				if (num.equals("")) {
					JOptionPane.showMessageDialog(null, "�������ѯ����", "����",
							JOptionPane.ERROR_MESSAGE);
				} else {
					StudentinfoModel sm2 = new StudentinfoModel(sql);
					jt1.setModel(sm2);

				}
			}
		 });
		pxbtn.addActionListener(new ActionListener() { // ���� ���ָܷߵ� ��
			public void actionPerformed(ActionEvent e) {
				String sql=" slect * from gradestudent ORDER BY TotalGrade DESC";
				GradeModel cm = new GradeModel(sql);
				jt1.setModel(cm);
			}
		});
		
		jt1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row1 = jt1.getSelectedColumn(); // ��ȡѡ�е��кţ���¼��

			}
		});
		
		jp1.add(jtf2);
		jp1.add(findbtn1);
		//jp1.add(pxbtn);
		/******* �²���� *******/
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		addbtn1 = new JButton("����");
		updatebtn1 = new JButton("�޸�");

		updatebtn1.addActionListener(new ActionListener() { // �޸�
					public void actionPerformed(ActionEvent e) {
						try {

							if (row1 != -1) {

								String sno1 = jt1.getValueAt(row1, 0)
										.toString();// ��ȡ���ȡ�кŵģ�1��0����ֵ
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
								JOptionPane.showMessageDialog(null, "��ѡ��һ�У�",
										"����", JOptionPane.ERROR_MESSAGE);
							}

						} catch (Exception x) {
							x.printStackTrace();
						}

					}
				});
		debtn1 = new JButton("ɾ��");
		debtn1.addActionListener(new ActionListener() { // ɾ���ɼ�
			public void actionPerformed(ActionEvent e) {
				try {
					if (row1 != -1) {
						sno = jt1.getValueAt(row1, 0).toString();// ��ȡ���ȡ�кŵģ�1��1����ֵ
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
						JOptionPane.showMessageDialog(null, "��ѡ��һ�У�", "����",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception x) {
					x.printStackTrace();
				}

			}
		});
		gxbtn1 = new JButton("ˢ��");
		gxbtn1.addActionListener(new ActionListener() { // ˢ������
			public void actionPerformed(ActionEvent e) {
				GradeModel sm1 = new GradeModel();
				jt1.setModel(sm1);
			}
		});

		jp2.add(addbtn1);
		jp2.add(updatebtn1);
		jp2.add(debtn1);
		jp2.add(gxbtn1);

		// ��ʼ��JTable
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// ��Ԫ����Ⱦ��
		tcr.setHorizontalAlignment(JLabel.CENTER);// ������ʾ
		jt1.setDefaultRenderer(Object.class, tcr);// ������Ⱦ��
		jsp = new JScrollPane(jt1);

		JPanel jp3 = new JPanel(new BorderLayout());
		jp3.add(jp1, BorderLayout.NORTH);
		jp3.add(jsp, BorderLayout.CENTER);
		jp3.add(jp2, BorderLayout.SOUTH);
		return jp3;
	}

	// ***********ע���¼�������***************
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
		upbtn.setActionCommand("upbtn"); // ��ʦ��Ϣ�޸İ�ť
		upbtn.addActionListener(this);

		addbtn.setActionCommand("addbtn"); // ����ѧ����ť
		addbtn.addActionListener(this);
		addbtn1.setActionCommand("addbtn1"); // ���ӳɼ���ť
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
		} else if (e.getActionCommand().equals("exitbtn")) {// �˳�
			this.setVisible(false);
			EnterMainFrame frame1 = new EnterMainFrame();
			frame1.setVisible(true);
		} else if (e.getActionCommand().equals("upbtn")) {// �޸���ʦ��Ϣ����
			name = jtname.getText().trim();
			sex = jtsex.getText().trim();
			dept = jtdept.getText().trim();
			pwd = jtpwd.getText().trim();
			String message = "ȷ���޸�" + name + "����Ϣ";
			int resOne = JOptionPane.showConfirmDialog(this, message, "�޸���Ϣ",
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

						System.out.print("ִ��executeUpdate�ɹ�");
					} else {
						System.out.print("ִ��executeUpdateʧ��");
					}

				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		} else if (e.getActionCommand().equals("addbtn")) {// ����ѧ����Ϣ����
			AddteaFrame frame = new AddteaFrame();
			frame.setVisible(true);

		} else if (e.getActionCommand().equals("addbtn1")) {// ���ӳɼ�����
			AddstuFrame frame = new AddstuFrame();
			frame.setVisible(true);

		}
	}

	public TeacherMainFrame(String number, String name) {
		this.name = name;
		this.number = number;
		this.setTitle("���ã�" + name + "��ʦ");
		this.setSize(900, 600);
		this.setLayout(new BorderLayout());
		jp2 = new JPanel(new GridLayout(1, 3, 2, 1));
		// ��Ƭ����
		card = new CardLayout();
		cardpanel = new JPanel(card);
		cardpanel.add("1", teainfojp());
		cardpanel.add("2", teainfoupjp());
		cardpanel.add("3", stuinfojp());
		cardpanel.add("4", gradejp());
		teainfobtn = new JButton("������Ϣ");
		stuinfobtn = new JButton("ѧ����Ϣ");
		teainfoupbtn = new JButton("�޸ĸ�����Ϣ");
		gradebtn = new JButton("ѧ���ɼ�");
		exitbtn = new JButton("�˳�");
		// stuinfoupbtn=new JButton("�޸�ѧ����Ϣ");
		// gradeupbtn=new JButton("�޸�ѧ���ɼ�");
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
 * JLabel jlnumber = new JLabel("ѧ�ţ�"); JLabel jlname = new JLabel("������");
 * JLabel jlsex = new JLabel("�Ա�"); JLabel jldept = new JLabel("ѧԺ��"); JLabel
 * jlmajor = new JLabel("רҵ��");
 * 
 * JTextField jtnumber = new JTextField("",20); JTextField jtname = new
 * JTextField("",20); JTextField jtsex = new JTextField("",20); JTextField
 * jtdept = new JTextField("",20); JTextField jtmajor = new JTextField("",20);
 * 
 * JButton buttonchange = new JButton("�޸�"); JButton buttonreturn = new
 * JButton("����"); public ChangeFrame() { JPanel jpnumber = new JPanel(); JPanel
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
 * this.setTitle("�޸�ѧ����Ϣ"); this.setLayout(new GridLayout(9,1));
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
