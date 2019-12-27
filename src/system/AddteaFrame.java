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

//***********��Ϣ����***************	
class AddteaFrame extends JFrame implements ActionListener {
	JLabel lbsno,lbpwd,lbpwd1,lbname;
	JTextField jtname,jtsex,jtdept,jtmajor,jtsno,jtpwd,jtpwd1;
	String sql;
	StudentinfoModel sm;
	/*����ѧ����Ϣ����*/
	public AddteaFrame(){
		this.setTitle("ѧ����Ϣ");
		this.setSize(500, 400);
		JPanel jp1=new JPanel(new BorderLayout());
	    JPanel jp2=new JPanel();
	    JPanel jp = new JPanel(new GridLayout(7,10,0,5));
	    JButton btn = new JButton("ȷ��");
		lbsno=new JLabel("                      ѧ  ��:");jtsno=new JTextField(10);	
		lbname = new JLabel("                      ��  ��:"); jtname = new JTextField(10);
		JLabel lbsex = new JLabel("                      ��  ��:");jtsex = new JTextField(10);
		JLabel lbdept = new JLabel("                      ѧ  Ժ:");jtdept = new JTextField(10);
		JLabel lbmajor = new JLabel("                      ר  ҵ:");jtmajor = new JTextField(10);
		lbpwd=new JLabel("    	            ��¼����:");jtpwd=new JTextField(10);
	
		//�����ı���������ɫ
        jtsex.setForeground(Color.red);jtmajor.setForeground(Color.red);
		jtname.setForeground(Color.red);jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		//�����ı��������С
		jtname.setFont(new Font("Dialog",0,22));jtsex.setFont(new Font("Dialog",0,22));
		jtdept.setFont(new Font("Dialog",0,22));jtmajor.setFont(new Font("Dialog",0,22));
		jtpwd.setFont(new Font("Dialog",0,22));jtsno.setFont(new Font("Dialog",0,22));
		//���ñ�ǩ�����С
		lbsno.setFont(new Font("Dialog",1,22));lbname.setFont(new Font("Dialog",1,22));
		lbsex.setFont(new Font("Dialog",1,22));lbdept.setFont(new Font("Dialog",1,22));
		lbmajor.setFont(new Font("Dialog",1,22));lbpwd.setFont(new Font("Dialog",1,22));
		//�����������
		
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
			int resOne=JOptionPane.showConfirmDialog(this,"ȷ������","�˺�",JOptionPane.OK_CANCEL_OPTION);
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
	/*�޸�ѧ����Ϣ����*/
	public AddteaFrame2(String sno,String name,String sex,String dept,String major,String  pwd){
		this.sno=sno;
		this.name=name;
		this.sex=sex;
		this.dept=dept;
		this.major=major;
		this.pwd=pwd;
		
		this.setTitle("ѧ����Ϣ");
		this.setSize(500, 400);
		JPanel jp1=new JPanel(new BorderLayout());
	    JPanel jp2=new JPanel();
	    JPanel jp = new JPanel(new GridLayout(7,10,0,5));
	    JButton btn = new JButton("ȷ��");
	    btn.setActionCommand("btn");
	    btn.addActionListener(this);
	   
		lbsno=new JLabel("                      ѧ  ��:");jtsno=new JTextField(sno,10);	
		lbname = new JLabel("                      ��  ��:"); jtname = new JTextField(name,10);
		JLabel lbsex = new JLabel("                      ��  ��:");jtsex = new JTextField(sex,10);
		JLabel lbdept = new JLabel("                      ѧ  Ժ:");jtdept = new JTextField(dept,10);
		JLabel lbmajor = new JLabel("                      ר  ҵ:");jtmajor = new JTextField(major,10);
		lbpwd=new JLabel("    	            ��¼����:");jtpwd=new JTextField(pwd,10);
		jtsno.setEnabled(false);
		//�����ı���������ɫ
        jtsex.setForeground(Color.red);jtmajor.setForeground(Color.red);
		jtname.setForeground(Color.red);jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		//�����ı��������С
		jtname.setFont(new Font("Dialog",0,22));jtsex.setFont(new Font("Dialog",0,22));
		jtdept.setFont(new Font("Dialog",0,22));jtmajor.setFont(new Font("Dialog",0,22));
		jtpwd.setFont(new Font("Dialog",0,22));jtsno.setFont(new Font("Dialog",0,22));
		//���ñ�ǩ�����С
		lbsno.setFont(new Font("Dialog",1,22));lbname.setFont(new Font("Dialog",1,22));
		lbsex.setFont(new Font("Dialog",1,22));lbdept.setFont(new Font("Dialog",1,22));
		lbmajor.setFont(new Font("Dialog",1,22));lbpwd.setFont(new Font("Dialog",1,22));
		//�����������
		
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
			int resOne=JOptionPane.showConfirmDialog(new AddteaFrame2(sno,name,sex,dept,major, pwd),"ȷ���޸�","�˺�",JOptionPane.OK_CANCEL_OPTION);
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

