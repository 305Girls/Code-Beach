package main;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;





public class CureP extends JFrame implements Runnable{

	Patient patient=null;
	private JPanel contentPane;
	private JTextField mePYJM;
	private JTextField numText;
	private JTextField itemPYJM;
	private JTable table;
	private JTable table_1;
	static int exi=JOptionPane.CANCEL_OPTION;//确认就诊

	/**
	 * Launch the application.
	 */
	public void run() 
	{
		try {
			System.out.println(Client_Doctor.patient.getName());
			CureP frame = new CureP(Client_Doctor.patient);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
	}
	}

	/**
	 * Create the frame.
	 */
	public CureP(final Patient patient) {
		setTitle("\u5F00\u5904\u65B9");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 890, 877);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel label_3 = new JLabel("\u5C31\u8BCA\u75C5\u4EBA\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 2;
		contentPane.add(label_3, gbc_label_3);
		
		JLabel lblNewLabel = new JLabel("无");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		if(patient!=null)
			lblNewLabel.setText(patient.getName());
		else
			lblNewLabel.setText("无");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 4;
		contentPane.add(comboBox, gbc_comboBox);
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 6;
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 11;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		//设置列宽
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					final DefaultTableModel m1=new DefaultTableModel();
					final DefaultTableModel m2=new DefaultTableModel();
					m1.addColumn("名称");
					m1.addColumn("数量");
					m2.addColumn("名称");
					if(!mePYJM.getText().equals(""))
					{
						Vector v1=new Vector();//放药品处方
						v1.addElement(comboBox.getSelectedItem());
						if(numText.getText().equals(""))
							v1.addElement("1");
						else
							v1.addElement(numText.getText());
					    m1.addRow(v1);
					}
					if(!itemPYJM.getText().equals(""))
					{
						Vector v2=new Vector();//放项目处方
						v2.addElement(comboBox_1.getSelectedItem());
						m2.addRow(v2);
					}
					table.setModel(m1);
					table_1.setModel(m2);
				/*设置列名大小
			    int columncount = table.getColumnCount();
	            for (int i = 1; i < columncount; i++) {
	                table.getColumnModel().getColumn(i).setPreferredWidth(1000);
	            }*/
			}
		});
		
		JLabel label = new JLabel("\u836F\u54C1\u540D\u62FC\u97F3\u7B80\u7801");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 3;
		contentPane.add(label, gbc_label);
		
		JLabel label_5 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_5.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 3;
		gbc_label_5.gridy = 3;
		contentPane.add(label_5, gbc_label_5);
		
		JLabel label_1 = new JLabel("\u6570\u91CF");
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 3;
		contentPane.add(label_1, gbc_label_1);
		
		
		
		mePYJM = new JTextField();
		mePYJM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
				comboBox.removeAllItems();//移除之前搜索到的所有项
				String sql="select meName from Medicine where mePYJM like '"
						+ "%"+mePYJM.getText()+"%'";
				ResultSet rs=OPDB.excuteSelect(sql);
				while(rs.next())
				{
					comboBox.addItem(rs.getString("meName"));
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mePYJM.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_mePYJM = new GridBagConstraints();
		gbc_mePYJM.insets = new Insets(0, 0, 5, 5);
		gbc_mePYJM.fill = GridBagConstraints.HORIZONTAL;
		gbc_mePYJM.gridx = 1;
		gbc_mePYJM.gridy = 4;
		contentPane.add(mePYJM, gbc_mePYJM);
		mePYJM.setColumns(10);
		
		numText = new JTextField();
		numText.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_numText = new GridBagConstraints();
		gbc_numText.insets = new Insets(0, 0, 5, 0);
		gbc_numText.fill = GridBagConstraints.HORIZONTAL;
		gbc_numText.gridx = 5;
		gbc_numText.gridy = 4;
		contentPane.add(numText, gbc_numText);
		numText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u9879\u76EE");
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 5;
		contentPane.add(label_2, gbc_label_2);
		
		JLabel label_6 = new JLabel("\u9879\u76EE\u540D\u79F0");
		label_6.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 3;
		gbc_label_6.gridy = 5;
		contentPane.add(label_6, gbc_label_6);
		
		
		contentPane.add(comboBox_1, gbc_comboBox_1);
		itemPYJM = new JTextField();
		itemPYJM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
				comboBox_1.removeAllItems();//移除之前搜索到的所有项
				String sql="select feName from FeeItem where fePYJM like '"
						+ "%"+itemPYJM.getText()+"%'";
				ResultSet rs=OPDB.excuteSelect(sql);
				while(rs.next())
				{
					comboBox_1.addItem(rs.getString("FeName"));
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		itemPYJM.setFont(new Font("宋体", Font.PLAIN, 25));
		itemPYJM.setColumns(10);
		GridBagConstraints gbc_itemPYJM = new GridBagConstraints();
		gbc_itemPYJM.insets = new Insets(0, 0, 5, 5);
		gbc_itemPYJM.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemPYJM.gridx = 1;
		gbc_itemPYJM.gridy = 6;
		contentPane.add(itemPYJM, gbc_itemPYJM);
		
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 7;
		contentPane.add(button, gbc_button);
		
		JLabel label_4 = new JLabel("\u5904\u65B9\u4FE1\u606F");
		label_4.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 10;
		contentPane.add(label_4, gbc_label_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 13;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table_1);
		
		
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();//获取选中的行号
				int row2 = table_1.getSelectedRow();
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();//获取defaulttablemodel
				DefaultTableModel model2 = (DefaultTableModel) table_1.getModel();//获取defaulttablemodel
				if(row1!=-1)
					model1.removeRow(row1);//删除某行
				if(row2!=-1)
					model2.removeRow(row2);//删除某行
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 15;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u786E\u8BA4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1=table.getRowCount();
				int row2=table_1.getRowCount();
				Timestamp nowdate = new Timestamp(System.currentTimeMillis());
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();//获取defaulttablemodel
				DefaultTableModel model2 = (DefaultTableModel) table_1.getModel();//获取defaulttablemodel
				exi = JOptionPane.showConfirmDialog (null, "确认开处方？", "友情提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if (exi == JOptionPane.YES_OPTION)
	            {
	            	for(int i=0;i<row1;i++)
					{
							String content1=(String) model1.getValueAt(i,0);
							String content2=(String) model1.getValueAt(i,1);
							OPDB.curePatient(patient, Client_Doctor.doc,content1,Integer.parseInt(content2),null,nowdate);
					}
					for(int i=0;i<row2;i++)
					{
							String content1=(String) model2.getValueAt(i,0);
							OPDB.curePatient(patient, Client_Doctor.doc,null,0,content1,nowdate);
					}
					CureP.this.dispose();
	            }
				
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 25));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 15;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		this.setLocationRelativeTo(null);//窗口居中显示
	}

	Patient getPatient() {
		return patient;
	}

	void setPatient(Patient patient) {
		this.patient = patient;
	}

}
