import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class FeeItem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine frame = new Medicine();
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
	public FeeItem() {
		setTitle("\u6536\u8D39\u9879\u76EE\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 10, 405, 260);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9879\u76EE\u7F16\u53F7", "\u9879\u76EE\u540D", "\u9879\u76EE\u4EF7\u683C", "\u62FC\u97F3\u7B80\u7801"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u8F93\u5165\u7F16\u53F7\uFF1A");
		label.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label.setBounds(33, 297, 70, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(113, 297, 37, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_1.setBounds(208, 298, 70, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u7F16\u53F7\uFF1A");
		label_2.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_2.setBounds(381, 298, 70, 15);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(288, 294, 37, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(461, 294, 37, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u5220\u9664");
		button.setFont(new Font("等线 Light", Font.PLAIN, 14));
		button.setBounds(49, 394, 70, 23);
		contentPane.add(button);
		
		JLabel label_3 = new JLabel("\u9879\u76EE\u540D\uFF1A");
		label_3.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_3.setBounds(183, 323, 70, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(259, 319, 101, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u9879\u76EE\u4EF7\u683C\uFF1A");
		label_4.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_4.setBounds(183, 346, 77, 15);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(259, 340, 101, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("\u62FC\u97F3\u7B80\u7801\uFF1A");
		label_5.setFont(new Font("等线 Light", Font.PLAIN, 14));
		label_5.setBounds(183, 369, 70, 15);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(259, 365, 101, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.setFont(new Font("等线 Light", Font.PLAIN, 14));
		button_1.setBounds(236, 394, 66, 23);
		contentPane.add(button_1);
		
		JRadioButton radioButton = new JRadioButton("\u9879\u76EE\u540D");
		radioButton.setFont(new Font("等线 Light", Font.PLAIN, 14));
		radioButton.setBounds(411, 319, 70, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u9879\u76EE\u4EF7\u683C");
		radioButton_1.setFont(new Font("等线 Light", Font.PLAIN, 14));
		radioButton_1.setBounds(411, 340, 87, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("\u62FC\u97F3\u7B80\u7801");
		radioButton_2.setFont(new Font("等线 Light", Font.PLAIN, 14));
		radioButton_2.setBounds(411, 365, 87, 23);
		contentPane.add(radioButton_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(385, 394, 66, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton button_2 = new JButton("\u4FEE\u6539");
		button_2.setFont(new Font("等线 Light", Font.PLAIN, 14));
		button_2.setBounds(463, 394, 66, 23);
		contentPane.add(button_2);
	}
}