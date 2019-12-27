package system;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * 
 * @author TWF
 *  学生界面----学生查看 个人信息         修改各人信息   学生成绩  
 */
/********学生登陆 主界面************/
public class StudentMainFrame extends JFrame implements ActionListener{
	JLabel lbsno,lbname,lbsex,lbdept,lbmajor,lbpwd,lbGrade1,lbGrade2,lbGrade3,lbTotal;
	JTextField jtsno,jtname,jtsex,jtdept,jtmajor,jtpwd,jtGrade1,jtGrade2,jtGrade3,jtTotal;
	JPanel jp2,cardpanel,infojp,gradejp,updatejp; 
	JButton infobtn,updatebtn,gradebtn,exitbtn,upbtn;
	CardLayout card;
	//定义操作数据库参数
	String sql;
	Connection ct=null;
	PreparedStatement ps;
	ResultSet rs;
	String number=null;
	String name ,sex, dept, major, pwd,Grade1,Grade2,Grade3,TotalGrade;
	
	
	//查看个人信息界面
	
	public JPanel infojp(){
		try{
			sql="select * from infostudent where Sno='"+number+"' "; //带参数的sql语句
			ct=Jdbc.getconnection();
	    	ps=ct.prepareStatement(sql);//预编译  
      	    rs=ps.executeQuery(); //执行sql操作 处理 返回结果
			while(rs.next()){	
			//jtname.setText(rs.getString("Sname"));
			  //name=rs.getString("Sname");
			  sex=rs.getString("Ssex");
			  dept=rs.getString("Sdept");
			  major=rs.getString("Smajor");
			  pwd=rs.getString("Password");
			}
		}catch(Exception c){}
		
		lbsno=new JLabel("                      学  号:");jtsno=new JTextField(number);	
		lbname=new JLabel("                      姓  名:");jtname=new JTextField(name);
		lbsex=new JLabel("                      性  别:");jtsex=new JTextField(sex);
		lbdept=new JLabel("                      学  院:");jtdept=new JTextField(dept);
		lbmajor=new JLabel("                      专  业:");jtmajor=new JTextField(major);
		lbpwd=new JLabel("                    登录密码:");jtpwd=new JTextField(pwd);
		
		jtsno.setForeground(Color.red); //设置文本框字体颜色
		jtsex.setForeground(Color.red);
		jtname.setForeground(Color.red);
		jtmajor.setForeground(Color.red);
		jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		jtsno.setFont(new Font("Dialog",1,22));//设置文本框字体大小
		jtname.setFont(new Font("Dialog",1,22));
		jtsex.setFont(new Font("Dialog",1,22));
		jtdept.setFont(new Font("Dialog",1,22));
		jtmajor.setFont(new Font("Dialog",1,22));
		jtpwd.setFont(new Font("Dialog",1,22));
		lbsno.setFont(new Font("Dialog",1,22));//设置标签字体大小
		lbname.setFont(new Font("Dialog",1,22));
		lbsex.setFont(new Font("Dialog",1,22));
		lbdept.setFont(new Font("Dialog",1,22));
		lbmajor.setFont(new Font("Dialog",1,22));
		lbpwd.setFont(new Font("Dialog",1,22));
		jtsno.setEnabled(false);//设置文本框不可编辑
		jtname.setEnabled(false);
		jtsex.setEnabled(false);
		jtdept.setEnabled(false);
		jtmajor.setEnabled(false);
		jtpwd.setEnabled(false);
		infojp=new JPanel(new GridLayout(8,10,0,5));
		infojp.add(lbsno);infojp.add(jtsno);
		infojp.add(lbname);infojp.add(jtname);
	    infojp.add(lbsex);infojp.add(jtsex);
	    infojp.add(lbdept);infojp.add(jtdept);
		infojp.add(lbmajor);infojp.add(jtmajor);
		infojp.add(lbpwd);infojp.add(jtpwd);
	    return infojp;
	    }
	//查看个人成绩界面
	public JPanel gradejp(){
		try{
			sql="select * from gradestudent where Sno='"+number+"' "; //带参数的sql语句
			ct=Jdbc.getconnection();
	    	ps=ct.prepareStatement(sql);//预编译  
      	    rs=ps.executeQuery(); //执行sql操作 处理 返回结果
			while(rs.next()){	
			//jtname.setText(rs.getString("Sname"));
			 // name=rs.getString("Sname");
			  Grade1=rs.getString("Grade1");
			  Grade2=rs.getString("Grade2");
			  Grade3=rs.getString("Grade3");
			  TotalGrade=rs.getString("TotalGrade");
			}
		}catch(Exception e){}
		gradejp=new JPanel(new GridLayout(8,10,0,5));
		lbsno=new JLabel("                        学 号:");jtsno=new JTextField(number);
		lbname=new JLabel("                        姓 名:");jtname=new JTextField(name);
		lbGrade1=new JLabel("               JAVA成绩:");jtGrade1=new JTextField(Grade1);
		lbGrade2=new JLabel("              数据库成绩:");jtGrade2=new JTextField(Grade2);
		lbGrade3=new JLabel("                英语成绩 :");jtGrade3=new JTextField(Grade3);
		lbTotal=new JLabel("                        总 分:");jtTotal=new JTextField(TotalGrade);	
		//设置文本框字体颜色 
		jtsno.setForeground(Color.red); jtname.setForeground(Color.red);
		jtGrade1.setForeground(Color.red);jtGrade2.setForeground(Color.red);
		jtGrade3.setForeground(Color.red);jtTotal.setForeground(Color.red);
		//设置文本框字体大小
		jtsno.setFont(new Font("Dialog",1,22));jtname.setFont(new Font("Dialog",1,22));
		jtGrade1.setFont(new Font("Dialog",1,22));jtGrade2.setFont(new Font("Dialog",1,22));
		jtGrade3.setFont(new Font("Dialog",1,22));jtTotal.setFont(new Font("Dialog",1,22));
		//设置标签字体大小
		lbsno.setFont(new Font("Dialog",1,22));lbname.setFont(new Font("Dialog",1,22));
		lbGrade1.setFont(new Font("Dialog",1,22));lbGrade2.setFont(new Font("Dialog",1,22));
		lbGrade3.setFont(new Font("Dialog",1,22));lbTotal.setFont(new Font("Dialog",1,22));
		//设置文本框不可编辑
		jtsno.setEnabled(false);jtname.setEnabled(false);
		jtGrade1.setEnabled(false);jtGrade2.setEnabled(false);
		jtGrade3.setEnabled(false);jtTotal.setEnabled(false);
		//添加组件到 grade面板
		gradejp.add(lbsno);gradejp.add(jtsno);
		gradejp.add(lbname);gradejp.add(jtname);
		gradejp.add(lbGrade1);gradejp.add(jtGrade1);
		gradejp.add(lbGrade2);gradejp.add(jtGrade2);
		gradejp.add(lbGrade3);gradejp.add(jtGrade3);
		gradejp.add(lbTotal);gradejp.add(jtTotal);
	    return gradejp;
	    }
	
