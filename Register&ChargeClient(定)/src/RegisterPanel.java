import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class RegisterPanel extends JPanel {
	Patient p=new Patient();
	Doctor d=new Doctor();
	
	
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
	private final JTextField textField = new JTextField(18);
	private final JButton btnNewButton_3 = new JButton("\u786E\u5B9A");
	private final JLabel lblNewLabel_1 = new JLabel("\u6302\u53F7\u79D1\u5BA4\uFF1A");
	private final JComboBox comboBox = new JComboBox();
	private final JLabel lblNewLabel_2 = new JLabel("\u6302\u53F7\u533B\u751F\uFF1A");
	private final JComboBox comboBox_1 = new JComboBox();
	private final JButton button = new JButton("\u786E\u8BA4\u6302\u53F7");
	private final JButton btnNewButton_4 = new JButton("\u53D6\u6D88");
	private final JLabel lblNewLabel_8 = new JLabel("");
	private final JLabel lblNewLabel_3 = new JLabel("yyyy-MM-dd HH:mm:ss");
	private final JLabel lblNewLabel_5 = new JLabel("\u9884\u7EA6\u65F6\u95F4\uFF1A");
	private final JLabel lblNewLabel_6 = new JLabel("\u9884\u7EA6\u79D1\u5BA4\uFF1A");
	private final JLabel lblNewLabel_7 = new JLabel("\u9884\u7EA6\u533B\u751F\uFF1A");
	private final JLabel lblNewLabel_9 = new JLabel("\u9884\u7EA6\u65E5\u671F\uFF1A");
	private final JComboBox comboBox_2 = new JComboBox();
	private final JLabel lblNewLabel_4 = new JLabel("");
	private final JLabel lblNewLabel_10 = new JLabel("");
	private final JLabel lblNewLabel_11 = new JLabel("");
	private final JLabel lblNewLabel_12 = new JLabel("");
	public JComboBox getComboBox_2() {
		return comboBox_2;
	}
	public JLabel getLblNewLabel_4() {
		return lblNewLabel_4;
	}
	public JLabel getLblNewLabel_10() {
		return lblNewLabel_10;
	}
	public JLabel getLblNewLabel_11() {
		return lblNewLabel_11;
	}
	public JLabel getLblNewLabel_12() {
		return lblNewLabel_12;
	}
	public Patient getP() {
		return p;
	}
	public void setP(Patient p) {
		this.p = p;
	}
	public Doctor getD() {
		return d;
	}
	public void setD(Doctor d) {
		this.d = d;
	}
	public JPanel getPanel() {
		return panel;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JButton getBtnNewButton_3() {
		return btnNewButton_3;
	}
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}
	public JComboBox getComboBox_1() {
		return comboBox_1;
	}
	public JButton getButton() {
		return button;
	}
	public JButton getBtnNewButton_4() {
		return btnNewButton_4;
	}
	public JLabel getLblNewLabel_8() {
		return lblNewLabel_8;
	}
	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}
	public JLabel getLblNewLabel_5() {
		return lblNewLabel_5;
	}
	public JLabel getLblNewLabel_6() {
		return lblNewLabel_6;
	}
	public JLabel getLblNewLabel_7() {
		return lblNewLabel_7;
	}
	public JLabel getLblNewLabel_9() {
		return lblNewLabel_9;
	}
	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 6;
		gbc_btnNewButton_3.gridy = 0;
		btnNewButton_3.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridwidth = 12;
		gbc_lblNewLabel_8.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 2;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 8;
		gbc_comboBox_2.gridy = 3;
		panel.add(comboBox_2, gbc_comboBox_2);
		comboBox_2.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.weightx = 3.0;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 5;
		comboBox.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(comboBox, gbc_comboBox);
		comboBox.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 7;
		gbc_lblNewLabel_6.gridy = 5;
		lblNewLabel_6.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 8;
		gbc_lblNewLabel_4.gridy = 5;
		lblNewLabel_4.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.weightx = 3.0;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 6;
		comboBox_1.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(comboBox_1, gbc_comboBox_1);
		comboBox_1.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 7;
		gbc_lblNewLabel_7.gridy = 6;
		lblNewLabel_7.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 8;
		gbc_lblNewLabel_10.gridy = 6;
		lblNewLabel_10.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 7;
		gbc_lblNewLabel_9.gridy = 7;
		lblNewLabel_9.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		lblNewLabel_9.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 8;
		gbc_lblNewLabel_11.gridy = 7;
		lblNewLabel_11.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 30, 5);
		gbc_lblNewLabel_5.gridx = 7;
		gbc_lblNewLabel_5.gridy = 8;
		lblNewLabel_5.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 30, 5);
		gbc_lblNewLabel_12.gridx = 8;
		gbc_lblNewLabel_12.gridy = 8;
		lblNewLabel_12.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 10);
		gbc_button.gridx = 8;
		gbc_button.gridy = 13;
		button.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(button, gbc_button);
		button.setVisible(false);
		
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 9;
		gbc_btnNewButton_4.gridy = 13;
		btnNewButton_4.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 15));
		add(lblNewLabel_3, BorderLayout.NORTH);
		btnNewButton_4.setVisible(false);
		
		lblNewLabel_4.setVisible(false);lblNewLabel_10.setVisible(false);lblNewLabel_11.setVisible(false);lblNewLabel_12.setVisible(false);
		
		Timer t = new Timer();
		t.schedule(new MyTask(), 1000,1000);

		comboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comboBox_1.removeAllItems();
				TimeHandel t=new TimeHandel();
		        String date =t.getNowDate(),h=t.getNowDateHour();
				if(comboBox.getSelectedIndex()!=-1){
					if(comboBox.getSelectedItem().toString()!=""){
					String dpmName=comboBox.getSelectedItem().toString();
					String dName;
					if(h.compareTo("12:00:00")>0){//下午
						dName=d.getDotorNumber(dpmName, 2, date);
					}
					else{//上午
						dName=d.getDotorNumber(dpmName, 1, date);
					}
					if(dName!=null){
						comboBox_1.addItem(dName);
					}
					else{
						String sql="select name from Doctor where dpmId=(select dpmId from Department where dpmName='"+dpmName+"')";
						DBhandel a =new DBhandel();
						a.addComboBox(comboBox_1, sql, "name");
					}
					}
				}
			}
		});
		comboBox_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(comboBox_2.getSelectedIndex()!=-1){
					if(comboBox_2.getSelectedItem().toString()!=""){
					int i=Integer.parseInt(comboBox_2.getSelectedItem().toString())-1;
					DBhandel a =new DBhandel();
					String[] dpm=p.getDpm(),dd=p.getDd(),qt=p.getQt();
					String sql="select dpmName from Department where dpmId='"+dpm[i]+"'",
							sql2="select name from Doctor where dId='"+dd[i]+"'";
					String dpmName=a.getItem(sql, "dpmName");String name=a.getItem(sql2, "name");
					lblNewLabel_4.setText(dpmName);
					lblNewLabel_10.setText(name);
					String[] s=qt[i].split(" ");
					lblNewLabel_11.setText(s[0]);
					if(s[1].compareTo("12:00:00")>0) lblNewLabel_12.setText("下午");
					else lblNewLabel_12.setText("上午");
					}
				}
			}
		});
		
		button.addActionListener(new ActionListener(){//“确认挂号”
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(p.getIsVisit()==1){
					if(comboBox_2.getSelectedIndex()!=-1&&comboBox_2.getSelectedItem().toString()!=""){
						int i=Integer.parseInt(comboBox_2.getSelectedItem().toString())-1;
						DBhandel a =new DBhandel();
						String[] dpm=p.getDpm(),dd=p.getDd(),qt=p.getQt();
						int[] qn=p.getQn();
						String sql="update PatientHSP set isVisit=3 where pId='"+p.getpId()+
								"' AND dpmId='"+dpm[i]+
								"' AND dId='"+dd[i]+
								"' AND qTime='"+qt[i]+
								"' AND qNumber="+qn[i];
						if(a.updateItem(sql)){
							JOptionPane.showMessageDialog(null,"挂号成功！\n挂号费：20元");
							p.clear();
							lblNewLabel_6.setVisible(false);lblNewLabel_7.setVisible(false);
							lblNewLabel_9.setVisible(false);lblNewLabel_5.setVisible(false);
							lblNewLabel_4.setVisible(false);lblNewLabel_10.setVisible(false);
							lblNewLabel_11.setVisible(false);lblNewLabel_12.setVisible(false);
							lblNewLabel_4.setText("");lblNewLabel_10.setText("");
							lblNewLabel_11.setText("");lblNewLabel_12.setText("");
							btnNewButton_4.setVisible(false);button.setVisible(false);
							btnNewButton_3.setVisible(true);
							textField.setEnabled(true);textField.setText("");
							comboBox_2.removeAllItems();comboBox_2.setVisible(false);
						}
					}
					else JOptionPane.showMessageDialog(null,"请选择要挂号收费的预约项！");
				}
				else {
					String dpmName=comboBox.getSelectedItem().toString();
					String dName=comboBox_1.getSelectedItem().toString();
					TimeHandel t=new TimeHandel();
					String day=t.getNowDate(),h=t.getNowDateHour();
					p.setAppTime(Timestamp.valueOf(day+" "+h));
					DBhandel a =new DBhandel();
					String sql="select dpmId from Department where dpmName='"+dpmName+"'",
						sql2="select dId from Doctor where name='"+dName+"'";
					String dpmId=a.getItem(sql, "dpmId");String dId=a.getItem(sql2, "dId");
					p.setDpmId(dpmId);p.setdId(dId);
					sql="select qNumber from PatientHSP where pId='"+p.getpId()+"' AND dId='"+p.getdId()+"' AND (convert(varchar(10),qTime,120)='"+day+"' or convert(varchar(10),appTime,120)='"+day+"' )";
					if(a.getItem(sql, "qNumber")!=null){
						JOptionPane.showMessageDialog(null,"挂号失败！该病人已有此医生挂号记录！");
					}
					else{
						String sql4;int number;
						if(h.compareTo("12:00:00")>0){//下午
						d.setDoctor(dId,Timestamp.valueOf(day+" 00:00:00"));
						number=d.getPatientNumber2()+1;
						sql4="update DoctorDate set patientNumber2="+number+" where dId='"+dId+"'";
						a.updateItem(sql4);
						number+=20;
						}
						else{//上午
						d.setDoctor(dId,Timestamp.valueOf(day+" 00:00:00"));
						if(d.getPatientNumber1()<20){
							number=d.getPatientNumber1()+1;
							sql4="update DoctorDate set patientNumber1="+number+" where dId='"+dId+"'";
							a.updateItem(sql4);
							}
						else {
							number=d.getPatientNumber2()+1;
							sql4="update DoctorDate set patientNumber2="+number+" where dId='"+dId+"'";
							a.updateItem(sql4);
							number+=20;
							}
						}
						p.setIsVisit(2);
						p.setqNumber(number);
						p.addPatient(p);
						JOptionPane.showMessageDialog(null,"挂号成功！\n挂号科室："+dpmName+"\n挂号医生："
						+dName+"\n排队号："+number+"\n挂号费：20元");
						p.clear();
						lblNewLabel_1.setVisible(false);lblNewLabel_2.setVisible(false);
						comboBox.removeAllItems();comboBox.setVisible(false);comboBox_1.setVisible(false);
						btnNewButton_4.setVisible(false);button.setVisible(false);
						btnNewButton_3.setVisible(true);
						textField.setEnabled(true);textField.setText("");
					}
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener(){//“取消”
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "是", "否" }; 
				int i=JOptionPane.showOptionDialog(null, "确认取消？", "", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				if(i==JOptionPane.YES_OPTION){
					p.clear();
					lblNewLabel_6.setVisible(false);lblNewLabel_7.setVisible(false);
					lblNewLabel_9.setVisible(false);lblNewLabel_5.setVisible(false);
					lblNewLabel_4.setVisible(false);lblNewLabel_10.setVisible(false);
					lblNewLabel_11.setVisible(false);lblNewLabel_12.setVisible(false);
					comboBox_2.removeAllItems();comboBox_2.setVisible(false);
					lblNewLabel_1.setVisible(false);lblNewLabel_2.setVisible(false);
					comboBox.removeAllItems();comboBox.setVisible(false);comboBox_1.setVisible(false);
					btnNewButton_4.setVisible(false);button.setVisible(false);
					btnNewButton_3.setVisible(true);
					textField.setEnabled(true);textField.setText("");
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



