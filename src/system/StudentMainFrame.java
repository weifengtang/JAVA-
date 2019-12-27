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
 *  ѧ������----ѧ���鿴 ������Ϣ         �޸ĸ�����Ϣ   ѧ���ɼ�  
 */
/********ѧ����½ ������************/
public class StudentMainFrame extends JFrame implements ActionListener{
	JLabel lbsno,lbname,lbsex,lbdept,lbmajor,lbpwd,lbGrade1,lbGrade2,lbGrade3,lbTotal;
	JTextField jtsno,jtname,jtsex,jtdept,jtmajor,jtpwd,jtGrade1,jtGrade2,jtGrade3,jtTotal;
	JPanel jp2,cardpanel,infojp,gradejp,updatejp; 
	JButton infobtn,updatebtn,gradebtn,exitbtn,upbtn;
	CardLayout card;
	//����������ݿ����
	String sql;
	Connection ct=null;
	PreparedStatement ps;
	ResultSet rs;
	String number=null;
	String name ,sex, dept, major, pwd,Grade1,Grade2,Grade3,TotalGrade;
	
	
	//�鿴������Ϣ����
	
	public JPanel infojp(){
		try{
			sql="select * from infostudent where Sno='"+number+"' "; //��������sql���
			ct=Jdbc.getconnection();
	    	ps=ct.prepareStatement(sql);//Ԥ����  
      	    rs=ps.executeQuery(); //ִ��sql���� ���� ���ؽ��
			while(rs.next()){	
			//jtname.setText(rs.getString("Sname"));
			  //name=rs.getString("Sname");
			  sex=rs.getString("Ssex");
			  dept=rs.getString("Sdept");
			  major=rs.getString("Smajor");
			  pwd=rs.getString("Password");
			}
		}catch(Exception c){}
		
		lbsno=new JLabel("                      ѧ  ��:");jtsno=new JTextField(number);	
		lbname=new JLabel("                      ��  ��:");jtname=new JTextField(name);
		lbsex=new JLabel("                      ��  ��:");jtsex=new JTextField(sex);
		lbdept=new JLabel("                      ѧ  Ժ:");jtdept=new JTextField(dept);
		lbmajor=new JLabel("                      ר  ҵ:");jtmajor=new JTextField(major);
		lbpwd=new JLabel("                    ��¼����:");jtpwd=new JTextField(pwd);
		
		jtsno.setForeground(Color.red); //�����ı���������ɫ
		jtsex.setForeground(Color.red);
		jtname.setForeground(Color.red);
		jtmajor.setForeground(Color.red);
		jtdept.setForeground(Color.red);
		jtpwd.setForeground(Color.red);
		jtsno.setFont(new Font("Dialog",1,22));//�����ı��������С
		jtname.setFont(new Font("Dialog",1,22));
		jtsex.setFont(new Font("Dialog",1,22));
		jtdept.setFont(new Font("Dialog",1,22));
		jtmajor.setFont(new Font("Dialog",1,22));
		jtpwd.setFont(new Font("Dialog",1,22));
		lbsno.setFont(new Font("Dialog",1,22));//���ñ�ǩ�����С
		lbname.setFont(new Font("Dialog",1,22));
		lbsex.setFont(new Font("Dialog",1,22));
		lbdept.setFont(new Font("Dialog",1,22));
		lbmajor.setFont(new Font("Dialog",1,22));
		lbpwd.setFont(new Font("Dialog",1,22));
		jtsno.setEnabled(false);//�����ı��򲻿ɱ༭
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
	//�鿴���˳ɼ�����
	public JPanel gradejp(){
		try{
			sql="select * from gradestudent where Sno='"+number+"' "; //��������sql���
			ct=Jdbc.getconnection();
	    	ps=ct.prepareStatement(sql);//Ԥ����  
      	    rs=ps.executeQuery(); //ִ��sql���� ���� ���ؽ��
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
		lbsno=new JLabel("                        ѧ ��:");jtsno=new JTextField(number);
		lbname=new JLabel("                        �� ��:");jtname=new JTextField(name);
		lbGrade1=new JLabel("               JAVA�ɼ�:");jtGrade1=new JTextField(Grade1);
		lbGrade2=new JLabel("              ���ݿ�ɼ�:");jtGrade2=new JTextField(Grade2);
		lbGrade3=new JLabel("                Ӣ��ɼ� :");jtGrade3=new JTextField(Grade3);
		lbTotal=new JLabel("                        �� ��:");jtTotal=new JTextField(TotalGrade);	
		//�����ı���������ɫ 
		jtsno.setForeground(Color.red); jtname.setForeground(Color.red);
		jtGrade1.setForeground(Color.red);jtGrade2.setForeground(Color.red);
		jtGrade3.setForeground(Color.red);jtTotal.setForeground(Color.red);
		//�����ı��������С
		jtsno.setFont(new Font("Dialog",1,22));jtname.setFont(new Font("Dialog",1,22));
		jtGrade1.setFont(new Font("Dialog",1,22));jtGrade2.setFont(new Font("Dialog",1,22));
		jtGrade3.setFont(new Font("Dialog",1,22));jtTotal.setFont(new Font("Dialog",1,22));
		//���ñ�ǩ�����С
		lbsno.setFont(new Font("Dialog",1,22));lbname.setFont(new Font("Dialog",1,22));
		lbGrade1.setFont(new Font("Dialog",1,22));lbGrade2.setFont(new Font("Dialog",1,22));
		lbGrade3.setFont(new Font("Dialog",1,22));lbTotal.setFont(new Font("Dialog",1,22));
		//�����ı��򲻿ɱ༭
		jtsno.setEnabled(false);jtname.setEnabled(false);
		jtGrade1.setEnabled(false);jtGrade2.setEnabled(false);
		jtGrade3.setEnabled(false);jtTotal.setEnabled(false);
		//�������� grade���
		gradejp.add(lbsno);gradejp.add(jtsno);
		gradejp.add(lbname);gradejp.add(jtname);
		gradejp.add(lbGrade1);gradejp.add(jtGrade1);
		gradejp.add(lbGrade2);gradejp.add(jtGrade2);
		gradejp.add(lbGrade3);gradejp.add(jtGrade3);
		gradejp.add(lbTotal);gradejp.add(jtTotal);
	    return gradejp;
	    }
	
	//�޸ĸ�����Ϣ���� 
	public JPanel updatejp(){
		    JPanel jp1=new JPanel(new BorderLayout());
		    JPanel jp2=new JPanel();
		  
		    try{
				sql="select * from infostudent where Sno='"+number+"' "; //��������sql���
				ct=Jdbc.getconnection();
    	    	ps=ct.prepareStatement(sql);//Ԥ����  
	      	    rs=ps.executeQuery(); //ִ��sql���� ���� ���ؽ��
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
		    upbtn=new JButton("�޸�");
			upbtn.setActionCommand("upbtn");
			upbtn.addActionListener(this);
			lbsno=new JLabel("                      ѧ  ��:");jtsno=new JTextField(number,10);	
			lbname=new JLabel("                      ��  ��:");jtname=new JTextField(name,10);
			lbsex=new JLabel("                      ��  ��:");jtsex=new JTextField(sex,10);
			lbdept=new JLabel("                      ѧ  Ժ:");jtdept=new JTextField(dept,10);
			lbmajor=new JLabel("                      ר  ҵ:");jtmajor=new JTextField(major,10);
			lbpwd=new JLabel("    	            ��¼����:");jtpwd=new JTextField(pwd,10);
		
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
			jtsno.setEnabled(false);//�����ı��򲻿ɱ༭
			//�����������
			
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
		this.setTitle("���ã�"+name+"ͬѧ");
		this.setSize(800,600);
		this.setLayout(new BorderLayout());
		jp2=new JPanel(new GridLayout(1,3,2,1));
		//��Ƭ����
		card=new CardLayout();
		cardpanel=new JPanel(card);
		cardpanel.add("1",infojp());
		cardpanel.add("2",gradejp());
		cardpanel.add("3",updatejp());
		infobtn=new JButton("�鿴������Ϣ");
		gradebtn=new JButton("�鿴���˳ɼ�");
		updatebtn=new JButton("�޸ĸ�����Ϣ");
		exitbtn=new JButton("�˳�");
		
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
//***********ע���¼�������***************
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
		    String message="ȷ���޸�"+number+name+"����Ϣ";
			int resOne=JOptionPane.showConfirmDialog(this,message,"�޸���Ϣ",JOptionPane.OK_CANCEL_OPTION);
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
