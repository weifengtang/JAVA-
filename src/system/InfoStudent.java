package system;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



//**********��ʦ�鿴     ѧ����Ϣ***********
class StuFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -4642798859398103882L;
	private JTextField jtf;
	private JButton btn1,btn2,btn3,btn4;
	JTable jt=null;
	JScrollPane jsp=null;
	//rowData�������������
	//columnNames  �������
	Vector<Object> rowData;
	Vector<Object> columnNames;
	Vector<Object> hang;
	//����������ݿ����
	String JDriver= "com.mysql.jdbc.Driver";// SQL���ݿ�����    
	String URl="jdbc:mysql://127.0.0.1:3306/student";
	String userName="root";
	String userPwd="123";
	String sql;
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	

	/*********�������ݿ�*************/
	public void getConnection(){
		 try{
			 try {  
		            Class.forName(JDriver); 
		            System.out.println("�������ݿ�����ɹ�");
		        } catch (ClassNotFoundException e) {  
		        	 System.out.println("�������ݿ�����ʧ��");
		        }  
	     		ct=DriverManager.getConnection(URl,userName,userPwd);
	     		ps=ct.prepareStatement(sql);//Ԥ����  
	      	    rs=ps.executeQuery(); //ִ��sql���� ���� ���ؽ��
	     	 }catch(Exception r){
	        	 try{
	     	    	if(ct!=null){ ct.close();}
	     	    	if(ps!=null){ ct.close();}
	     	    	if(rs!=null){ ct.close();}
	     	    	}catch(Exception c){System.out.println("���ݿ������쳣");}
	         }
		
	}
	
	
    public StuFrame(){
    	
    	/*******������*******/
    	this.setTitle("ѧ����Ϣ��");
		this.setSize(400,350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*******�ϲ����*******/
		JPanel jp1=new JPanel();
		jp1.setLayout(new FlowLayout());
	    jtf=new JTextField("�������ѯ����",10);
	    btn1=new JButton("��ѯ");
	    jp1.add(jtf);
	    jp1.add(btn1);
	    /*******�²����*******/
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout());
		btn2=new JButton("����");
		btn3=new JButton("�޸�");
		btn4=new JButton("ɾ��");
		jp2.add(btn2);
		jp2.add(btn3);
		jp2.add(btn4);
		
		
		/*********ע�������*****************/
		btn1.setActionCommand("btn1"); 
		btn1.addActionListener(this);
		btn2.setActionCommand("btn2"); 
		btn2.addActionListener(this);
		btn3.setActionCommand("btn3"); 
		btn3.addActionListener(this);
		btn4.setActionCommand("btn4"); 
		btn4.addActionListener(this);  
		//ʵ����һ������ģ�Ͷ���
	    StudentinfoModel sm=new StudentinfoModel();
        jt=new JTable(sm);
        //��ʼ��JTable
        jsp=new JScrollPane(jt);
        this.add(jp1,BorderLayout.NORTH);
        this.add(jsp,BorderLayout.CENTER);
        this.add(jp2,BorderLayout.SOUTH);
	}
   
    
    
    
    /**********�¼�����*************************/
    public void actionPerformed(ActionEvent e) {
		//�ж��ĸ���ť����� ,��ѯ
    	String s=jtf.getText().trim();
		if(e.getActionCommand().equals("btn1")){
			try{
				sql="Select * From infostudent where"+"Sno like '2016'";
			}catch(Exception c){} 
		}
		else if(e.getActionCommand().equals("btn2")){
			System.out.println("btn2");
		}
		
	}
	
}
public class InfoStudent  {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuFrame frame = new StuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
