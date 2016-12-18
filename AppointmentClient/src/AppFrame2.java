import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class AppFrame2 extends JFrame {

	private JPanel contentPane;
    private JPanel panel = new JPanel();
    private JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4EE5\u4E0B\u4FE1\u606F"),
    		lblNewLabel_1 = new JLabel("\u9884\u7EA6\u79D1\u5BA4\uFF1A"),
    		lblNewLabel_2 = new JLabel("\u9884\u7EA6\u533B\u751F\uFF1A"),
    		lblNewLabel_3 = new JLabel("\u9884\u7EA6\u65F6\u95F4\uFF1A");
    private JComboBox comboBox = new JComboBox(),comboBox_1 = new JComboBox(),comboBox_2 = new JComboBox();
    private JButton btnNewButton = new JButton("\u786E\u5B9A"),btnNewButton_1 = new JButton("\u53D6\u6D88");
    private JLabel lblNewLabel_4 = new JLabel("\u59D3\u540D\uFF1A");
    private JLabel lblNewLabel_5 = new JLabel("\u5E74\u9F84\uFF1A");
    private JLabel lblNewLabel_6 = new JLabel("\u6027\u522B\uFF1A");
    private JLabel lblNewLabel_7 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
    private JTextField textField = new JTextField();
    private JTextField textField_1 = new JTextField();
    private JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
    private JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
    private JTextField textField_2 = new JTextField();
    private JLabel lblNewLabel_8 = new JLabel("-----------------------------------------------------");
	public JTextField getTextField() {
		return textField;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}
	public JRadioButton getRdbtnNewRadioButton_1() {
		return rdbtnNewRadioButton_1;
	}
	public JTextField getTextField_2() {
		return textField_2;
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
	public AppFrame2() {
		textField_2.setColumns(10);
		textField_1.setFont(new Font("等线", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField.setFont(new Font("等线", Font.PLAIN, 15));
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(30, 0, 80, 0);
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.gridwidth = 18;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 2;
		lblNewLabel_4.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 50);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 3;
		lblNewLabel_5.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 50);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 6;
		gbc_textField_1.gridy = 3;
		panel.add(textField_1, gbc_textField_1);
		
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 4;
		lblNewLabel_6.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 5;
		gbc_rdbtnNewRadioButton.gridy = 4;
		rdbtnNewRadioButton.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 6;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		rdbtnNewRadioButton_1.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		ButtonGroup bg=new ButtonGroup();bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);
		
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 5;
		lblNewLabel_7.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 50);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 5;
		panel.add(textField_2, gbc_textField_2);
		
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridwidth = 15;
		gbc_lblNewLabel_8.insets = new Insets(0, 150, 5, 150);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 6;
		lblNewLabel_8.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		
		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 7;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u5987\u79D1", "\u9AA8\u79D1", "\u513F\u79D1"}));
		
		
		comboBox.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 50);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 6;
		gbc_comboBox.gridy = 7;
		panel.add(comboBox, gbc_comboBox);
		
		
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 8;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "\u8D75\u4E09", "\u674E\u6B66", "\u9EC4\u864E", "\u738B\u98D2"}));
		
		
		comboBox_1.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 50);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 6;
		gbc_comboBox_1.gridy = 8;
		panel.add(comboBox_1, gbc_comboBox_1);
		
	
		lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 150, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 9;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "\u4E0A\u5348", "\u4E0B\u5348"}));
		comboBox_2.setToolTipText("");
		
		
		comboBox_2.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 50);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 6;
		gbc_comboBox_2.gridy = 9;
		panel.add(comboBox_2, gbc_comboBox_2);
		
		
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(50, 50, 5, 10);
		gbc_btnNewButton.gridx = 11;
		gbc_btnNewButton.gridy = 11;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		
		btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(50, 0, 5, 50);
		gbc_btnNewButton_1.gridx = 13;
		gbc_btnNewButton_1.gridy = 11;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		

		/*添加combobox选项
		 * 		comboBox.addItem(item);
		 *    	comboBox_1.addItem(item);
		 * */
	}

}
