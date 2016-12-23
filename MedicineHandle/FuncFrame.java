import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u53D6\u836F");
	private JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u8BE5\u75C5\u4EBA\u8EAB\u4EFD\u8BC1\u53F7");
	private final JButton button = new JButton("\u786E\u8BA4");
	private final JButton button_2 = new JButton("\u786E\u8BA4\u53D6\u836F");
	private JTextField textField_1 = new JTextField();
	private final JButton button_3 = new JButton("\u53D6\u6D88");
	private int labelNull=1;
	public JTextField getTextField() {
		return textField_1;
	}
	public void setTextField(JTextField textField) {
		this.textField_1 = textField;
	}
	
	public JButton getBtnNewButton() {
		return button_3;
	}
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FuncFrame() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		lblNewLabel.setFont(new Font("等线 Light", Font.PLAIN, 26));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 150, 0);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		

		boolean flag=OPDB.open();
		System.out.println("数据库连接"+flag);
		
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 5;
		gbc_button_2.gridy = 9;
		button_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	    //确认取药的监视
				String sql1;  //补充库存
				String sql2;  //取药后更新库存
				String sql3;  //查看标志位
				String sql4;   //更新领药标志位
				int label=0;
				Boolean update1=false;
				Boolean update2=false;
				Boolean update3=false;
				Boolean update4=false;
				//String sql0="select ";
				ResultSet r0=null;
				ResultSet r1=null;
				Date date=new Date(System.currentTimeMillis()); 
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd"); 
				String time=format.format(date);
				//System.out.println(time);
				
				
				
				String sql0="select B.meName,B.mePrize,B.meCount,C.meNumber "+
		                   "from PatientHSP A,Medicine B,recipeMe C "+
		                   "where A.pId='"+ textField_1.getText() +"' and convert(varchar(10),A.appTime,120)='"+  
		                   time+"' and A.reId=C.reId and B.meId=C.meId";
				r0=OPDB.excuteSelect(sql0);
				
				sql3=" select IsVisit,isTake from PatientHSP where PId='"+textField_1.getText() +"'";
				
				r1=OPDB.excuteSelect(sql3);
				
				
                sql4="update PatientHSP set isTake=3 where PId='"+textField_1.getText() +"'";
				
				if(labelNull==1)
				
					JOptionPane.showMessageDialog(null, "无记录，不能取药！");
				else{
				try {
					r0=OPDB.excuteSelect(sql0);
					while(r0.next()){
						Vector v=new Vector();
						
						if(r0.getInt("meCount")<r0.getInt("meNumber"))
							{
							label=1;//补货了
							sql1= "update Medicine set meCount=100 where meName='"+r0.getString("meName")+"'";
							update1=OPDB.excuteIUD(sql1);
						    if(update1)System.out.println("库存不足，已补货");
							
							}
						
						try {
							
							sql3=" select IsVisit,isTake from PatientHSP where PId='"+textField_1.getText() +"'";
							r1=OPDB.excuteSelect(sql3);
							if(r1.next())
							{
							if(r1.getInt("IsVisit")!=4||r1.getInt("isTake")==0) 
								{JOptionPane.showMessageDialog(null, "病人还未就诊！");break;}
							if(r1.getInt("isTake")==1) 
								{JOptionPane.showMessageDialog(null, "病人还未付款！");break;}
							if(r1.getInt("isTake")==3) 
								{JOptionPane.showMessageDialog(null, "病人已取过药！");break;}
							}
							
							sql2="update Medicine set meCount=meCount-'"+r0.getString("meNumber")+"' where meName='"+r0.getString("meName")+"'";
						    update2=OPDB.excuteIUD(sql2);
						    //if(update2)System.out.println("已更新库存");
						    //System.out.println(update2);
						    
						    update4=OPDB.excuteIUD(sql4);
						    //if(update4)System.out.println("已改状态位");
						    //System.out.println(update4);
						    
						    
						    
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
						}
						
					}
					//else System.out.println("无结果");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				
				
			}
		});
		
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 230, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		textField_1.setColumns(10);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 6;
		panel.add(textField_1, gbc_textField_1);
		
		
		
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 6;
		
		
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//确认病人身份证号按钮的触发事件	
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(230, 60, 329, 183);
				
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 0;
				panel.add(scrollPane, gbc_scrollPane);
				
				JTable table = new JTable();
		
				final DefaultTableModel m=new DefaultTableModel();
				m.addColumn("药品名称");
				m.addColumn("药品价格");
				m.addColumn("药品库存");
				m.addColumn("取药数量");
				table.setFont(new Font("宋体", Font.PLAIN, 12));
				
				Date date=new Date(System.currentTimeMillis()); 
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd"); 
				String time=format.format(date);
				//获取当前时间
				
				
				String sql0;//查找当天病人药品记录
				String sql1;//更新库存
				ResultSet r0=null;  //病人记录结果集
				ResultSet r1=null;  //病人处方表标志位结果集
				Boolean update=false;//查询结果标志
				int label=0;   //更新库存标志
				
				sql0="select B.meName,B.mePrize,B.meCount,C.meNumber "+
		                   "from PatientHSP A,Medicine B,recipeMe C "+
		                   "where A.pId='"+ textField_1.getText() +"' and convert(varchar(10),A.appTime,120)='"+  
		                   time+"' and A.reId=C.reId and B.meId=C.meId";//FromH
				
				try {
					
					labelNull=1;  //1表示为空
					r0=OPDB.excuteSelect(sql0);
					Vector v=new Vector();
					
					while(r0.next()){
						//Vector v=new Vector();
						labelNull=0;  //0表示非空
						if(r0.getInt("meCount")<r0.getInt("meNumber"))
							{
							label=1;//补货了
							sql1= "update Medicine set meCount=100 where meName='"+r0.getString("meName")+"'";
							update=OPDB.excuteIUD(sql1);
						    if(update)System.out.println("库存不足，已补货");
							
							}
						
						try {
							
							System.out.println(r0.getString("meName"));
							v.addElement(r0.getString("meName"));
							v.addElement(r0.getString("mePrize"));
							if(label==1)
								
							v.addElement(100-r0.getInt("meNumber"));
							else 
								v.addElement(r0.getString("meCount"));
								
							v.addElement(r0.getString("meNumber"));
							
							
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
						}
						m.addRow(v);
						
					  }
					
			
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(m);
				scrollPane.setViewportView(table);
				
				
				
			}
		});
		panel.add(button, gbc_button);
		panel.add(button_2, gbc_button_2);
		
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.gridx = 6;
		gbc_button_3.gridy = 9;
		panel.add(button_3, gbc_button_3);
		
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridx = 6;
		gbc_button_1.gridy = 7;
		

    }
}
