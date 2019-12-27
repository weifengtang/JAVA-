package system;
/***
 * @author TWF
 * 学生信息管理系统
 *  登陆主界面
 */
import java.awt.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EnterMainFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JLabel ulb, plb;
	private JTextField uTxt;
	private JPasswordField pTxt;
	private JButton enterbtn, zcbtn;
	private JRadioButton teacherbtn, studentbtn;// 复选按钮
	String sql;
	String U, N;// 数据库的账号

	public EnterMainFrame() {
		this.setTitle("学生管理系统");
		// this.setSize(350,280);
		this.setSize(400, 350);
		// this.setIconImage(image);
		getContentPane().setLayout(null);
		// 初始化组件
		//ImageIcon image = new ImageIcon("Imagelcon/bb.png");
		//JLabel j4 = new JLabel(image);
		enterbtn = new JButton("登录");
		zcbtn = new JButton("注册");
		enterbtn.setFont(new Font("Dialog", 0, 15));
		zcbtn.setFont(new Font("Dialog", 0, 15));
		ulb = new JLabel("账号：");
		plb = new JLabel("密码：");
		ulb.setFont(new Font("Dialog", 1, 22));
		plb.setFont(new Font("Dialog", 1, 22));
		ulb.setBackground(Color.BLACK);
		uTxt = new JTextField();
		uTxt.setColumns(10);
		pTxt = new JPasswordField();
		pTxt.setColumns(10);
		teacherbtn = new JRadioButton("教师");
		studentbtn = new JRadioButton("学生");
		teacherbtn.setFont(new Font("Dialog", 0, 22));
		studentbtn.setFont(new Font("Dialog", 0, 22));
		// 创建一个选项组，让两个单选按钮放在同一组中
		ButtonGroup bg = new ButtonGroup();
		bg.add(teacherbtn);
		bg.add(studentbtn);
		
		ulb.setBounds(50, 100, 100, 30);
		plb.setBounds(50, 150, 100, 30);
		uTxt.setBounds(110, 100, 240, 35);
		pTxt.setBounds(110, 150, 240, 35);
		enterbtn.setBounds(120, 250, 80, 30);
		zcbtn.setBounds(230, 250, 80, 30);
		teacherbtn.setBounds(140, 200, 80, 30);
		studentbtn.setBounds(240, 200, 80, 30);
		
		this.add(ulb);
		this.add(uTxt);
		this.add(plb);
		this.add(pTxt);
		this.add(teacherbtn);
		this.add(studentbtn);
		this.add(enterbtn);
		this.add(zcbtn);

		Listener();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// ***********注册事件监听器***************
	public void Listener() {
		enterbtn.setActionCommand("enterbtn");
		enterbtn.addActionListener(this);
		zcbtn.setActionCommand("zcbtn");
		zcbtn.addActionListener(this);
	}

	/*********** 登入事件处理 ***************/
	public void actionPerformed(ActionEvent e) {
		String txtUser = uTxt.getText().trim();
		String txtPwd = new String(pTxt.getPassword());
		String User, Pwd, name;
		int flag = 0;
		// **********点击 enterbtn and studentbtn******
		if (e.getActionCommand().equals("enterbtn") && studentbtn.isSelected()) {

			try {
				sql = "select Sno,Password,Sname from infostudent";
				Connection con = Jdbc.getconnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					User = rs.getString("Sno");
					Pwd = rs.getString("Password");
					name = rs.getString("Sname");
					if (User.equals(txtUser) && Pwd.equals(txtPwd)) {
						this.U = User;
						this.N = name;
						flag = 1;
					}
				}
			} catch (Exception x) {
			}
			if (txtUser.equals("") | txtPwd.equals("")) {
				uTxt.setText("");
				pTxt.setText("");
				JOptionPane.showMessageDialog(null, "账号或密码不能为空！", "错误！",
						JOptionPane.ERROR_MESSAGE);
			} else if (flag == 1) {
				this.setVisible(false); // 隐藏登陆窗口
				StudentMainFrame stuframe = new StudentMainFrame(U, N);
				stuframe.setVisible(true);
				// JOptionPane.showMessageDialog(null,"登入成功","",JOptionPane.ERROR_MESSAGE);
				// frame.setVisible(true);
			} else {
				uTxt.setText("");
				pTxt.setText("");
				JOptionPane.showMessageDialog(null, "账号或密码错误！", "错误！",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		// **********点击 enterbtn and teacherbtn******
		if (e.getActionCommand().equals("enterbtn") && teacherbtn.isSelected()) {

			try {
				sql = "select ID,Password,Sname from infoteacher";
				Connection con = Jdbc.getconnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					User = rs.getString("ID");
					Pwd = rs.getString("Password");
					name = rs.getString("Sname");
					if (txtUser.equals(User) && txtPwd.equals(Pwd)) {
						this.U = User;
						this.N = name;
						flag = 1;
					}
				}
			} catch (Exception x) {
			}
			if (txtUser.equals("") | txtPwd.equals("")) {
				uTxt.setText("");
				pTxt.setText("");
				JOptionPane.showMessageDialog(null, "账号或密码不能为空！", "错误！",
						JOptionPane.ERROR_MESSAGE);
			} else if (flag == 1) {
				this.setVisible(false); // 隐藏登陆窗口
				TeacherMainFrame tea = new TeacherMainFrame(U, N);
				tea.setVisible(true);
			} else {
				uTxt.setText("");
				pTxt.setText("");
				JOptionPane.showMessageDialog(null, "账号或密码错误！", "错误！",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getActionCommand().equals("zcbtn")) {
			this.setVisible(false);
			ZcFrame z = new ZcFrame();
			z.setVisible(true);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterMainFrame frame = new EnterMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

// ***********注册界面***************
class ZcFrame extends JFrame implements ActionListener {
	JLabel lbsno, lbpwd, lbpwd1;
	JTextField jtsno, jtpwd, jtpwd1;
	JButton btn, btn1, btn2;
	JPanel infojp;
	String sql;

	ZcFrame() {
		this.setTitle("注册账户");
		this.setSize(500, 400);
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel();
		lbsno = new JLabel("                  账    号:");
		jtsno = new JTextField(15);
		lbpwd = new JLabel("               登陆密码:");
		jtpwd = new JTextField(15);
		lbpwd1 = new JLabel("        确定登陆密码:");
		jtpwd1 = new JTextField(15);
		jtsno.setForeground(Color.red); // 设置文本框字体颜色
		jtpwd.setForeground(Color.red);
		jtpwd1.setForeground(Color.red);
		jtsno.setFont(new Font("Dialog", 1, 22));// 设置文本框字体大小
		jtpwd.setFont(new Font("Dialog", 1, 22));
		jtpwd1.setFont(new Font("Dialog", 1, 22));
		lbsno.setFont(new Font("Dialog", 1, 22));// 设置标签字体大小
		lbpwd.setFont(new Font("Dialog", 1, 22));
		lbpwd1.setFont(new Font("Dialog", 1, 22));
		infojp = new JPanel(new GridLayout(4, 4, 0, 5));
		infojp.add(lbsno);
		infojp.add(jtsno);
		infojp.add(lbpwd);
		infojp.add(jtpwd);
		infojp.add(lbpwd1);
		infojp.add(jtpwd1);
		btn = new JButton("学生注册");
		btn2 = new JButton("教师注册");
		btn1 = new JButton("重新登录");
		btn.setActionCommand("btn");
		btn.addActionListener(this);
		btn1.setActionCommand("btn1");
		btn1.addActionListener(this);
		btn2.setActionCommand("btn2");
		btn2.addActionListener(this);

		jp2.add(btn);
		jp2.add(btn2);
		jp2.add(btn1);
		jp1.add(infojp, BorderLayout.CENTER);
		jp1.add(jp2, BorderLayout.SOUTH);
		this.add(jp1);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		String sno = jtsno.getText().trim();
		String p = jtpwd.getText().trim();
		String p1 = jtpwd1.getText().trim();
		if (e.getActionCommand().equals("btn1")) { // 重新登入
			this.dispose();
			EnterMainFrame enter = new EnterMainFrame();
			enter.setVisible(true);
			return;
		}
		if(sno.equals("")||p.equals("")||p1.equals("")){
			JOptionPane.showMessageDialog(null, "请输入账号或密码！", "错误！",JOptionPane.ERROR_MESSAGE);
		}else  if (p.equals(p1)&&e.getActionCommand().equals("btn")) {
			int resOne = JOptionPane.showConfirmDialog(new ZcFrame(),
						"确定增加", "账号", JOptionPane.OK_CANCEL_OPTION);
				if (resOne == 0) {
					try {
						String sql = "INSERT INTO infostudent(Sno,Password)values('"
								+ sno + "','" + p + "')";
						Jdbc.insert(sql);
						this.dispose();
						EnterMainFrame enter = new EnterMainFrame();
						enter.setVisible(true);
					} catch (Exception x) {
						x.printStackTrace();
					 }
				  }	
		}else if(p.equals(p1)&&e.getActionCommand().equals("btn2")){
			int resOne = JOptionPane.showConfirmDialog(new ZcFrame(),
					"确定增加", "账号", JOptionPane.OK_CANCEL_OPTION);
		    if (resOne == 0) {
				try {
					String sql = "INSERT INTO infoteacher(ID,Password)values('"+ sno + "','" + p + "')";
					Jdbc.insert(sql);
					this.dispose();
					EnterMainFrame enter = new EnterMainFrame();
					enter.setVisible(true);
				 }catch (Exception x) {
					x.printStackTrace();
				}
			 }
		}else {
			JOptionPane.showMessageDialog(null, "请正确输入账号或密码！", "错误！",JOptionPane.ERROR_MESSAGE);
		}
		 
	}	
}
