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



//**********老师查看     学生信息***********
class StuFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -4642798859398103882L;
	private JTextField jtf;
	private JButton btn1,btn2,btn3,btn4;
	JTable jt=null;
	JScrollPane jsp=null;
	//rowData用来存放行数据
	//columnNames  存放列名
	Vector<Object> rowData;
	Vector<Object> columnNames;
	Vector<Object> hang;
	//定义操作数据库参数
	String JDriver= "com.mysql.jdbc.Driver";// SQL数据库引擎    
	String URl="jdbc:mysql://127.0.0.1:3306/student";
	String userName="root";
	String userPwd="123";
	String sql;
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	

	/*********链接数据库*************/
	public void getConnection(){
		 try{
			 try {  
		            Class.forName(JDriver); 
		            System.out.println("加载数据库引擎成功");
		        } catch (ClassNotFoundException e) {  
		        	 System.out.println("加载数据库引擎失败");
		        }  
	     		ct=DriverManager.getConnection(URl,userName,userPwd);
	     		ps=ct.prepareStatement(sql);//预编译  
	      	    rs=ps.executeQuery(); //执行sql操作 处理 返回结果
	     	 }catch(Exception r){
	        	 try{
	     	    	if(ct!=null){ ct.close();}
	     	    	if(ps!=null){ ct.close();}
	     	    	if(rs!=null){ ct.close();}
	     	    	}catch(Exception c){System.out.println("数据库连接异常");}
	         }
		
	}
	
	
    public StuFrame(){
    	
    	/*******主界面*******/
    	this.setTitle("学生信息表");
		this.setSize(400,350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*******上层界面*******/
		JPanel jp1=new JPanel();
		jp1.setLayout(new FlowLayout());
	    jtf=new JTextField("请输入查询姓名",10);
	    btn1=new JButton("查询");
	    jp1.add(jtf);
	    jp1.add(btn1);
	    /*******下层界面*******/
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout());
		btn2=new JButton("增加");
		btn3=new JButton("修改");
		btn4=new JButton("删除");
		jp2.add(btn2);
		jp2.add(btn3);
		jp2.add(btn4);
		
		
		/*********注册监听器*****************/
		btn1.setActionCommand("btn1"); 
		btn1.addActionListener(this);
		btn2.setActionCommand("btn2"); 
		btn2.addActionListener(this);
		btn3.setActionCommand("btn3"); 
		btn3.addActionListener(this);
		btn4.setActionCommand("btn4"); 
		btn4.addActionListener(this);  
		//实例化一个数据模型对象
	    StudentinfoModel sm=new StudentinfoModel();
        jt=new JTable(sm);
        //初始化JTable
        jsp=new JScrollPane(jt);
        this.add(jp1,BorderLayout.NORTH);
        this.add(jsp,BorderLayout.CENTER);
        this.add(jp2,BorderLayout.SOUTH);
	}
   
    
    
    
    /**********事件处理*************************/
    public void actionPerformed(ActionEvent e) {
		//判断哪个按钮被点击 ,查询
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
