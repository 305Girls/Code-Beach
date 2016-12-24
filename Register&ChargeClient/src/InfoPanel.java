import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class InfoPanel extends JPanel {
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel_3 = new JLabel("yyyy-MM-dd HH:mm:ss");
	private final JLabel lblNewLabel = new JLabel("\u6211\u7684\u5DE5\u53F7\uFF1A");
	private final JLabel lblNewLabel_5 = new JLabel("New label");
	private final JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
	private final JLabel lblNewLabel_6 = new JLabel("New label");
	private final JLabel lblNewLabel_2 = new JLabel("\u5E74\u9F84\uFF1A");
	private final JLabel lblNewLabel_7 = new JLabel("New label");
	private final JLabel lblNewLabel_4 = new JLabel("\u6027\u522B\uFF1A");
	private final JLabel lblNewLabel_8 = new JLabel("New label");
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	JButton btnNewButton = new JButton("\u9000\u51FA\u767B\u5F55");
	/**
	 * Create the panel.
	 */
	public InfoPanel(Cashier c) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_5.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 1;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_6.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 2;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel_7.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 3;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		lblNewLabel_4.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_8.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 4;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(50, 0, 30, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_5.setText(c.getId());
		lblNewLabel_6.setText(c.getName());
		lblNewLabel_7.setText(String.valueOf(c.getAge()));
		lblNewLabel_8.setText(c.getGender());
		
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 15));
		add(lblNewLabel_3, BorderLayout.NORTH);
		
		Timer t = new Timer();
		t.schedule(new MyTask(), 1000,1000);
		
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
