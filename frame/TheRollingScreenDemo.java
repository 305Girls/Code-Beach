import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TheRollingScreenDemo {

	private JFrame frame;
	private JTable table;
	public Object q1=null,q2=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheRollingScreenDemo window = new TheRollingScreenDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public TheRollingScreenDemo() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		final SimpleDateFormat d = new SimpleDateFormat("yyyy.MM.dd");//设置日期格式
		System.out.println(d.format(new Date()));// new Date()为获取当前系统时

			Calendar c= Calendar.getInstance();
			final int hour=c.get(Calendar.HOUR_OF_DAY);
			System.out.println(hour);

		
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		boolean flag=DB.open("localhost:1433");
		System.out.println(flag);
		
		String sql1="select dpmName from Department";
		ResultSet r1=null;
		r1=DB.excuteSelect(sql1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 10, 427, 230);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
	
		
		 final DefaultTableModel m=new DefaultTableModel();
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
			
			JButton btnNewButton = new JButton("\u67E5\u8BE2");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					ResultSet fuck=null;
					String newhour=changetime(hour);
					System.out.println(newhour);
					String o="08:00:00";
					String a="13:00:00";
					
					
					if(newhour.compareTo(a)==0){
						System.out.println(newhour.compareTo(a));
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
					
				}
			});
			btnNewButton.setBounds(277, 310, 93, 23);
			frame.getContentPane().add(btnNewButton);
			
			
		
		
	}
	
	public ResultSet search13(String date,String hour){
		String sql3="select qNumber,Patient.name from Patient,PatientHSP,Department,Doctor where Patient.pId=PatientHSP.pId and PatientHSP.dId=Doctor.dId and PatientHSP.dpmId=Department.dpmId and dpmName='"+q1+"' and Doctor.name='"+q2+"'  and   ( (isVisit='2' and convert(varchar(10),appTime,102)='"+date+"' and convert(varchar(10),appTime,108)>='"+hour+"') or(  isVisit='3'and convert(varchar(10),qTime,102)='"+date+"' and convert(varchar(10),qTime,108)='"+hour+"') ) ";
		ResultSet r3=null;
		r3=DB.excuteSelect(sql3);
		return r3;
	}
	
	public ResultSet search8(String date,String hour){
		String sql3="select qNumber,Patient.name from Patient,PatientHSP,Department,Doctor where Patient.pId=PatientHSP.pId and PatientHSP.dId=Doctor.dId and PatientHSP.dpmId=Department.dpmId and dpmName='"+q1+"' and Doctor.name='"+q2+"' and ((isVisit='2' and convert(varchar(10),appTime,102)='"+date+"' and convert(varchar(10),appTime,108)<'"+hour+"')or( isVisit='3'and convert(varchar(10),qTime,102)='"+date+"' and convert(varchar(10),qTime,108)='"+hour+"'))";
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

}
