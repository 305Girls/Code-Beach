import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class ChargePanel extends JPanel {
	Patient p=new Patient();
	
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
	private final JTextField textField = new JTextField(18);
	private final JButton btnNewButton_3 = new JButton("\u786E\u5B9A");
	private final JButton button = new JButton("\u786E\u8BA4\u6536\u8D39");
	private final JButton btnNewButton_4 = new JButton("\u53D6\u6D88");
	private final JLabel lblNewLabel_8 = new JLabel("");
	private final JLabel lblNewLabel_3 = new JLabel("yyyy-MM-dd HH:mm:ss");
	private final JTable table = new JTable();
	private final JTable table_1 = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JComboBox comboBox = new JComboBox();
	private final JLabel lblNewLabel_1 = new JLabel();
	private final JLabel lblNewLabel_2 = new JLabel("");
	private final JLabel lblNewLabel_4 = new JLabel("");
	private final JLabel lblNewLabel_5 = new JLabel("");

	/**
	 * Create the panel.
	 */
	public ChargePanel() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 30, 5, 5);
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel, gbc_lblNewLabel);
		textField.setFont(new Font("等线", Font.PLAIN, 15));
		textField.setColumns(10);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 0;
		btnNewButton_3.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridwidth = 9;
		gbc_lblNewLabel_8.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 2;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		ButtonGroup bg=new ButtonGroup();
		
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 5, 5);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 4;
		gbc_table_1.gridy = 2;
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 2;
		table.setFont(new Font("等线", Font.PLAIN, 15));
		table.setEnabled(false);
		table.setRowHeight(20);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.weighty = 3.0;
		gbc_scrollPane.weightx = 15.0;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		panel.add(scrollPane, gbc_scrollPane);
		scrollPane.add(table, gbc_table);
		scrollPane.setVisible(false);
		
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 10;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.weighty = 3.0;
		gbc_scrollPane_1.weightx = 7.0;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 6;
		gbc_scrollPane_1.gridy = 3;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		table_1.setFont(new Font("等线", Font.PLAIN, 15));
		table_1.setEnabled(false);
		table_1.setRowHeight(20);
		scrollPane_1.add(table_1, gbc_table_1);
		scrollPane_1.setVisible(false);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 7;
		gbc_comboBox.gridy = 0;
		comboBox.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(comboBox, gbc_comboBox);
		comboBox.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		lblNewLabel_4.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		lblNewLabel_5.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 20, 10);
		gbc_button.gridx = 6;
		gbc_button.gridy = 16;
		button.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(button, gbc_button);
		button.setVisible(false);
		
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 20, 5);
		gbc_btnNewButton_4.gridx = 7;
		gbc_btnNewButton_4.gridy = 16;
		btnNewButton_4.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_4.setVisible(false);
		
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 15));
		add(lblNewLabel_3, BorderLayout.NORTH);
		
		Timer t = new Timer();
		t.schedule(new MyTask(), 1000,1000);
		
		
		btnNewButton_3.addActionListener(new ActionListener(){//“确定”
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimeHandel t=new TimeHandel();
		        String date =t.getNowDate(); 
				String id=textField.getText();
				String rex="\\d{18}";
				if(!id.matches(rex))
					JOptionPane.showMessageDialog(null,"请输入18位身份证号 ！");
				else{
					p.setpId(id);
					if(p.check_pId()){
						p.getInfo();
						String[] reid=p.getreid(date);
						if(reid!=null){
							btnNewButton_3.setVisible(false);textField.setEnabled(false);
							lblNewLabel_8.setVisible(true);
							button.setVisible(true);btnNewButton_4.setVisible(true);
							comboBox.setVisible(true);lblNewLabel_1.setVisible(true);
							comboBox.addItem("");
							for(int i=0;i<reid.length;i++)
								comboBox.addItem(reid[i]);
						}
						else 
							JOptionPane.showMessageDialog(null,"对不起！未查到收费信息!");
					}
					else 
						JOptionPane.showMessageDialog(null,"对不起！未找到该病人信息！");
						
				}
			}
		});
		comboBox.addActionListener(new ActionListener(){//选择处方号
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(comboBox.getSelectedIndex()!=-1){
					String reid=comboBox.getSelectedItem().toString();
				if(reid!=""){
					p.setRaprize(0);p.setFaprize(0);
					p.setReId(reid);
					String sql="select dpmName,name from Department,Doctor,PatientHSP where reId='"+reid+"' AND pId='"+p.getpId()+"' AND PatientHSP.dpmId=Department.dpmId AND PatientHSP.dId=Doctor.dId";
					DB db=new DB();
					ResultSet rs=db.excuteSelect(sql);
					try {
						rs.next();
						lblNewLabel_1.setText("病人姓名："+p.getName());
						lblNewLabel_2.setText("就诊科室："+rs.getString("dpmName"));
						lblNewLabel_4.setText("就诊医生："+rs.getString("name"));
						sql="select reTime from recipeMe where reId='"+reid+"'";
						rs=db.excuteSelect(sql);
						if(rs.next()){
							String[] sp=(rs.getString("reTime")).split(" ");
							lblNewLabel_5.setText("开处方时间："+sp[0]);
						}
						else{
							sql="select reTime from recipeFe where reId='"+reid+"'";
							rs=db.excuteSelect(sql);
							if(rs.next()) {
								String[] sp=(rs.getString("reTime")).split(" ");
								lblNewLabel_5.setText("开处方时间："+sp[0]);
							}
						}
						lblNewLabel_1.setVisible(true);lblNewLabel_2.setVisible(true);lblNewLabel_4.setVisible(true);lblNewLabel_5.setVisible(true);
						scrollPane.setVisible(true);scrollPane_1.setVisible(true);
						DefaultTableModel m1=new DefaultTableModel(),m2=new DefaultTableModel();
						m1.addColumn("处方号");m1.addColumn("药品名");m1.addColumn("药品数量");m1.addColumn("单价");
						sql="select meName,meNumber,mePrize from Medicine,recipeMe where reId='"+reid+"' AND Medicine.meId=recipeMe.meId";
						rs=db.excuteSelect(sql);
						while(rs.next()){
							Vector v=new Vector();
							v.addElement(reid);
							v.addElement(rs.getString("meName"));
							v.addElement(rs.getString("meNumber"));
							int n=Integer.parseInt(rs.getString("meNumber"));
							v.addElement(rs.getString("mePrize"));
							float prize=Float.parseFloat(rs.getString("mePrize"));
							m1.addRow(v);
							p.setRaprize(p.getRaprize()+(n*prize));
						}
						table.setModel(m1);scrollPane.setViewportView(table);
						m2.addColumn("处方号");m2.addColumn("项目名");m2.addColumn("单价");
						sql="select feName,fePrize from FeeItem,recipeFe where reId='"+reid+"' AND FeeItem.feId=recipeFe.feId";
						rs=db.excuteSelect(sql);
						while(rs.next()){
							Vector v=new Vector();
							v.addElement(reid);
							v.addElement(rs.getString("feName"));
							v.addElement(rs.getString("fePrize"));
							float prize=Float.parseFloat(rs.getString("fePrize"));
							m2.addRow(v);
							p.setFaprize(p.getFaprize()+prize);
						}
						table_1.setModel(m2);scrollPane_1.setViewportView(table_1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					scrollPane.setVisible(false);scrollPane_1.setVisible(false);
					lblNewLabel_1.setVisible(false);lblNewLabel_2.setVisible(false);lblNewLabel_4.setVisible(false);lblNewLabel_5.setVisible(false);
				}
			}
			}
		});
        button.addActionListener(new ActionListener(){//“确认收费”
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = { "是", "否" }; 
				int i=JOptionPane.showOptionDialog(null, "确认收费？", "", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				if(i==JOptionPane.YES_OPTION){
					DBhandel a=new DBhandel();
					String sql1=null,sql2=null;
					if(p.getRaprize()!=0)
						sql1="update PatientHSP set isTake=2 where pId='"+p.getpId()+"' AND reId='"+p.getReId()+"'";
					if(p.getFaprize()!=0)
						sql2="update PatientHSP set isDo=2 where pId='"+p.getpId()+"' AND reId='"+p.getReId()+"'";
					if(sql1!=null&&sql2!=null&&a.updateItem(sql1)&&a.updateItem(sql2)){
						JOptionPane.showMessageDialog(null, "收费成功！"
					                   +"\n药品费用共计"+p.getRaprize()+"元"
					                   +"\n项目费用共计"+p.getFaprize()+"元"
					                   +"\n费用总计："+(p.getRaprize()+p.getFaprize())+"元");
						btnNewButton_3.setVisible(true);textField.setEnabled(true);textField.setText("");
						lblNewLabel_8.setVisible(false);
						button.setVisible(false);btnNewButton_4.setVisible(false);
						comboBox.setVisible(false);comboBox.removeAllItems();
						lblNewLabel_1.setVisible(false);
						scrollPane.setVisible(false);table.removeAll();
						scrollPane_1.setVisible(false);table_1.removeAll();
						lblNewLabel_1.setVisible(false);lblNewLabel_2.setVisible(false);lblNewLabel_4.setVisible(false);lblNewLabel_5.setVisible(false);
						p.clear();
					}
					else if(sql1!=null&&a.updateItem(sql1)){
							JOptionPane.showMessageDialog(null, "收费成功！"
						                   +"\n药品费用共计"+p.getRaprize()+"元"
						                   +"\n项目费用共计"+p.getFaprize()+"元"
						                   +"\n费用总计："+(p.getRaprize()+p.getFaprize())+"元");
							btnNewButton_3.setVisible(true);textField.setEnabled(true);textField.setText("");
							lblNewLabel_8.setVisible(false);
							button.setVisible(false);btnNewButton_4.setVisible(false);
							comboBox.setVisible(false);comboBox.removeAllItems();
							lblNewLabel_1.setVisible(false);
							scrollPane.setVisible(false);table.removeAll();
							scrollPane_1.setVisible(false);table_1.removeAll();
							lblNewLabel_1.setVisible(false);lblNewLabel_2.setVisible(false);lblNewLabel_4.setVisible(false);lblNewLabel_5.setVisible(false);
							p.clear();
					}
					else if(sql2!=null&&a.updateItem(sql2)){
						JOptionPane.showMessageDialog(null, "收费成功！"
				                   +"\n药品费用共计"+p.getRaprize()+"元"
				                   +"\n项目费用共计"+p.getFaprize()+"元"
				                   +"\n费用总计："+(p.getRaprize()+p.getFaprize())+"元");
					btnNewButton_3.setVisible(true);textField.setEnabled(true);textField.setText("");
					lblNewLabel_8.setVisible(false);
					button.setVisible(false);btnNewButton_4.setVisible(false);
					comboBox.setVisible(false);comboBox.removeAllItems();
					lblNewLabel_1.setVisible(false);
					scrollPane.setVisible(false);table.removeAll();
					scrollPane_1.setVisible(false);table_1.removeAll();
					lblNewLabel_1.setVisible(false);lblNewLabel_2.setVisible(false);lblNewLabel_4.setVisible(false);lblNewLabel_5.setVisible(false);
					p.clear();
					}
					else 
						JOptionPane.showMessageDialog(null,"收费失败！");
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener(){//“取消”
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = { "是", "否" }; 
				int i=JOptionPane.showOptionDialog(null, "确认取消？", "", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				if(i==JOptionPane.YES_OPTION){
					btnNewButton_3.setVisible(true);textField.setEnabled(true);textField.setText("");
					lblNewLabel_8.setVisible(false);
					button.setVisible(false);btnNewButton_4.setVisible(false);
					comboBox.setVisible(false);comboBox.removeAllItems();
					lblNewLabel_1.setVisible(false);
					scrollPane.setVisible(false);table.removeAll();
					scrollPane_1.setVisible(false);table_1.removeAll();
					lblNewLabel_1.setVisible(false);lblNewLabel_2.setVisible(false);lblNewLabel_4.setVisible(false);lblNewLabel_5.setVisible(false);
					p.clear();
				}
			}
		});
	}
	
	class MyTask extends TimerTask{
		@Override
		public void run() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s = sdf.format(new Date());
			lblNewLabel_3.setText(s);			
		}
	}

}