	//修改个人信息界面 
	public JPanel updatejp(){
		    JPanel jp1=new JPanel(new BorderLayout());
		    JPanel jp2=new JPanel();
		  
		    try{
				sql="select * from infostudent where Sno='"+number+"' "; //带参数的sql语句
				ct=Jdbc.getconnection();
    	    	ps=ct.prepareStatement(sql);//预编译  
	      	    rs=ps.executeQuery(); //执行sql操作 处理 返回结果
				while(rs.next()){	
				//jtname.setText(rs.getString("Sname"));
				  //name=rs.getString("Sname");
				  sex=rs.getString("Ssex");
				  dept=rs.getString("Sdept");
				  major=rs.getString("Smajor");
				  pwd=rs.getString("Password");
				}
			}catch(Exception c){}
		    updatejp=new JPanel(new GridLayout(7,10,0,5));
		    upbtn=new JButton("修改");
			upbtn.setActionCommand("upbtn");
			upbtn.addActionListener(this);
			lbsno=new JLabel("                      学  号:");jtsno=new JTextField(number,10);	
			lbname=new JLabel("                      姓  名:");jtname=new JTextField(name,10);
			lbsex=new JLabel("                      性  别:");jtsex=new JTextField(sex,10);
			lbdept=new JLabel("                      学  院:");jtdept=new JTextField(dept,10);
			lbmajor=new JLabel("                      专  业:");jtmajor=new JTextField(major,10);
			lbpwd=new JLabel("    	            登录密码:");jtpwd=new JTextField(pwd,10);
		
			//设置文本框字体颜色
	        jtsex.setForeground(Color.red);jtmajor.setForeground(Color.red);
			jtname.setForeground(Color.red);jtdept.setForeground(Color.red);
			jtpwd.setForeground(Color.red);
			//设置文本框字体大小
			jtname.setFont(new Font("Dialog",0,22));jtsex.setFont(new Font("Dialog",0,22));
			jtdept.setFont(new Font("Dialog",0,22));jtmajor.setFont(new Font("Dialog",0,22));
			jtpwd.setFont(new Font("Dialog",0,22));jtsno.setFont(new Font("Dialog",0,22));
			//设置标签字体大小
			lbsno.setFont(new Font("Dialog",1,22));lbname.setFont(new Font("Dialog",1,22));
			lbsex.setFont(new Font("Dialog",1,22));lbdept.setFont(new Font("Dialog",1,22));
			lbmajor.setFont(new Font("Dialog",1,22));lbpwd.setFont(new Font("Dialog",1,22));
			jtsno.setEnabled(false);//设置文本框不可编辑
			//添加组件到面板
			
			updatejp.add(lbsno);updatejp.add(jtsno);
			updatejp.add(lbname);updatejp.add(jtname);
			updatejp.add(lbsex);updatejp.add(jtsex);
			updatejp.add(lbdept);updatejp.add(jtdept);
			updatejp.add(lbmajor);updatejp.add(jtmajor);
			updatejp.add(lbpwd);updatejp.add(jtpwd);
			jp2.add(upbtn);
			jp1.add(updatejp,BorderLayout.CENTER);
			jp1.add(jp2,BorderLayout.SOUTH);
			
		    return jp1;
		    }
	public StudentMainFrame(String number,String name){
		this.name=name;
		this.number = number;
		this.setTitle("您好！"+name+"同学");
		this.setSize(800,600);
		this.setLayout(new BorderLayout());
		jp2=new JPanel(new GridLayout(1,3,2,1));
		//卡片布局
		card=new CardLayout();
		cardpanel=new JPanel(card);
		cardpanel.add("1",infojp());
		cardpanel.add("2",gradejp());
		cardpanel.add("3",updatejp());
		infobtn=new JButton("查看个人信息");
		gradebtn=new JButton("查看个人成绩");
		updatebtn=new JButton("修改个人信息");
		exitbtn=new JButton("退出");
		
		jp2.add(infobtn);
		jp2.add(gradebtn);
		jp2.add(updatebtn);
		jp2.add(exitbtn);
		Listener();
		this.add(jp2,BorderLayout.NORTH);
		this.add(cardpanel,BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
//***********注册事件监听器***************
	public void Listener(){
		infobtn.setActionCommand("infobtn"); 
		infobtn.addActionListener(this);
		gradebtn.setActionCommand("gradebtn"); 
		gradebtn.addActionListener(this);
		updatebtn.setActionCommand("updatebtn"); 
		updatebtn.addActionListener(this);
		exitbtn.setActionCommand("exitbtn"); 
		exitbtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) { 
		
		if(e.getActionCommand().equals("infobtn")){
			card.show(cardpanel,"1");
		}else if(e.getActionCommand().equals("gradebtn")){   
			card.show(cardpanel,"2");
		}else if(e.getActionCommand().equals("updatebtn")){
			card.show(cardpanel,"3");
		}else if(e.getActionCommand().equals("upbtn")){
		    String message="确定修改"+number+name+"的信息";
			int resOne=JOptionPane.showConfirmDialog(this,message,"修改信息",JOptionPane.OK_CANCEL_OPTION);
			//System.out.println(JOptionPane.OK_CANCEL_OPTION);
			if(resOne==0){
				String n=jtname.getText().trim();
				String s=jtsex.getText().trim();
				String d=jtdept.getText().trim();
				String m=jtmajor.getText().trim();
				String p=jtpwd.getText().trim();
				try{
					sql="update infostudent set Sname='"+n+"',Ssex='"+s+"',Sdept='"+d+"',Smajor='"+m+"',Password='"+p+"' where Sno='"+number+"'";
					Statement stmt=ct.createStatement();
                    Jdbc.update(sql);
				}catch(Exception x){
					x.printStackTrace();
				}
			}
		}else if(e.getActionCommand().equals("exitbtn")){
			this.setVisible(false);
			EnterMainFrame frame = new EnterMainFrame();
			frame.setVisible(true);
			
		}
		
	}

}
