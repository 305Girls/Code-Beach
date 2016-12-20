import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;

public class menu {

	private JFrame frame;
	public Object q1=null,q2=null,q3=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
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
	public menu() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		boolean flag;
		flag=DB.open("localhost:1433");
		System.out.println(flag);
		String sql1="select dpmName from Department";
		String sql2="select meName from Medicine";
		String sql3="select name from Doctor";
		ResultSet r1=null;
		ResultSet r2=null;
		ResultSet r3=null;
		r1=DB.excuteSelect(sql1);
		r2=DB.excuteSelect(sql2);
		r3=DB.excuteSelect(sql3);
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 614, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		/************************************************************************************************************************************/
		final JLabel label_5 = new JLabel("");
		label_5.setBounds(266, 177, 54, 15);
		frame.getContentPane().add(label_5);
		
		final JLabel label_6 = new JLabel("");
		label_6.setBounds(409, 177, 54, 15);
		frame.getContentPane().add(label_6);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.addItemListener(new ItemListener() {                  
	            public void itemStateChanged(ItemEvent event) {  
	            
				if (event.getStateChange()==ItemEvent.SELECTED)
	                     q1 = event.getItem();  
	            }
	        });
		while(r1.next()){
		comboBox.addItem(r1.getString("dpmName"));}
		comboBox.setBounds(67, 131, 143, 21);
		frame.getContentPane().add(comboBox);

		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u7EDF\u8BA1\u79D1\u5BA4\u7684\u6302\u53F7\u91CF\u548C\u603B\u91D1\u989D");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(q1);
				try {
					int a=searchdepart(q1);
					String c=Integer.toString(a);
					
					label_5.setText(c);	
					label_6.setText(Integer.toString(11*a));	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(283, 130, 251, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		/************************************************************************************************************************************/
		
	
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(429, 273, 105, 15);
		frame.getContentPane().add(lblNewLabel);
		

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {                  
            public void itemStateChanged(ItemEvent event) {  
            
			if (event.getStateChange()==ItemEvent.SELECTED)
                     q2 = event.getItem();  
            }
        });
	while(r2.next()){
		comboBox_1.addItem(r2.getString("meName"));}
		comboBox_1.setBounds(67, 225, 143, 21);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u836F\u623F\u836F\u54C1\u7684\u5E93\u5B58\u91CF");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(q2);

				try {
					String c=Integer.toString(searchmecount(q2));
					lblNewLabel.setText(c);		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
			}
		});
		btnNewButton.setBounds(283, 224, 251, 23);
		frame.getContentPane().add(btnNewButton);
		/************************************************************************************************************************************/		

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItemListener(new ItemListener() {                  
            public void itemStateChanged(ItemEvent event) {  
            
			if (event.getStateChange()==ItemEvent.SELECTED)
                     q3 = event.getItem();  
            }
        });
		while(r3.next()){
			comboBox_2.addItem(r3.getString("name"));}
		comboBox_2.setBounds(67, 317, 143, 21);
		frame.getContentPane().add(comboBox_2);
		
		JButton button = new JButton("\u67E5\u8BE2\u533B\u751F\u7684\u5C31\u8BCA\u6570\u91CF\u548C\u91D1\u989D");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(q3);
			}
		});
		button.setBounds(283, 316, 251, 23);
		frame.getContentPane().add(button);
		/************************************************************************************************************************************/			
		
		
		JLabel lblWelcome = new JLabel("welcome\uFF01\u9662\u957F\uFF01\uFF01\uFF01");
		lblWelcome.setForeground(Color.BLUE);
		lblWelcome.setBackground(Color.BLUE);
		lblWelcome.setFont(new Font("ËÎÌו", Font.PLAIN, 17));
		lblWelcome.setBounds(200, 39, 187, 30);
		frame.getContentPane().add(lblWelcome);	
		
		JLabel label = new JLabel("\u6302\u53F7\u91CF\uFF1A");
		label.setBounds(220, 177, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u603B\u91D1\u989D\uFF1A");
		label_1.setBounds(363, 177, 54, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u5E93\u5B58\u91CF\uFF1A");
		label_2.setBounds(363, 273, 54, 15);
		frame.getContentPane().add(label_2);
		

		
		JLabel label_3 = new JLabel("\u5C31\u8BCA\u6570\u91CF\uFF1A");
		label_3.setBounds(200, 352, 66, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u91D1\u989D\uFF1A");
		label_4.setBounds(363, 349, 54, 15);
		frame.getContentPane().add(label_4);
		

		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(266, 352, 54, 15);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(409, 352, 54, 15);
		frame.getContentPane().add(label_8);

	}

	
	
	
	
	
	
	public int searchmecount(Object q2) throws SQLException {
		// TODO Auto-generated method stub
		String sql21="select meCount from Medicine where meName='"+q2+"'";
		ResultSet r21=null;
		r21=DB.excuteSelect(sql21);
		if(r21.next())
		System.out.println(r21.getInt("meCount"));
		return r21.getInt("meCount");
	}
	
	public int searchdepart(Object q1) throws SQLException {
		// TODO Auto-generated method stub
		String sql11="select SUM(patientNumber) as num from Doctor,Department where Department.dpmId=Doctor.dpmId and Department.dpmName='"+q1+"'";
		ResultSet r11=null;
		r11=DB.excuteSelect(sql11);
		if(r11.next())
		System.out.println(r11.getInt("num"));
		return r11.getInt("num");
	}
	
	
	
	
	
	
	
}
