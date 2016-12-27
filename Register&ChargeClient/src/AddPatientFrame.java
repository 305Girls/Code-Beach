import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class AddPatientFrame extends JFrame {

	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel_4 = new JLabel("\u59D3\u540D\uFF1A");
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblNewLabel_5 = new JLabel("\u5E74\u9F84\uFF1A");
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblNewLabel_6 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
	private final JTextField textField_3 = new JTextField();
	private final JLabel lblNewLabel_7 = new JLabel("\u6027\u522B\uFF1A");
	private final JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
	private final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
	private final JButton btnNewButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
	private final JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
	private final JLabel lblNewLabel = new JLabel("\u8BF7\u586B\u5199\u75C5\u4EBA\u4FE1\u606F");
	public JPanel getPanel() {
		return panel;
	}
	public JLabel getLblNewLabel_4() {
		return lblNewLabel_4;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JLabel getLblNewLabel_5() {
		return lblNewLabel_5;
	}
	public JTextField getTextField_2() {
		return textField_2;
	}
	public JLabel getLblNewLabel_6() {
		return lblNewLabel_6;
	}
	public JTextField getTextField_3() {
		return textField_3;
	}
	public JLabel getLblNewLabel_7() {
		return lblNewLabel_7;
	}
	public JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}
	public JRadioButton getRdbtnNewRadioButton_1() {
		return rdbtnNewRadioButton_1;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}
	
	/**
	 * Create the frame.
	 */
	public AddPatientFrame() {
		setTitle("添加病人信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 17));
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		lblNewLabel_4.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		textField_1.setFont(new Font("等线", Font.PLAIN, 15));
		
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		lblNewLabel_5.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		textField_2.setFont(new Font("等线", Font.PLAIN, 15));
		
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		panel.add(textField_2, gbc_textField_2);
		
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		lblNewLabel_7.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 4;
		rdbtnNewRadioButton.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 2;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		rdbtnNewRadioButton_1.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		ButtonGroup bg=new ButtonGroup();bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);
		
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		lblNewLabel_6.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		textField_3.setFont(new Font("等线", Font.PLAIN, 15));
		
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		panel.add(textField_3, gbc_textField_3);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 10);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(btnNewButton, gbc_btnNewButton);
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 20);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 6;
		btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 15));
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
	}

}
