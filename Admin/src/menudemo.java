import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JRadioButton;

public class menudemo {

	JFrame frmWelcome;
	private JTable table;
	private JTextField textField;
	public Object q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,z,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24;
	private JTable table_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table_2;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTable table_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboBox,comboBox_1; 
	private JTable table_4;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTable table_5;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTable table_6;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JScrollPane scrollPane_4;
	private JLabel lblNewLabel_7,lblNewLabel_8,lblNewLabel_9;
	private DefaultTableModel m;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllFrame a=new AllFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	public menudemo() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("WELCOME!\u7BA1\u7406\u5458");
		frmWelcome.setBounds(100, 100, 689, 474);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 677, 441);
		tabbedPane.setToolTipText("");
		frmWelcome.getContentPane().add(tabbedPane);
		
	/*	boolean flag=DB.open("localhost:1433");
		System.out.println(flag);
		*/
		/*********************************************************医院科室信息***************************************************************************/	
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		tabbedPane.addTab("医院科室信息", null, panel, null);JScrollPane scrollPane = new JScrollPane();
		panel.setLayout(null);
		
		final JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(534, 266, 92, 15);
		panel.add(lblNewLabel_7);
		
		final JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(534, 371, 92, 15);
		panel.add(lblNewLabel_9);
		
		
		final JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(534, 310, 128, 23);
		panel.add(lblNewLabel_8);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(101, 10, 458, 212);
		panel.add(scrollPane_1);
		
	
		table = new JTable() {
			  public boolean isCellEditable(int row, int column) {
				   if (column == 0) {//让column为2那一列不可用
				    return false;
				   } else
				    return true;
				  }
				 };
		m=new DefaultTableModel();
		m.addColumn("科室号");
		m.addColumn("科室");
		
		String sql0="select * from Department order by dpmId+0 ";
		ResultSet r0=null;
		r0=DB.excuteSelect(sql0);
		while(r0.next()){
			Vector v=new Vector();
			v.addElement(r0.getString("dpmId"));
			v.addElement(r0.getString("dpmName"));
			m.addRow(v);
		}
		table.setModel(m);	
		scrollPane_1.setViewportView(table);
	
		
		textField = new JTextField();
		textField.setBounds(216, 266, 147, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				q1=textField.getText();
				String samedepart="select dpmId from Department where dpmName='"+q1+"'";
				ResultSet sade=null;
				sade=DB.excuteSelect(samedepart);
				try {
					if(!sade.next()){

					try {
						Vector v=adddepart();
						m.addRow(v);
						SwingUtilities.updateComponentTreeUI(table);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
					
					refreshcombo();
					
					lblNewLabel_7.setText("添加成功");
					lblNewLabel_9.setText("");
					lblNewLabel_8.setText("");
					}
					
					else {lblNewLabel_7.setText("科室名重复");
					lblNewLabel_8.setText("");
					lblNewLabel_9.setText("");
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textField.setText("");
			}
		});
		btnNewButton.setBounds(402, 265, 93, 23);
		panel.add(btnNewButton);
		
	
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		
		btnNewButton_1.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object q,p;
                	p=table.getValueAt(table.getSelectedRow(), 0);
                	q=table.getValueAt(table.getSelectedRow(), 1);
                	
                	
                	if(Integer.parseInt(String.valueOf(p))!=0){
                		lblNewLabel_8.setText("删除成功");
                		lblNewLabel_7.setText("");
                		lblNewLabel_9.setText("");
                	m.removeRow(selectedRow);  //删除行
                	try {
						deletedepart(q);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    SwingUtilities.updateComponentTreeUI(table);
                    refreshcombo();
                    try {
    					refreshtable3();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                	}
                	else {lblNewLabel_8.setText("不能删除待分配科室");
                	lblNewLabel_7.setText("");
                	lblNewLabel_9.setText("");
                	}

                }

            }
        });
				

		btnNewButton_1.setBounds(402, 310, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		
		btnNewButton_2.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object p,q;
                	p=table.getValueAt(table.getSelectedRow(), 0);
                	q=table.getValueAt(table.getSelectedRow(), 1);
                	System.out.println(p);
                	System.out.println(q);
                	
                	String samedepart="select dpmId from Department where dpmName='"+q+"'";
    				ResultSet sade=null;
    				sade=DB.excuteSelect(samedepart);
                	try {
						if(!sade.next()){
							lblNewLabel_9.setText("修改成功");
							lblNewLabel_7.setText("");
							lblNewLabel_8.setText("");
						updatedepart(p,q);
						SwingUtilities.updateComponentTreeUI(table);
						refreshcombo();
						try {
							refreshtable3();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
						else {lblNewLabel_9.setText("科室名重复");
						lblNewLabel_7.setText("");
						lblNewLabel_8.setText("");
						String getname="select dpmName from Department where dpmId='"+p+"'";
						ResultSet id=null;
						id=DB.excuteSelect(getname);
						while(id.next()) table.setValueAt(id.getString("dpmName"),table.getSelectedRow(), 1);
						/*
						m.setRowCount(0);
						m=new DefaultTableModel();
						m.addColumn("科室号");
						m.addColumn("科室");
						
						String sql0="select * from Department order by dpmId+0 ";
						ResultSet r0=null;
						r0=DB.excuteSelect(sql0);
						while(r0.next()){
							Vector v=new Vector();
							v.addElement(r0.getString("dpmId"));
							v.addElement(r0.getString("dpmName"));
							m.addRow(v);
						}
						table.setModel(m);	
						*/
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                
            }
        });
		
		
		btnNewButton_2.setBounds(402, 363, 93, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u79D1\u5BA4\u540D\uFF1A");
		lblNewLabel.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(58, 269, 100, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u76F4\u63A5\u9009\u4E2D\u8981\u5220\u79D1\u5BA4\u6240\u5728\u884C\uFF1A");
		lblNewLabel_1.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(57, 318, 211, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u6570\u636E\u5E76\u9009\u4E2D\u8BE5\u884C\uFF1A");
		lblNewLabel_2.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(58, 368, 184, 15);
		panel.add(lblNewLabel_2);
		


		

		
		JLabel label_32 = new JLabel("");
		label_32.setBounds(570, 368, 54, 15);
		panel.add(label_32);
		
		JLabel label_33 = new JLabel("");
		label_33.setBounds(570, 318, 54, 15);
		panel.add(label_33);
		
		/**********************************************************药品信息**************************************************************************/	
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("药品信息", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(96, 31, 481, 221);
		panel_1.add(scrollPane_2);
		
		table_1 = new JTable() {
			  public boolean isCellEditable(int row, int column) {
				   if (column == 0) {//让column为2那一列不可用
				    return false;
				   } else
				    return true;
				  }
				 };
		
		final DefaultTableModel m1=new DefaultTableModel();
		m1.addColumn("药品ID");
		m1.addColumn("药品名");
		m1.addColumn("药品单价");
		m1.addColumn("拼音简码");
		m1.addColumn("库存量");
		
		String sql1="select * from Medicine order by meId+0 ";
		ResultSet r1=null;
		r1=DB.excuteSelect(sql1);
		while(r1.next()){
			Vector v=new Vector();
			v.addElement(r1.getString("meId"));
			v.addElement(r1.getString("meName"));
			v.addElement(r1.getDouble("mePrize"));
			v.addElement(r1.getString("mePYJM"));
			v.addElement(r1.getInt("meCount"));
			m1.addRow(v);
		}
		table_1.setModel(m1);	
		scrollPane_2.setViewportView(table_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(48, 293, 87, 21);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(183, 293, 77, 21);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(298, 293, 88, 21);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(425, 293, 77, 21);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label = new JLabel("\u836F\u54C1\u540D\uFF1A");
		label.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label.setBounds(64, 268, 66, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u836F\u54C1\u5355\u4EF7\uFF1A");
		label_1.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_1.setBounds(183, 268, 77, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u62FC\u97F3\u7B80\u7801\uFF1A");
		label_2.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_2.setBounds(309, 268, 77, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E93\u5B58\u91CF\uFF1A");
		label_3.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_3.setBounds(437, 268, 77, 15);
		panel_1.add(label_3);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				q2=textField_5.getText();
				q3=textField_6.getText();
				q4=textField_7.getText();
				q5=textField_8.getText();
				
				Vector v;
				try {
					v = addmedi();
					m1.addRow(v);
					SwingUtilities.updateComponentTreeUI(table_1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
			}
		});
		button.setBounds(555, 292, 93, 23);
		panel_1.add(button);
						
		
		JButton button_1 = new JButton("\u5220\u9664");
		
		button_1.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_1.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object q;
                	q=table_1.getValueAt(table_1.getSelectedRow(), 1);
                	m1.removeRow(selectedRow);  //删除行
                	deletemedi(q);
                }
                SwingUtilities.updateComponentTreeUI(table_1);
            }
        });
				
		
		button_1.setBounds(555, 335, 93, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539");
		
		button_2.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_1.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object p,q,r,s,t;
                	p=table_1.getValueAt(table_1.getSelectedRow(), 0);
                	q=table_1.getValueAt(table_1.getSelectedRow(), 1);
                	r=table_1.getValueAt(table_1.getSelectedRow(), 2);
                	s=table_1.getValueAt(table_1.getSelectedRow(), 3);
                	t=table_1.getValueAt(table_1.getSelectedRow(), 4);
                	updatemedi(p,q,r,s,t);
                }
                SwingUtilities.updateComponentTreeUI(table_1);
            }
        });
		
		button_2.setBounds(555, 379, 93, 23);
		panel_1.add(button_2);
		
		JLabel label_4 = new JLabel("\u8BF7\u76F4\u63A5\u9009\u4E2D\u8981\u5220\u836F\u54C1\u6240\u5728\u884C\uFF1A");
		label_4.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_4.setBounds(143, 340, 199, 15);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("\u4FEE\u6539\u6570\u636E\u5E76\u9009\u4E2D\u8BE5\u884C\uFF1A");
		label_5.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_5.setBounds(159, 384, 183, 15);
		panel_1.add(label_5);
	
		
		/************************************************************************************************************************************/	
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("收费项目信息", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(112, 32, 432, 205);
		panel_2.add(scrollPane_3);
		
		table_2 = new JTable() {
			  public boolean isCellEditable(int row, int column) {
				   if (column == 0) {//让column为2那一列不可用
				    return false;
				   } else
				    return true;
				  }
				 };
		
		final DefaultTableModel m2=new DefaultTableModel();
		m2.addColumn("收费项目ID");
		m2.addColumn("项目名");
		m2.addColumn("项目价格");
		m2.addColumn("拼音简码");
		
		String sql2="select * from FeeItem order by feId+0 ";
		ResultSet r2=null;
		r2=DB.excuteSelect(sql2);
		while(r2.next()){
			Vector v=new Vector();
			v.addElement(r2.getString("feId"));
			v.addElement(r2.getString("feName"));
			v.addElement(r2.getDouble("fePrize"));
			v.addElement(r2.getString("fePYJM"));
			m2.addRow(v);
		}
		table_2.setModel(m2);	
		scrollPane_3.setViewportView(table_2);
		
		textField_9 = new JTextField();
		textField_9.setBounds(112, 274, 66, 21);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(250, 274, 66, 21);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(384, 274, 66, 21);
		panel_2.add(textField_11);
		textField_11.setColumns(10);
		
		JButton button_3 = new JButton("\u6DFB\u52A0");
		
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				q6=textField_9.getText();
				q7=textField_10.getText();
				q8=textField_11.getText();
				
				Vector v;
				try {
					v = addfee();
					m2.addRow(v);
					SwingUtilities.updateComponentTreeUI(table_2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
			}
		});
		

		button_3.setBounds(523, 273, 93, 23);
		panel_2.add(button_3);
			
		
		JButton button_4 = new JButton("\u5220\u9664");
		
		button_4.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_2.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object q;
                	q=table_2.getValueAt(table_2.getSelectedRow(), 1);
                	m2.removeRow(selectedRow);  //删除行
                	deletefe(q);
                }
                SwingUtilities.updateComponentTreeUI(table_2);
            }
        });
		
		button_4.setBounds(523, 321, 93, 23);
		panel_2.add(button_4);
			
		
		JButton button_5 = new JButton("\u4FEE\u6539");
		
		button_5.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_2.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object p,q,r,s;
                	p=table_2.getValueAt(table_2.getSelectedRow(), 0);
                	q=table_2.getValueAt(table_2.getSelectedRow(), 1);
                	r=table_2.getValueAt(table_2.getSelectedRow(), 2);
                	s=table_2.getValueAt(table_2.getSelectedRow(), 3);
                	updatefe(p,q,r,s);
                }
                SwingUtilities.updateComponentTreeUI(table_2);
            }
        });
		
		button_5.setBounds(523, 365, 93, 23);
		panel_2.add(button_5);
		
	
		JLabel label_6 = new JLabel("\u9879\u76EE\u540D\uFF1A");
		label_6.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_6.setBounds(112, 249, 76, 15);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("\u9879\u76EE\u4EF7\u683C\uFF1A");
		label_7.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_7.setBounds(250, 249, 76, 15);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("\u62FC\u97F3\u7B80\u7801\uFF1A");
		label_8.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_8.setBounds(384, 249, 76, 15);
		panel_2.add(label_8);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BF7\u76F4\u63A5\u9009\u4E2D\u8981\u5220\u9879\u76EE\u6240\u5728\u884C\uFF1A");
		lblNewLabel_3.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(176, 325, 197, 15);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u4FEE\u6539\u6570\u636E\u5E76\u9009\u4E2D\u8BE5\u884C\uFF1A");
		lblNewLabel_4.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(176, 369, 182, 15);
		panel_2.add(lblNewLabel_4);
		
		/***********************************************************医生账号*************************************************************************/	
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("医生账号", null, panel_3, null);
		panel_3.setLayout(null);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(57, 27, 569, 204);
		panel_3.add(scrollPane_4);
		
		table_3 = new JTable() {
			  public boolean isCellEditable(int row, int column) {
				   if (column == 0||column == 5) {//让column为2那一列不可用
				    return false;
				   } else
				    return true;
				  }
				 };
		
		final DefaultTableModel m3=new DefaultTableModel();
		m3.addColumn("医生Id");
		m3.addColumn("密码(6位)");
		m3.addColumn("姓名");
		m3.addColumn("年龄");
		m3.addColumn("性别");
		m3.addColumn("所属科室");
		
		String sql3="select dId,password,name,age,gender,dpmName from Doctor,Account,Department where Doctor.dId=Account.id and Department.dpmId=Doctor.dpmId order by dId+0 ";
		ResultSet r3=null;
		r3=DB.excuteSelect(sql3);
		while(r3.next()){
			Vector v=new Vector();
			v.addElement(r3.getString("dId"));
			v.addElement(r3.getString("password"));
			v.addElement(r3.getString("name"));
			v.addElement(r3.getInt("age"));
			v.addElement(r3.getString("gender"));
			v.addElement(r3.getString("dpmName"));
			m3.addRow(v);
			
		}
		

		
		table_3.setModel(m3);	
		scrollPane_4.setViewportView(table_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(57, 266, 76, 21);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 266, 76, 21);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(255, 266, 76, 21);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(347, 266, 81, 21);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {                  
            public void itemStateChanged(ItemEvent event) {  
            
			if (event.getStateChange()==ItemEvent.SELECTED)
                     z = event.getItem();  
            }
        });
		String searchdpmname="select dpmName from Department order by dpmId+0";
		ResultSet dd;
		dd=DB.excuteSelect(searchdpmname);
		while(dd.next()){
			comboBox.addItem(dd.getString("dpmName"));}
		comboBox.setBounds(467, 266, 93, 21);
		panel_3.add(comboBox);
		
		
		JButton btnNewButton_3 = new JButton("\u6DFB\u52A0");
		
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				q9=textField_1.getText();
				q10=textField_2.getText();
				q11=textField_3.getText();
				q12=textField_4.getText();
				
				Vector v;
				try {
					int a=maxdoc();
					v = adddoctor(a);
					m3.addRow(v);
					SwingUtilities.updateComponentTreeUI(table_3);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		
		
		btnNewButton_3.setBounds(570, 265, 93, 23);
		panel_3.add(btnNewButton_3);
		
		JLabel label_9 = new JLabel("\u5BC6\u7801\uFF1A");
		label_9.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_9.setBounds(67, 241, 66, 15);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("\u59D3\u540D\uFF1A");
		label_10.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_10.setBounds(169, 241, 66, 15);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("\u5E74\u9F84\uFF1A");
		label_11.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_11.setBounds(268, 241, 69, 15);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("\u6027\u522B\uFF1A");
		label_12.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_12.setBounds(366, 241, 70, 15);
		panel_3.add(label_12);
		
		JLabel label_13 = new JLabel("\u6240\u5C5E\u79D1\u5BA4\uFF1A");
		label_13.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_13.setBounds(467, 241, 81, 15);
		panel_3.add(label_13);
		
		JButton button_6 = new JButton("\u5220\u9664");
		
		button_6.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_3.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object q;
                	q=table_3.getValueAt(table_3.getSelectedRow(), 2);
                	System.out.println(q);
                	m3.removeRow(selectedRow);  //删除行
                	try {
						deletedoc(q);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                SwingUtilities.updateComponentTreeUI(table_3);
            }
        });
		
		button_6.setBounds(570, 317, 93, 23);
		panel_3.add(button_6);
		
		final JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(428, 368, 21, 23);
		panel_3.add(radioButton);
		
		
		

		
		JButton button_7 = new JButton("\u4FEE\u6539");
		
		button_7.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_3.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object p,q,r,s,t,u;
                	p=table_3.getValueAt(table_3.getSelectedRow(), 0);
                	q=table_3.getValueAt(table_3.getSelectedRow(), 1);
                	r=table_3.getValueAt(table_3.getSelectedRow(), 2);
                	s=table_3.getValueAt(table_3.getSelectedRow(), 3);
                	t=table_3.getValueAt(table_3.getSelectedRow(), 4);
                	if (radioButton.isSelected())
                	u=z;
                	else u=table_3.getValueAt(table_3.getSelectedRow(), 5);
                	table_3.setValueAt(u,table_3.getSelectedRow(),5);
                	try {
						updatedoc(p,q,r,s,t,u);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                SwingUtilities.updateComponentTreeUI(table_3);
                
            }
        });
		
		button_7.setBounds(570, 367, 93, 23);
		panel_3.add(button_7);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {                  
            public void itemStateChanged(ItemEvent event) {  
            
            	
			if (event.getStateChange()==ItemEvent.SELECTED)
                     z = event.getItem();
            }
        });
		String searchdpmna="select dpmName from Department order by dpmId+0";
		ResultSet ddd;
		ddd=DB.excuteSelect(searchdpmna);
		while(ddd.next()){
			comboBox_1.addItem(ddd.getString("dpmName"));}
		
		comboBox_1.setBounds(455, 368, 93, 21);
		panel_3.add(comboBox_1);
		
		
		JLabel lblNewLabel_5 = new JLabel("\u8BF7\u76F4\u63A5\u9009\u4E2D\u8981\u5220\u533B\u751F\u6240\u5728\u884C\uFF1A");
		lblNewLabel_5.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(204, 321, 201, 15);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u4FEE\u6539\u6570\u636E\u5E76\u9009\u4E2D\u8BE5\u884C\uFF1A");
		lblNewLabel_6.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(204, 372, 185, 15);
		panel_3.add(lblNewLabel_6);
		

		

		
		
		/*****************************************************收费人员账号*******************************************************************************/	
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("收费人员账号", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(102, 33, 465, 191);
		panel_4.add(scrollPane_5);
		
		table_4 = new JTable() {
			  public boolean isCellEditable(int row, int column) {
				   if (column == 0) {//让column为2那一列不可用
				    return false;
				   } else
				    return true;
				  }
				 };
		
		final DefaultTableModel m4=new DefaultTableModel();
		m4.addColumn("收费人员Id");
		m4.addColumn("密码(6位)");
		m4.addColumn("姓名");
		m4.addColumn("年龄");
		m4.addColumn("性别");
		
		String sql4="select Cashier.id,password,name,age,gender from Cashier,Account where Cashier.id=Account.id order by Cashier.id+0 ";
		ResultSet r4=null;
		r4=DB.excuteSelect(sql4);
		while(r4.next()){
			Vector v=new Vector();
			v.addElement(r4.getString("id"));
			v.addElement(r4.getString("password"));
			v.addElement(r4.getString("name"));
			v.addElement(r4.getInt("age"));
			v.addElement(r4.getString("gender"));
			m4.addRow(v);
		}
		table_4.setModel(m4);	
		scrollPane_5.setViewportView(table_4);
		
		textField_12 = new JTextField();
		textField_12.setBounds(91, 262, 77, 21);
		panel_4.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(216, 262, 77, 21);
		panel_4.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(345, 262, 77, 21);
		panel_4.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(457, 262, 83, 21);
		panel_4.add(textField_15);
		textField_15.setColumns(10);
		
		JButton button_8 = new JButton("\u6DFB\u52A0");
		
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				q13=textField_12.getText();
				q14=textField_13.getText();
				q15=textField_14.getText();
				q16=textField_15.getText();
				
				Vector v;
				try {
					int a=maxcash();
					v = addcash(a);
					m4.addRow(v);
					SwingUtilities.updateComponentTreeUI(table_4);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
			}
		});
		
		button_8.setBounds(569, 261, 93, 23);
		panel_4.add(button_8);
		
		JLabel label_14 = new JLabel("\u5BC6\u7801\uFF1A");
		label_14.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_14.setBounds(102, 237, 66, 15);
		panel_4.add(label_14);
		
		JLabel label_15 = new JLabel("\u59D3\u540D\uFF1A");
		label_15.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_15.setBounds(227, 237, 66, 15);
		panel_4.add(label_15);
		
		JLabel label_16 = new JLabel("\u5E74\u9F84\uFF1A");
		label_16.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_16.setBounds(353, 237, 69, 15);
		panel_4.add(label_16);
		
		JLabel label_17 = new JLabel("\u6027\u522B\uFF1A");
		label_17.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_17.setBounds(470, 237, 70, 15);
		panel_4.add(label_17);
		
		JButton button_9 = new JButton("\u5220\u9664");
		
		button_9.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_4.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object q;
                	q=table_4.getValueAt(table_4.getSelectedRow(), 2);
                	System.out.println(q);
                	m4.removeRow(selectedRow);  //删除行
                	try {
						deletecash(q);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                SwingUtilities.updateComponentTreeUI(table_4);
            }
        });
		
		button_9.setBounds(569, 316, 93, 23);
		panel_4.add(button_9);
		
		JButton button_10 = new JButton("\u4FEE\u6539");
		
		button_10.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_4.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object p,q,r,s,t;
                	p=table_4.getValueAt(table_4.getSelectedRow(), 0);
                	q=table_4.getValueAt(table_4.getSelectedRow(), 1);
                	r=table_4.getValueAt(table_4.getSelectedRow(), 2);
                	s=table_4.getValueAt(table_4.getSelectedRow(), 3);
                	t=table_4.getValueAt(table_4.getSelectedRow(), 4);
						updatecash(p,q,r,s,t);
                }
                SwingUtilities.updateComponentTreeUI(table_4);
            }
        });
		
		button_10.setBounds(569, 367, 93, 23);
		panel_4.add(button_10);
		
		JLabel label_18 = new JLabel("\u8BF7\u76F4\u63A5\u9009\u4E2D\u8981\u5220\u6536\u8D39\u4EBA\u5458\u6240\u5728\u884C\uFF1A");
		label_18.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_18.setBounds(148, 321, 252, 15);
		panel_4.add(label_18);
		
		JLabel label_19 = new JLabel("\u4FEE\u6539\u6570\u636E\u5E76\u9009\u4E2D\u8BE5\u884C\uFF1A");
		label_19.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_19.setBounds(148, 372, 185, 15);
		panel_4.add(label_19);
		

		
		/*******************************************************药师账号*****************************************************************************/	
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("药师账号", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(112, 29, 449, 196);
		panel_5.add(scrollPane_6);
		
		table_5 = new JTable() {
			  public boolean isCellEditable(int row, int column) {
				   if (column == 0) {//让column为2那一列不可用
				    return false;
				   } else
				    return true;
				  }
				 };
		
		final DefaultTableModel m5=new DefaultTableModel();
		m5.addColumn("药师Id");
		m5.addColumn("密码(6位)");
		m5.addColumn("姓名");
		m5.addColumn("年龄");
		m5.addColumn("性别");
		
		String sql5="select Apothecary.id,password,name,age,gender from Apothecary,Account where Apothecary.id=Account.id order by Apothecary.id+0 ";
		ResultSet r5=null;
		r5=DB.excuteSelect(sql5);
		while(r5.next()){
			Vector v=new Vector();
			v.addElement(r5.getString("id"));
			v.addElement(r5.getString("password"));
			v.addElement(r5.getString("name"));
			v.addElement(r5.getInt("age"));
			v.addElement(r5.getString("gender"));
			m5.addRow(v);
		}
		table_5.setModel(m5);	
		scrollPane_6.setViewportView(table_5);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(103, 262, 77, 21);
		panel_5.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(216, 262, 77, 21);
		panel_5.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(333, 262, 77, 21);
		panel_5.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(454, 262, 83, 21);
		panel_5.add(textField_19);
		
		JButton button_11 = new JButton("\u6DFB\u52A0");
		
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				q17=textField_16.getText();
				q18=textField_17.getText();
				q19=textField_18.getText();
				q20=textField_19.getText();
				
				Vector v;
				try {
					int a=maxapo();
					v = addapo(a);
					m5.addRow(v);
					SwingUtilities.updateComponentTreeUI(table_5);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textField_16.setText("");
				textField_17.setText("");
				textField_18.setText("");
				textField_19.setText("");
			}
		});
		
		button_11.setBounds(569, 261, 93, 23);
		panel_5.add(button_11);
		
		JLabel label_20 = new JLabel("\u5BC6\u7801\uFF1A");
		label_20.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_20.setBounds(112, 237, 66, 15);
		panel_5.add(label_20);
		
		JLabel label_21 = new JLabel("\u59D3\u540D\uFF1A");
		label_21.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_21.setBounds(227, 237, 66, 15);
		panel_5.add(label_21);
		
		JLabel label_22 = new JLabel("\u5E74\u9F84\uFF1A");
		label_22.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_22.setBounds(349, 237, 69, 15);
		panel_5.add(label_22);
		
		JLabel label_23 = new JLabel("\u6027\u522B\uFF1A");
		label_23.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_23.setBounds(466, 237, 70, 15);
		panel_5.add(label_23);
		
		JButton button_12 = new JButton("\u5220\u9664");
		
		button_12.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_5.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object q;
                	q=table_5.getValueAt(table_5.getSelectedRow(), 2);
                	m5.removeRow(selectedRow);  //删除行
                	try {
						deleteapo(q);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                SwingUtilities.updateComponentTreeUI(table_5);
            }
        });
		
		button_12.setBounds(569, 318, 93, 23);
		panel_5.add(button_12);
		
		JButton button_13 = new JButton("\u4FEE\u6539");
		
		button_13.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_5.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object p,q,r,s,t;
                	p=table_5.getValueAt(table_5.getSelectedRow(), 0);
                	q=table_5.getValueAt(table_5.getSelectedRow(), 1);
                	r=table_5.getValueAt(table_5.getSelectedRow(), 2);
                	s=table_5.getValueAt(table_5.getSelectedRow(), 3);
                	t=table_5.getValueAt(table_5.getSelectedRow(), 4);
						updateapo(p,q,r,s,t);
                }
                SwingUtilities.updateComponentTreeUI(table_5);
            }
        });
		
		button_13.setBounds(569, 368, 93, 23);
		panel_5.add(button_13);
		
		JLabel label_24 = new JLabel("\u8BF7\u76F4\u63A5\u9009\u4E2D\u8981\u5220\u836F\u5E08\u6240\u5728\u884C\uFF1A");
		label_24.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_24.setBounds(188, 322, 252, 15);
		panel_5.add(label_24);
		
		JLabel label_25 = new JLabel("\u4FEE\u6539\u6570\u636E\u5E76\u9009\u4E2D\u8BE5\u884C\uFF1A");
		label_25.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_25.setBounds(188, 372, 185, 15);
		panel_5.add(label_25);
		
		/*******************************************************院长账号*****************************************************************************/	
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("院长账号", null, panel_6, null);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(81, 28, 501, 196);
		panel_6.add(scrollPane_7);
		
		table_6 = new JTable() {
			  public boolean isCellEditable(int row, int column) {
				   if (column == 0) {//让column为2那一列不可用
				    return false;
				   } else
				    return true;
				  }
				 };
		
		final DefaultTableModel m6=new DefaultTableModel();
		m6.addColumn("院长Id");
		m6.addColumn("密码(6位)");
		m6.addColumn("姓名");
		m6.addColumn("年龄");
		m6.addColumn("性别");
		
		String sql6="select Dean.id,password,name,age,gender from Dean,Account where Dean.id=Account.id order by Dean.id+0 ";
		ResultSet r6=null;
		r6=DB.excuteSelect(sql6);
		while(r6.next()){
			Vector v=new Vector();
			v.addElement(r6.getString("id"));
			v.addElement(r6.getString("password"));
			v.addElement(r6.getString("name"));
			v.addElement(r6.getInt("age"));
			v.addElement(r6.getString("gender"));
			m6.addRow(v);
		}
		table_6.setModel(m6);	
		scrollPane_7.setViewportView(table_6);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(69, 262, 77, 21);
		panel_6.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(201, 262, 77, 21);
		panel_6.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(327, 262, 77, 21);
		panel_6.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(456, 262, 83, 21);
		panel_6.add(textField_23);
		
		JButton button_14 = new JButton("\u6DFB\u52A0");
		
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				q21=textField_20.getText();
				q22=textField_21.getText();
				q23=textField_22.getText();
				q24=textField_23.getText();
				
				Vector v;
				try {
					int a=maxdean();
					v = adddean(a);
					m6.addRow(v);
					SwingUtilities.updateComponentTreeUI(table_6);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textField_20.setText("");
				textField_21.setText("");
				textField_22.setText("");
				textField_23.setText("");
			}
		});
		
		button_14.setBounds(569, 261, 93, 23);
		panel_6.add(button_14);
		
		JLabel label_26 = new JLabel("\u5BC6\u7801\uFF1A");
		label_26.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_26.setBounds(81, 237, 66, 15);
		panel_6.add(label_26);
		
		JLabel label_27 = new JLabel("\u59D3\u540D\uFF1A");
		label_27.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_27.setBounds(212, 237, 66, 15);
		panel_6.add(label_27);
		
		JLabel label_28 = new JLabel("\u5E74\u9F84\uFF1A");
		label_28.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_28.setBounds(335, 237, 69, 15);
		panel_6.add(label_28);
		
		JLabel label_29 = new JLabel("\u6027\u522B\uFF1A");
		label_29.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_29.setBounds(456, 237, 70, 15);
		panel_6.add(label_29);
		
		JButton button_15 = new JButton("\u5220\u9664");
		
		button_15.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_6.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object q;
                	q=table_6.getValueAt(table_6.getSelectedRow(), 2);
                	m6.removeRow(selectedRow);  //删除行
                	try {
						deletedean(q);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                SwingUtilities.updateComponentTreeUI(table_6);
            }
        });
		
		button_15.setBounds(569, 315, 93, 23);
		panel_6.add(button_15);
		
		JButton button_16 = new JButton("\u4FEE\u6539");
		
		button_16.addActionListener(new ActionListener(){//添加事
            public void actionPerformed(ActionEvent e){
                int selectedRow = table_6.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                	Object p,q,r,s,t;
                	p=table_6.getValueAt(table_6.getSelectedRow(), 0);
                	q=table_6.getValueAt(table_6.getSelectedRow(), 1);
                	r=table_6.getValueAt(table_6.getSelectedRow(), 2);
                	s=table_6.getValueAt(table_6.getSelectedRow(), 3);
                	t=table_6.getValueAt(table_6.getSelectedRow(), 4);
						updatedean(p,q,r,s,t);
                }
                SwingUtilities.updateComponentTreeUI(table_6);
            }
        });
		
		button_16.setBounds(569, 367, 93, 23);
		panel_6.add(button_16);
		
		JLabel label_30 = new JLabel("\u8BF7\u76F4\u63A5\u9009\u4E2D\u8981\u5220\u9662\u957F\u6240\u5728\u884C\uFF1A");
		label_30.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_30.setBounds(170, 319, 252, 15);
		panel_6.add(label_30);
		
		JLabel label_31 = new JLabel("\u4FEE\u6539\u6570\u636E\u5E76\u9009\u4E2D\u8BE5\u884C\uFF1A");
		label_31.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_31.setBounds(170, 372, 185, 15);
		panel_6.add(label_31);	
		
	}
	
	public int maxdoc() throws SQLException{
		String count="select top 1 dId from Doctor order by dId+0 desc";
		ResultSet num=null;
		num=DB.excuteSelect(count);
		int a=0;
		if(num.next())
			a=num.getInt("dId");
		a=a+1;
		return a;
	}
	
	public int maxcash() throws SQLException{
		String count="select top 1 id from Cashier order by id+0 desc";
		ResultSet num=null;
		num=DB.excuteSelect(count);
		int a=0;
		if(num.next())
			a=num.getInt("id");
		a=a+1;
		return a;
	}
	
	public int maxapo() throws SQLException{
		String count="select top 1 id from Apothecary order by id+0 desc";
		ResultSet num=null;
		num=DB.excuteSelect(count);
		int a=0;
		if(num.next())
			a=num.getInt("id");
		a=a+1;
		return a;
	}
	
	public int maxdean() throws SQLException{
		String count="select top 1 id from Dean order by id+0 desc";
		ResultSet num=null;
		num=DB.excuteSelect(count);
		int a=0;
		if(num.next())
			a=num.getInt("id");
		a=a+1;
		return a;
	}
	
	public Vector adddepart() throws SQLException{
		String sql11="select top 1 dpmId from Department order by dpmId+0 desc";
		ResultSet r11=null;
		r11=DB.excuteSelect(sql11);
		int a=0;
		if(r11.next())
			a=r11.getInt("dpmId");
		a=a+1;
		String sql12="insert into Department values('"+a+"','"+q1+"')";
		boolean r12;
		r12=DB.excuteIUD(sql12);
		Vector v=new Vector();
		v.addElement(a);
		v.addElement(q1);
		return v;
	}
	
	public String searchdpmid(Object a) throws SQLException{
		String searchdpmid="select dpmId from Department where dpmName='"+a+"'";
		ResultSet dpmid=null;
		dpmid=DB.excuteSelect(searchdpmid);
		String i=null;
		while(dpmid.next()){
			i=dpmid.getString("dpmId");
		}
		return i;
	}
	
	
	public void setdoctor(Object a) throws SQLException{
		String i=searchdpmid(a);
		String setdoc="update Doctor set dpmId='0' where dpmId='"+i+"'";
		boolean r3;
		r3=DB.excuteIUD(setdoc);
	}
	
	public void deletedepart(Object q) throws SQLException{
		setdoctor(q);
		String sql22="delete from Department where dpmName='"+q+"'";
		boolean r2;
		r2=DB.excuteIUD(sql22);
	}
	
	public void updatedepart(Object p,Object q){
		String sql3="Update Department set dpmName='"+q+"' where dpmId='"+p+"'";
		boolean r3;
		r3=DB.excuteIUD(sql3);
	}
	
	public Vector addmedi() throws SQLException{
		String sql41="select top 1 meId from Medicine order by meId+0 desc";
		ResultSet r41=null;
		r41=DB.excuteSelect(sql41);
		int a=0;
		if(r41.next())
			a=r41.getInt("meId");
		a=a+1;
		String sql42="insert into Medicine values('"+a+"','"+q2+"','"+q3+"','"+q4+"','"+q5+"')";
		boolean r42;
		r42=DB.excuteIUD(sql42);
		Vector v=new Vector();
		v.addElement(a);
		v.addElement(q2);
		v.addElement(q3);
		v.addElement(q4);
		v.addElement(q5);
		return v;
	}
	
	public void deletemedi(Object q){
		String sql5="delete from Medicine where meName='"+q+"'";
		boolean r5;
		r5=DB.excuteIUD(sql5);
	}
	
	public void updatemedi(Object p,Object q,Object r,Object s,Object t){
		String sql6="Update Medicine set meName='"+q+"',mePrize='"+r+"',mePYJM='"+s+"',meCount='"+t+"' where meId='"+p+"'";
		boolean r6;
		r6=DB.excuteIUD(sql6);
	}
	
	public Vector addfee() throws SQLException{
		String sql71="select top 1 feId from FeeItem order by feId+0 desc";
		ResultSet r71=null;
		r71=DB.excuteSelect(sql71);
		int a=0;
		if(r71.next())
			a=r71.getInt("feId");
		a=a+1;
		String sql72="insert into FeeItem values('"+a+"','"+q6+"','"+q7+"','"+q8+"')";
		boolean r72;
		r72=DB.excuteIUD(sql72);
		Vector v=new Vector();
		v.addElement(a);
		v.addElement(q6);
		v.addElement(q7);
		v.addElement(q8);
		return v;
	}
	
	public void deletefe(Object q){
		String sql8="delete from FeeItem where feName='"+q+"'";
		boolean r8;
		r8=DB.excuteIUD(sql8);
	}
	
	public void updatefe(Object p,Object q,Object r,Object s){
		String sql9="Update FeeItem set feName='"+q+"',fePrize='"+r+"',fePYJM='"+s+"' where feId='"+p+"'";
		boolean r9;
		r9=DB.excuteIUD(sql9);
	}
	
	public void refreshcombo(){
		comboBox.removeAllItems();
		comboBox_1.removeAllItems();
		String searchdpmname="select dpmName from Department order by dpmId+0";
		ResultSet dd;
		dd=DB.excuteSelect(searchdpmname);
		try {
			while(dd.next()){
				comboBox.addItem(dd.getString("dpmName"));
				comboBox_1.addItem(dd.getString("dpmName"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int searchcount() throws SQLException{
		String count="select top 1 id from Account order by id+0 desc";
		ResultSet num=null;
		num=DB.excuteSelect(count);
		int a=0;
		if(num.next())
			a=num.getInt("id");
		a=a+1;
		return a;
	}
	
	public void addac(int a,Object b,int c){
		String addac="insert into Account values('"+a+"','"+b+"','"+c+"')";
		boolean ad;
		ad=DB.excuteIUD(addac);
	}
	

	
	public Vector adddoctor(int a) throws SQLException{
		String searchdpmname="select dpmId from Department where dpmName='"+z+"'";
		ResultSet dpmid=null;
		dpmid=DB.excuteSelect(searchdpmname);
		String i=null;
		while(dpmid.next()){
			i=dpmid.getString("dpmId");
		}
		addac(a,q9,1);
		String adddoc="insert into Doctor values('"+a+"','"+q10+"','"+q11+"','"+q12+"','"+i+"')";
		boolean ad;
		ad=DB.excuteIUD(adddoc);
		Vector v=new Vector();
		v.addElement(a);
		v.addElement(q9);
		v.addElement(q10);
		v.addElement(q11);
		v.addElement(q12);
		v.addElement(z);
		return v;
	}
	
	public void deleteac(int i){
		String deleacc="delete from Account where id='"+i+"'";
		boolean deac;
		deac=DB.excuteIUD(deleacc);
	}
	
	public void deletedoc(Object q) throws SQLException{
		String getid="select dId from Doctor where name='"+q+"'";
		ResultSet accid=null;
		accid=DB.excuteSelect(getid);
		int i=0;
		while(accid.next()){
			i=accid.getInt("dId");
		}
		String deledoc="delete from Doctor where dId='"+i+"'";
		boolean dedoc;
		dedoc=DB.excuteIUD(deledoc);
		deleteac(i);
	}
	
	public void updateac(Object a,Object b){
		String upac="update Account set password='"+a+"' where id='"+b+"'";
		boolean updateac;
		updateac=DB.excuteIUD(upac);
	}
	

	
	public void updatedoc(Object a,Object b,Object c,Object d,Object e,Object f) throws SQLException{
		updateac(b,a);
		Object ff=searchdpmid(f);	
		String updoc="update Doctor set name='"+c+"',age='"+d+"',gender='"+e+"',dpmId='"+ff+"' where dId='"+a+"'";
		boolean updatedc;
		updatedc=DB.excuteIUD(updoc);
	}
	
	public Vector addcash(int a){
		addac(a,q13,2);
		String addcash="insert into Cashier values('"+a+"','"+q14+"','"+q15+"','"+q16+"')";
		boolean ad;
		ad=DB.excuteIUD(addcash);
		Vector v=new Vector();
		v.addElement(a);
		v.addElement(q13);
		v.addElement(q14);
		v.addElement(q15);
		v.addElement(q16);
		return v;
	}
	
	public void deletecash(Object q) throws SQLException{
		String getid="select id from Cashier where name='"+q+"'";
		ResultSet accid=null;
		accid=DB.excuteSelect(getid);
		int i=0;
		while(accid.next()){
			i=accid.getInt("id");
		}
		String delecash="delete from Cashier where id='"+i+"'";
		boolean deca;
		deca=DB.excuteIUD(delecash);
		deleteac(i);
	}
	
	public void updatecash(Object a,Object b,Object c,Object d,Object e){
		updateac(b,a);
		String upcash="update Cashier set name='"+c+"',age='"+d+"',gender='"+e+"' where id='"+a+"'";
		boolean updateca;
		updateca=DB.excuteIUD(upcash);
	}
	
	public Vector addapo(int a){
		addac(a,q17,3);
		String addapo="insert into Apothecary values('"+a+"','"+q18+"','"+q19+"','"+q20+"')";
		boolean ad;
		ad=DB.excuteIUD(addapo);
		Vector v=new Vector();
		v.addElement(a);
		v.addElement(q17);
		v.addElement(q18);
		v.addElement(q19);
		v.addElement(q20);
		return v;
	}
	
	public void deleteapo(Object q) throws SQLException{
		String getid="select id from Apothecary where name='"+q+"'";
		ResultSet accid=null;
		accid=DB.excuteSelect(getid);
		int i=0;
		while(accid.next()){
			i=accid.getInt("id");
		}
		String deleapo="delete from Apothecary where id='"+i+"'";
		boolean deapo;
		deapo=DB.excuteIUD(deleapo);
		deleteac(i);	
	}
	
	public void updateapo(Object a,Object b,Object c,Object d,Object e){
		updateac(b,a);
		String upapo="update Apothecary set name='"+c+"',age='"+d+"',gender='"+e+"' where id='"+a+"'";
		boolean updaapo;
		updaapo=DB.excuteIUD(upapo);
	}
	
	public Vector adddean(int a){
		addac(a,q21,4);
		String adddean="insert into Dean values('"+a+"','"+q22+"','"+q23+"','"+q24+"')";
		boolean ad;
		ad=DB.excuteIUD(adddean);
		Vector v=new Vector();
		v.addElement(a);
		v.addElement(q21);
		v.addElement(q22);
		v.addElement(q23);
		v.addElement(q24);
		return v;
	}
	
	public void deletedean(Object q) throws SQLException{
		String getid="select id from Dean where name='"+q+"'";
		ResultSet accid=null;
		accid=DB.excuteSelect(getid);
		int i=0;
		while(accid.next()){
			i=accid.getInt("id");
		}
		String deledean="delete from Dean where id='"+i+"'";
		boolean dedean;
		dedean=DB.excuteIUD(deledean);
		deleteac(i);	
	}
	
	public void updatedean(Object a,Object b,Object c,Object d,Object e){
		updateac(b,a);
		String updean="update Dean set name='"+c+"',age='"+d+"',gender='"+e+"' where id='"+a+"'";
		boolean updadean;
		updadean=DB.excuteIUD(updean);
	}
	
	public void refreshtable3() throws SQLException{
		table_3.clearSelection();
		DefaultTableModel m3=new DefaultTableModel();
		m3.addColumn("医生Id");
		m3.addColumn("密码(6位)");
		m3.addColumn("姓名");
		m3.addColumn("年龄");
		m3.addColumn("性别");
		m3.addColumn("所属科室");
		String sql3="select dId,password,name,age,gender,dpmName from Doctor,Account,Department where Doctor.dId=Account.id and Department.dpmId=Doctor.dpmId order by dId+0 ";
		ResultSet r3=null;
		r3=DB.excuteSelect(sql3);
		while(r3.next()){
			Vector v=new Vector();
			v.addElement(r3.getString("dId"));
			v.addElement(r3.getString("password"));
			v.addElement(r3.getString("name"));
			v.addElement(r3.getInt("age"));
			v.addElement(r3.getString("gender"));
			v.addElement(r3.getString("dpmName"));
			m3.addRow(v);
			table_3.setModel(m3);		
		}
	}
}
