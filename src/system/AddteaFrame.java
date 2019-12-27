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
class AddteaFrame extends JFrame implements ActionListener {
	JLabel lbsno,lbpwd,lbpwd1,lbname;
	JTextField jtname,jtsex,jtdept,jtmajor,jtsno,jtpwd,jtpwd1;
	String sql;
	StudentinfoModel sm;
	/*增加学生信息界面*/
	public AddteaFrame(){
		this.setTitle("学生信息");
		this.setSize(500, 400);
		JPanel jp1=new JPanel(new BorderLayout());
	    JPanel jp2=new JPanel();
	    JPanel jp = new JPanel(new GridLayout(7,10,0,5));
	    JButton btn = new JButton("确定");
		lbsno=new JLabel("                      学  号:");jtsno=new JTextField(10);	
		lbname = new JLabel("                      姓  名:"); jtname = new JTextField(10);
		JLabel lbsex = new JLabel("                      性  别:");jtsex = new JTextField(10);
		JLabel lbdept = new JLabel("                      学  院:");jtdept = new JTextField(10);
		JLabel lbmajor = new JLabel("                      专  业:");jtmajor = new JTextField(10);
		lbpwd=new JLabel("    	            登录密码:");jtpwd=new JTextField(10);
	
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
		//添加组件到面板
		
	    jp.add(lbsno);jp.add(jtsno);
		jp.add(lbname);jp.add(jtname);
		jp.add(lbsex);jp.add(jtsex);
		jp.add(lbdept);jp.add(jtdept);
		jp.add(lbmajor);jp.add(jtmajor);
		jp.add(lbpwd);jp.add(jtpwd);
		jp2.add(btn);
		jp1.add(jp,BorderLayout.CENTER);
		jp1.add(jp2,BorderLayout.SOUTH);
	    btn.addActionListener(this);
	    btn.setActionCommand("btn");
		jp2.add(btn);
		jp1.add(jp,BorderLayout.CENTER);
		jp1.add(jp2,BorderLayout.SOUTH);
		
		this.add(jp1);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	 public void actionPerformed(ActionEvent e){
		 if(e.getActionCommand().equals("btn")){
			int resOne=JOptionPane.showConfirmDialog(this,"确定增加","账号",JOptionPane.OK_CANCEL_OPTION);
			if(resOne==0){
				String sno=jtsno.getText().trim();
				String n=jtname.getText().trim();
				String s=jtsex.getText().trim();
				String d=jtdept.getText().trim();
				String m=jtmajor.getText().trim();
				String p=jtpwd.getText().trim();
				try{
				    String sql="INSERT INTO infostudent(Sno,Sname,Ssex,Sdept,Smajor,Password)values('"+sno+"','"+n+"','"+s+"','"+d+"','"+m+"','"+p+"')"; 
					Jdbc.insert(sql);
				    this.dispose();   	    
				  }catch(Exception x){x.printStackTrace();}   
			}
		 }
			
 	 }
}

class AddteaFrame2 extends JFrame  implements ActionListener  {
	JLabel lbsno,lbpwd,lbpwd1,lbname;
	JTextField jtname,jtsex,jtdept,jtmajor,jtsno,jtpwd,jtpwd1;
	String sql;
	StudentinfoModel sm;
	String sno,name ,sex, dept, major, pwd;//Grade1,Grade2,Grade3,TotalGrade;
	/*修改学生信息界面*/
	public AddteaFrame2(String sno,String name,String sex,String dept,String major,String  pwd){
		this.sno=sno;
		this.name=name;
		this.sex=sex;
		this.dept=dept;
		this.major=major;
		this.pwd=pwd;
		
		this.setTitle("学生信息");
		this.setSize(500, 400);
		JPanel jp1=new JPanel(new BorderLayout());
	    JPanel jp2=new JPanel();
	    JPanel jp = new JPanel(new GridLayout(7,10,0,5));
	    JButton btn = new JButton("确定");
	    btn.setActionCommand("btn");
	    btn.addActionListener(this);
	   
		lbsno=new JLabel("                      学  号:");jtsno=new JTextField(sno,10);	
		lbname = new JLabel("                      姓  名:"); jtname = new JTextField(name,10);
		JLabel lbsex = new JLabel("                      性  别:");jtsex = new JTextField(sex,10);
		JLabel lbdept = new JLabel("                      学  院:");jtdept = new JTextField(dept,10);
		JLabel lbmajor = new JLabel("                      专  业:");jtmajor = new JTextField(major,10);
		lbpwd=new JLabel("    	            登录密码:");jtpwd=new JTextField(pwd,10);
		jtsno.setEnabled(false);
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
		//添加组件到面板
		
	    jp.add(lbsno);jp.add(jtsno);
		jp.add(lbname);jp.add(jtname);
		jp.add(lbsex);jp.add(jtsex);
		jp.add(lbdept);jp.add(jtdept);
		jp.add(lbmajor);jp.add(jtmajor);
		jp.add(lbpwd);jp.add(jtpwd);
		jp2.add(btn);
		jp1.add(jp,BorderLayout.CENTER);
		jp1.add(jp2,BorderLayout.SOUTH);
		jp2.add(btn);
		jp1.add(jp,BorderLayout.CENTER);
		jp1.add(jp2,BorderLayout.SOUTH);
		
		this.add(jp1);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btn")){
			int resOne=JOptionPane.showConfirmDialog(new AddteaFrame2(sno,name,sex,dept,major, pwd),"确定修改","账号",JOptionPane.OK_CANCEL_OPTION);
 			if(resOne==0){
 				String n=jtname.getText().trim();
 				String x=jtsex.getText().trim();
 				String d=jtdept.getText().trim();
 				String m=jtmajor.getText().trim();
 				String p=jtpwd.getText().trim();
 				try{
 				    String sql="update infostudent set Sname='"+n+"',Ssex='"+x+"',Sdept='"+d+"',Smajor='"+m+"',Password='"+p+"' where Sno='"+sno+"'";
 					Jdbc.insert(sql);
 					this.dispose();
 					  	    
 				  }catch(Exception ss){ss.printStackTrace();}   
 			  }
 		
		  }
 			
	}
	
			
 	 
}

