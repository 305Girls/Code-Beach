import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Department extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department frame = new Department();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Department() {
		setTitle("\u533B\u9662\u79D1\u5BA4\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 10, 274, 140);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u79D1\u5BA4\u53F7", "\u79D1\u5BA4"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(313, 160, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(313, 196, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.setBounds(313, 229, 93, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(155, 161, 134, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u79D1\u5BA4\u540D\uFF1A");
		lblNewLabel.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 164, 93, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u79D1\u5BA4\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("等线 Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 200, 93, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 197, 134, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u8F93\u5165\u79D1\u5BA4\u53F7\uFF1A");
		label.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label.setBounds(10, 234, 93, 15);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 230, 30, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u79D1\u5BA4\u540D\uFF1A");
		label_1.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_1.setBounds(135, 233, 86, 15);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(207, 230, 82, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
