import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TheRollingScreenDemo {

	private JFrame frame;
	private JTable table;
	public Object q1=null,q2=null;
	int hour;
	SimpleDateFormat d;
	DefaultTableModel m;


	static Socket server = null;
	static String log_in;//登录信息
	static String duty="0";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					server=new Socket("192.168.1.109", 4444);
					PrintWriter os = new PrintWriter(server.getOutputStream());
					BufferedReader is= new BufferedReader(new InputStreamReader(server.getInputStream()));
					os.println("345112");
					os.flush();
					os.println("a85tx6");
					os.flush();
					os.println(duty);
					os.flush();
					log_in=is.readLine();
					if(log_in.matches("succeed"))
					{
						JOptionPane.showMessageDialog(null,"登陆成功！正在连接数据库...",null, JOptionPane.PLAIN_MESSAGE); 
						String ip=is.readLine();//接收数据库地址
						//连接数据库
						if(DB.open(ip))
						{
							JOptionPane.showMessageDialog(null, "数据库连接成功！");
							TheRollingScreenDemo window = new TheRollingScreenDemo();
							window.frame.setVisible(true);

						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,log_in, "ERROR", JOptionPane.ERROR_MESSAGE); 
					}
					os.close();// 关闭Socket输出流
					is.close();// 关闭Socket输入流
					server.close();
				}
					


				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public TheRollingScreenDemo() throws SQLException, AWTException, UnknownHostException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	private void initialize() throws SQLException, AWTException, UnknownHostException, IOException {
		  d = new SimpleDateFormat("yyyy.MM.dd");//设置日期格式
		//System.out.println(d.format(new Date()));// new Date()为获取当前系统时

			Calendar c= Calendar.getInstance();
			hour=c.get(Calendar.HOUR_OF_DAY);
			//System.out.println(hour);



			
			
		frame = new JFrame();
		frame.setTitle("\u6EDA\u52A8\u5927\u5C4F");
		frame.setBounds(100, 100, 524, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		boolean flag=DB.open("192.168.1.109");
		//System.out.println(flag);

		
		
		String sql1="select dpmName from Department where not dpmId='0' order by dpmId+0";
		ResultSet r1=null;
		r1=DB.excuteSelect(sql1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 10, 427, 230);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
	
		
		 m=new DefaultTableModel();
			m.addColumn("排队号");
			m.addColumn("病人姓名");
			
			
			table.setModel(m);
			scrollPane.setViewportView(table);
			
			/************************************************************************************************************************************/
			
			final JComboBox comboBox = new JComboBox();
			comboBox.setBounds(53, 261, 142, 21);
			frame.getContentPane().add(comboBox);
			
			final JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(261, 261, 142, 21);
			frame.getContentPane().add(comboBox_1);
			
			comboBox.addItem("");
			while(r1.next()){
				comboBox.addItem(r1.getString("dpmName"));}
			
			comboBox.addItemListener(new ItemListener() {                  
	            public void itemStateChanged(ItemEvent event) {  
	            
				if (event.getStateChange()==ItemEvent.SELECTED)
	                     q1 = event.getItem();  
				comboBox_1.removeAllItems();
				String sql2="select name from Doctor,Department where Doctor.dpmId=Department.dpmId and dpmName='"+q1+"'";
				ResultSet r2=null;
				r2=DB.excuteSelect(sql2);
				try {
					while(r2.next()){
						comboBox_1.addItem(r2.getString("name"));}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }
	        });
	
			comboBox_1.addItemListener(new ItemListener() {                  
	            public void itemStateChanged(ItemEvent event) {  
	            
				if (event.getStateChange()==ItemEvent.SELECTED)
	                     q2 = event.getItem();  
	            }
	        });
		
			/************************************************************************************************************************************/	
			
			final JButton btnNewButton = new JButton("\u67E5\u8BE2");

			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					ResultSet f=null;
					String newhour=changetime(hour);
					System.out.println(newhour);
					String o="08:00:00";
					String a="13:00:00";
					
					
					if(newhour.compareTo(a)==0){
						//System.out.println(newhour.compareTo(a));
					f=search13(d.format(new Date()),newhour);}
					else f=search8(d.format(new Date()),newhour);
		
					m.setRowCount(0);

					try {
						while(f.next()){
							Vector v=new Vector();
							v.addElement(f.getString("qNumber"));
							v.addElement(f.getString("name"));
							m.addRow(v);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Timer t=new Timer();
					t.schedule(new task(),1000,20*1000);
					
					/*
					boolean f=true;
					while (f){						
					try {
						Robot r=new Robot();
						simulationClick(btnNewButton);
						r.delay(10000);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
					*/
					
				}
			});
			/*
			Timer timer = new Timer(true);
			TaskByTimer task = new TaskByTimer();
			timer.schedule(task,0,10*1000);
			//timer.schedule(task,0,4*60*60*1000);//每四个小时执行一次task的run
			*/
			btnNewButton.setBounds(277, 310, 93, 23);
			frame.getContentPane().add(btnNewButton);
			
		
			
		
	}
	
	public ResultSet search13(String date,String hour){
		String sql3="select qNumber,Patient.name from Patient,PatientHSP,Department,Doctor where Patient.pId=PatientHSP.pId and PatientHSP.dId=Doctor.dId and PatientHSP.dpmId=Department.dpmId and dpmName='"+q1+"' and Doctor.name='"+q2+"'  and   ( (isVisit='2' and convert(varchar(10),appTime,102)='"+date+"' and convert(varchar(10),appTime,108)>='12:00:00') or(  isVisit='3'and convert(varchar(10),qTime,102)='"+date+"' and convert(varchar(10),qTime,108)='"+hour+"') ) order by qNumber+0 ";
		ResultSet r3=null;
		r3=DB.excuteSelect(sql3);
		return r3;
	}
	
	public ResultSet search8(String date,String hour){
		String sql3="select qNumber,Patient.name from Patient,PatientHSP,Department,Doctor where Patient.pId=PatientHSP.pId and PatientHSP.dId=Doctor.dId and PatientHSP.dpmId=Department.dpmId and dpmName='"+q1+"' and Doctor.name='"+q2+"' and ((isVisit='2' and convert(varchar(10),appTime,102)='"+date+"' and convert(varchar(10),appTime,108)<'12:00:00')or( isVisit='3'and convert(varchar(10),qTime,102)='"+date+"' and convert(varchar(10),qTime,108)='"+hour+"')) order by qNumber+0";
		ResultSet r3=null;
		r3=DB.excuteSelect(sql3);
		return r3;
	}
	
	public String changetime(int hour){
		String newhour;
		if (hour<=12){
			newhour="08:00:00";
		}
		else newhour="13:00:00";
		return newhour;		
	}
	

	
	class task extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			ResultSet fuck=null;
			String newhour=changetime(hour);
			String o="08:00:00";
			String a="13:00:00";		
			
			if(newhour.compareTo(a)==0){
				//System.out.println(newhour.compareTo(a));
			fuck=search13(d.format(new Date()),newhour);}
			else fuck=search8(d.format(new Date()),newhour);
	
			m.setRowCount(0);

			try {
				while(fuck.next()){
					Vector v=new Vector();
					v.addElement(fuck.getString("qNumber"));
					v.addElement(fuck.getString("name"));
					m.addRow(v);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//SimpleDateFormat dr = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");//设置日期格式
			//System.out.println(dr.format(new Date()));
		}
		
		
	}
	/*
    public void simulationClick(JButton btn1) throws AWTException  
    {  
        //模拟鼠标点击代码  
        Point p1 = btn1.getLocation();  
        //System.out.println(p1.x + "," + p1.y);  
        Point p = MouseInfo.getPointerInfo().getLocation();  
        int x = p.x;  
        int y = p.y;  
        Robot robot = new Robot();  
        //System.out.println(x + "," + y);  
        robot.mouseMove(x, y); 
        robot.mousePress(InputEvent.BUTTON1_MASK);  
        robot.mouseRelease(InputEvent.BUTTON1_MASK);         
    }  
	*/

}
