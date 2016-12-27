import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class AppFrame1 extends JFrame {

	private JPanel contentPane;
    private JPanel panel = new JPanel();
    private JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4EE5\u4E0B\u4FE1\u606F"),
    		lblNewLabel_1 = new JLabel("\u9884\u7EA6\u79D1\u5BA4\uFF1A"),
    		lblNewLabel_2 = new JLabel("\u9884\u7EA6\u533B\u751F\uFF1A"),
    		lblNewLabel_3 = new JLabel("\u9884\u7EA6\u65F6\u95F4\uFF1A");
    private JComboBox comboBox = new JComboBox(),comboBox_1 = new JComboBox(),comboBox_2 = new JComboBox();
    private JButton btnNewButton = new JButton("\u786E\u5B9A"),btnNewButton_1 = new JButton("\u53D6\u6D88");
    private final JLabel label = new JLabel("\u9884\u7EA6\u65E5\u671F\uFF1A");
    private final JComboBox comboBox_3 = new JComboBox();
    public JComboBox getComboBox_3() {
		return comboBox_3;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	public JComboBox getComboBox_1() {
		return comboBox_1;
	}
	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}
	public JComboBox getComboBox_2() {
		return comboBox_2;
	}
	public void setComboBox_2(JComboBox comboBox_2) {
		this.comboBox_2 = comboBox_2;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}
	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	/**
	 * Create the frame.
	 */
	public AppFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(30, 0, 100, 0);
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.gridwidth = 14;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 50);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 2;
		gbc_comboBox_3.gridy = 7;
		panel.add(comboBox_3, gbc_comboBox_3);
		
		
		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		comboBox.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 50);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		panel.add(comboBox, gbc_comboBox);
		
		
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 6;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		comboBox_1.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 50);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 6;
		panel.add(comboBox_1, gbc_comboBox_1);
		
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 150, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 7;
		label.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(label, gbc_label);
		
	
		lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 8;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "\u4E0A\u5348", "\u4E0B\u5348"}));
		comboBox_2.setToolTipText("");
		
		
		comboBox_2.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 50);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 8;
		panel.add(comboBox_2, gbc_comboBox_2);
		
		
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(50, 50, 5, 10);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 11;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		
		btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(50, 0, 5, 50);
		gbc_btnNewButton_1.gridx = 9;
		gbc_btnNewButton_1.gridy = 11;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		

		//添加comboBox选项
		DBhandel a =new DBhandel();
		String sql="select dpmName from Department";
		a.addComboBox(comboBox,sql,"dpmName");
		comboBox_3.addItem("");
		Calendar c = Calendar.getInstance();
		Date d=new Date();//取时间
        c.setTime(d);
        for(int i=0;i<3;i++){
        c.add(c.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        d=c.getTime(); //这个时间就是日期往后推一天的结果        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(d);  
        comboBox_3.addItem(dateString);
        }
	}
	
}

