package main;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import yss.*;

import java.net.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Client_Doctor {
	static Socket server = null;// 向本机4444端口发出客户请求
	static JFrame frame;
	private JTextField id;
	static String log_in;//登录信息
	private JPasswordField pwd;
	static Doctor doc=null;
	static Patient patient=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Doctor window = new Client_Doctor();
					window.frame.setVisible(true);
					// 由Socket对象得到输入流，并构造BufferedReader对象

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client_Doctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 774, 698);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginActivity LA=new LoginActivity();
	}

	JFrame getFrame() {
		return frame;
	}

	void setFrame(JFrame frame) {
		this.frame = frame;
	}

	JTextField getId() {
		return id;
	}

	void setId(JTextField id) {
		this.id = id;
	}

	JTextField getPwd() {
		return pwd;
	}

	void setPwd(JPasswordField pwd) {
		this.pwd = pwd;
	}

	class LoginActivity extends JPanel
	{
		public LoginActivity()
		{
		JPanel Pane = new JPanel();
		frame.getContentPane().add(Pane, BorderLayout.CENTER);
		GridBagLayout gbl_Pane = new GridBagLayout();
		gbl_Pane.columnWidths = new int[]{180, 89, 65, 179, 0};
		gbl_Pane.rowHeights = new int[]{150, 38, 0, 0, 0, 0, 35, 38, 35, 41, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Pane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Pane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Pane.setLayout(gbl_Pane);
		
		JLabel label_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		label_1.setFont(new Font("宋体", Font.PLAIN, 31));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 4;
		Pane.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("\u533B\u751F\u770B\u75C5\u5212\u4EF7\u7AEF");
		label_2.setFont(new Font("宋体", Font.PLAIN, 31));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 6;
		Pane.add(label_2, gbc_label_2);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 8;
		Pane.add(lblNewLabel, gbc_lblNewLabel);
		
		id = new JTextField();
		id.setFont(new Font("宋体", Font.PLAIN, 28));
		GridBagConstraints gbc_id = new GridBagConstraints();
		gbc_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_id.insets = new Insets(0, 0, 5, 5);
		gbc_id.gridx = 2;
		gbc_id.gridy = 8;
		Pane.add(id, gbc_id);
		id.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setFont(new Font("宋体", Font.PLAIN, 28));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 10;
		Pane.add(label, gbc_label);
		
		pwd = new JPasswordField();
		pwd.setFont(new Font("宋体", Font.PLAIN, 28));
		GridBagConstraints gbc_pwd = new GridBagConstraints();
		gbc_pwd.insets = new Insets(0, 0, 5, 5);
		gbc_pwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwd.gridx = 2;
		gbc_pwd.gridy = 10;
		Pane.add(pwd, gbc_pwd);
		
		JButton logIn = new JButton("\u767B\u5F55");
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					server=new Socket("127.0.0.1", 4444);
					PrintWriter os = new PrintWriter(server.getOutputStream());
					BufferedReader is= new BufferedReader(new InputStreamReader(server.getInputStream()));
					os.println(id.getText());
					os.flush();
					os.println(pwd.getPassword());
					os.flush();
					os.println(1);
					os.flush();
					log_in=is.readLine();
					if(log_in.equals("succeed"))
					{
						JOptionPane.showMessageDialog(null,log_in,"LOG_IN", JOptionPane.PLAIN_MESSAGE); 
						String ip=is.readLine();//接收数据库地址
						//连接数据库
						if(OPDB.open())
						{
							System.out.println("连接数据库成功！");
							doc=new Doctor(id.getText());
							//跳转界面
							frame.getContentPane().removeAll();
							QueueDisplayed di=new QueueDisplayed(doc);
							frame.getContentPane().add(di,BorderLayout.CENTER);
							frame.getContentPane().validate();
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,log_in, "ERROR", JOptionPane.ERROR_MESSAGE); 
					}
					os.close();// 关闭Socket输出流
					is.close();// 关闭Socket输入流
					server.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		logIn.setFont(new Font("宋体", Font.PLAIN, 28));
		GridBagConstraints gbc_logIn = new GridBagConstraints();
		gbc_logIn.insets = new Insets(0, 0, 5, 5);
		gbc_logIn.gridx = 1;
		gbc_logIn.gridy = 13;
		Pane.add(logIn, gbc_logIn);
		
		JButton quit = new JButton("\u9000\u51FA");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quit.setFont(new Font("宋体", Font.PLAIN, 28));
		GridBagConstraints gbc_quit = new GridBagConstraints();
		gbc_quit.anchor = GridBagConstraints.EAST;
		gbc_quit.insets = new Insets(0, 0, 5, 5);
		gbc_quit.gridx = 2;
		gbc_quit.gridy = 13;
		Pane.add(quit, gbc_quit);
		}
	}
	class QueueDisplayed extends JTabbedPane
	{
		private JTable table;
		private JTextField textField;
		private JTable table_1;
		private JTextField textField_1;
	 public QueueDisplayed(final Doctor doc) {//final变量使引用对象永远指向一个
			this.setSize(764,698);
			JPanel p1 = new JPanel();
			addTab("待就诊病人", null, p1, null);
			GridBagLayout gbl_p1 = new GridBagLayout();
			gbl_p1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_p1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_p1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_p1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			p1.setLayout(gbl_p1);
			
			JLabel label = new JLabel("\u6302\u53F7\u75C5\u4EBA");
			label.setFont(new Font("宋体", Font.PLAIN, 30));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 1;
			p1.add(label, gbc_label);
			
			JLabel lblNewLabel = new JLabel("\u75C5\u4EBAID");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 2;
			p1.add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("\u75C5\u4EBA\u59D3\u540D");
			lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.gridwidth = 3;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 3;
			gbc_lblNewLabel_1.gridy = 2;
			p1.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("\u6392\u961F\u53F7");
			lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.gridwidth = 3;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 6;
			gbc_lblNewLabel_2.gridy = 2;
			p1.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			final JLabel regisPatient = new JLabel("New label");
			regisPatient.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_regisPatient = new GridBagConstraints();
			gbc_regisPatient.gridwidth = 2;
			gbc_regisPatient.insets = new Insets(0, 0, 5, 5);
			gbc_regisPatient.gridx = 1;
			gbc_regisPatient.gridy = 3;
			p1.add(regisPatient, gbc_regisPatient);
			if(!doc.getQ().isEmpty())//挂号队列不为空
				regisPatient.setText(doc.choosePatient().getpId());
			else 
				regisPatient.setText("无");
			final JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.gridwidth = 3;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 3;
			gbc_lblNewLabel_3.gridy = 3;
			p1.add(lblNewLabel_3, gbc_lblNewLabel_3);
			if(!doc.getQ().isEmpty())//挂号队列不为空
				lblNewLabel_3.setText(doc.choosePatient().getName());
			else 
				lblNewLabel_3.setText("无");
			final JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.gridwidth = 3;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 6;
			gbc_lblNewLabel_4.gridy = 3;
			p1.add(lblNewLabel_4, gbc_lblNewLabel_4);
			if(!doc.getQ().isEmpty())//挂号队列不为空
				lblNewLabel_4.setText(Integer.toString(doc.choosePatient().getqNumber()));
			else
				lblNewLabel_4.setText("无");
			JButton button_2 = new JButton("\u786E\u8BA4\u5C31\u8BCA");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					patient=doc.choosePatient();
					if(patient!=null)
					{
						//System.out.println(Client_Doctor.patient.getName());
						CureP cp=new CureP(patient);
						Thread thread=new Thread(cp);
						thread.start();
						if(CureP.exi==JOptionPane.YES_OPTION)
						{
							doc.curedRegisPatient();//已就诊的挂号病人出队列
							Patient p=doc.choosePatient();//取下一个挂号病人
							if(p!=null)
							{
								regisPatient.setText(p.getpId());
								lblNewLabel_3.setText(p.getName());
								lblNewLabel_4.setText(Integer.toString(p.qNumber));
							}
							else{
								regisPatient.setText("无");
								lblNewLabel_3.setText("无");
								lblNewLabel_4.setText("无");
							}
						}
					}
				}
			});
			
			button_2.setFont(new Font("宋体", Font.PLAIN, 27));
			GridBagConstraints gbc_button_2 = new GridBagConstraints();
			gbc_button_2.anchor = GridBagConstraints.WEST;
			gbc_button_2.insets = new Insets(0, 0, 5, 5);
			gbc_button_2.gridx = 2;
			gbc_button_2.gridy = 4;
			p1.add(button_2, gbc_button_2);
			
			JButton button_3 = new JButton("\u8FC7\u53F7");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Patient p=doc.passPatient();
					Patient next_p=doc.choosePatient();//下一个待就诊的病人
					if(next_p!=null)
					{
						regisPatient.setText(next_p.getName());
						lblNewLabel_3.setText(next_p.getpId());
				        lblNewLabel_4.setText(Integer.toString(next_p.getqNumber()));
					}
					else{
						regisPatient.setText("无");
						lblNewLabel_3.setText("无");
				        lblNewLabel_4.setText("无");
					}
					
				}
			});
			button_3.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_button_3 = new GridBagConstraints();
			gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_button_3.insets = new Insets(0, 0, 5, 5);
			gbc_button_3.gridx = 3;
			gbc_button_3.gridy = 4;
			p1.add(button_3, gbc_button_3);
			
			JButton refresh = new JButton("\u5237\u65B0");//刷新挂号队列
			refresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String sql="select B.name,A.pId,A.qNumber,A.isVisit "
								+ "from PatientHSP A,Patient B,Doctor C "
								+ "where C.dId='"+doc.getdId()+"'and A.pId=B.pId and C.dId=A.dId ";
					ResultSet rs=OPDB.excuteSelect(sql);
					Queue<Patient> newQ=new LinkedList<Patient>();
					while(rs.next())
					{
						if(rs.getInt("isVisit")==2||rs.getInt("isVisit")==3)
							newQ.add(new Patient(rs.getString("pId"),rs.getString("name"),
								rs.getInt("qNumber"),rs.getInt("isVisit")));
					}
					doc.setQ(newQ);
					Patient p=doc.choosePatient();
					if(p!=null)
					{
						regisPatient.setText(p.getpId());
						lblNewLabel_3.setText(p.getName());
						lblNewLabel_4.setText(Integer.toString(p.getqNumber()));
					}
					else
					{
						regisPatient.setText("无");
						lblNewLabel_3.setText("无");
						lblNewLabel_4.setText("无");
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			refresh.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_button_4 = new GridBagConstraints();
			gbc_button_4.gridwidth = 3;
			gbc_button_4.insets = new Insets(0, 0, 5, 5);
			gbc_button_4.gridx = 4;
			gbc_button_4.gridy = 4;
			p1.add(refresh, gbc_button_4);
			
			JLabel label_1 = new JLabel("\u9884\u7EA6\u75C5\u4EBA");
			label_1.setFont(new Font("宋体", Font.PLAIN, 30));
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 1;
			gbc_label_1.gridy = 7;
			p1.add(label_1, gbc_label_1);
			
			JLabel label_5 = new JLabel("\u75C5\u4EBAID");
			label_5.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_label_5 = new GridBagConstraints();
			gbc_label_5.gridwidth = 2;
			gbc_label_5.insets = new Insets(0, 0, 5, 5);
			gbc_label_5.gridx = 1;
			gbc_label_5.gridy = 8;
			p1.add(label_5, gbc_label_5);
			
			JLabel label_6 = new JLabel("\u75C5\u4EBA\u59D3\u540D");
			label_6.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_label_6 = new GridBagConstraints();
			gbc_label_6.gridwidth = 3;
			gbc_label_6.insets = new Insets(0, 0, 5, 5);
			gbc_label_6.gridx = 3;
			gbc_label_6.gridy = 8;
			p1.add(label_6, gbc_label_6);
			
			JLabel label_7 = new JLabel("\u6392\u961F\u53F7");
			label_7.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_label_7 = new GridBagConstraints();
			gbc_label_7.gridwidth = 3;
			gbc_label_7.insets = new Insets(0, 0, 5, 5);
			gbc_label_7.gridx = 6;
			gbc_label_7.gridy = 8;
			p1.add(label_7, gbc_label_7);
			
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 8;
			gbc_scrollPane.gridheight = 4;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 9;
			p1.add(scrollPane, gbc_scrollPane);
			
			table_1 = new JTable();
			scrollPane.setViewportView(table_1);
			
			
			JButton confirmCured = new JButton("\u786E\u8BA4\u5C31\u8BCA");
			confirmCured.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//预约确认就诊
					Thread thread=new Thread(new CureP(patient));
					thread.start();
				}
			});
			confirmCured.setFont(new Font("宋体", Font.PLAIN, 27));
			GridBagConstraints gbc_button_1 = new GridBagConstraints();
			gbc_button_1.anchor = GridBagConstraints.WEST;
			gbc_button_1.insets = new Insets(0, 0, 5, 5);
			gbc_button_1.gridx = 2;
			gbc_button_1.gridy = 14;
			p1.add(confirmCured, gbc_button_1);
			
			JButton btnNewButton = new JButton("\u5237\u65B0");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 5;
			gbc_btnNewButton.gridy = 14;
			p1.add(btnNewButton, gbc_btnNewButton);
			
			JPanel p2 = new JPanel();
			addTab("病人信息", null, p2, null);
			GridBagLayout gbl_p2 = new GridBagLayout();
			gbl_p2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_p2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_p2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_p2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			p2.setLayout(gbl_p2);
			
			JLabel lblid_2 = new JLabel("\u8F93\u5165\u75C5\u4EBAID\uFF1A");
			lblid_2.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_lblid_2 = new GridBagConstraints();
			gbc_lblid_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblid_2.gridx = 2;
			gbc_lblid_2.gridy = 3;
			p2.add(lblid_2, gbc_lblid_2);
			
			textField = new JTextField();
			textField.setFont(new Font("Dialog", Font.PLAIN, 25));
			textField.setText("");
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.gridwidth = 3;
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 4;
			gbc_textField.gridy = 3;
			p2.add(textField, gbc_textField);
			textField.setColumns(10);
			
			JPanel p3 = new JPanel();
			addTab("我的账号", null, p3, null);
			GridBagLayout gbl_p3 = new GridBagLayout();
			gbl_p3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_p3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_p3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_p3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			p3.setLayout(gbl_p3);
			
			JLabel label_2 = new JLabel("\u7528\u6237\u540D");
			label_2.setFont(new Font("宋体", Font.PLAIN, 28));
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 3;
			gbc_label_2.gridy = 3;
			p3.add(label_2, gbc_label_2);
			
			JLabel lblNewLabel_5 = new JLabel("New label");
			lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 28));
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 6;
			gbc_lblNewLabel_5.gridy = 3;
			p3.add(lblNewLabel_5, gbc_lblNewLabel_5);
			lblNewLabel_5.setText(doc.dId);
			JLabel label_3 = new JLabel("\u59D3\u540D");
			label_3.setFont(new Font("宋体", Font.PLAIN, 28));
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.insets = new Insets(0, 0, 5, 5);
			gbc_label_3.gridx = 3;
			gbc_label_3.gridy = 5;
			p3.add(label_3, gbc_label_3);
			
			JLabel lblNewLabel_6 = new JLabel("New label");
			lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 28));
			lblNewLabel_6.setText(doc.getName());
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 6;
			gbc_lblNewLabel_6.gridy = 5;
			p3.add(lblNewLabel_6, gbc_lblNewLabel_6);
			JLabel label_4 = new JLabel("\u804C\u4F4D");
			label_4.setFont(new Font("宋体", Font.PLAIN, 28));
			GridBagConstraints gbc_label_4 = new GridBagConstraints();
			gbc_label_4.insets = new Insets(0, 0, 5, 5);
			gbc_label_4.gridx = 3;
			gbc_label_4.gridy = 7;
			p3.add(label_4, gbc_label_4);
			
			JButton button = new JButton("\u6CE8\u9500");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Client_Doctor.frame.getContentPane().removeAll();
					LoginActivity LA=new LoginActivity();
					Client_Doctor.frame.getContentPane().validate();
				}
			});
			
			JLabel lblNewLabel_7 = new JLabel("New label");
			lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 28));	
			lblNewLabel_7.setText("门诊医生");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 6;
			gbc_lblNewLabel_7.gridy = 7;
			p3.add(lblNewLabel_7, gbc_lblNewLabel_7);
			button.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 3;
			gbc_button.gridy = 13;
			p3.add(button, gbc_button);
			
			JLabel label_9 = new JLabel("\u67E5\u627E\u65F6\u95F4\uFF1A");
			label_9.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_label_9 = new GridBagConstraints();
			gbc_label_9.anchor = GridBagConstraints.WEST;
			gbc_label_9.insets = new Insets(0, 0, 5, 5);
			gbc_label_9.gridx = 2;
			gbc_label_9.gridy = 5;
			p2.add(label_9, gbc_label_9);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Dialog", Font.PLAIN, 25));
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.gridwidth = 3;
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 4;
			gbc_textField_1.gridy = 5;
			p2.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
			gbc_scrollPane_1.gridheight = 8;
			gbc_scrollPane_1.gridwidth = 11;
			gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_1.gridx = 2;
			gbc_scrollPane_1.gridy = 9;
			p2.add(scrollPane_1, gbc_scrollPane_1);

			final JTable jt = new JTable();
			scrollPane_1.setViewportView(jt);
			
			JButton button_5 = new JButton("\u67E5\u627E");
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						jt.removeAll();
						DefaultTableModel l=new DefaultTableModel();
						l.addColumn("名称");
						l.addColumn("数量");
						String sql1="select B.meName,C.meNumber from PatientHSP A,Medicine B,recipeMe C "
				               +"where A.pId='123456789123456789' and A.dId='"+doc.getdId()
							   +"' and convert(varchar(10),A.appTime,120)='"+textField_1.getText()+"' "
							   +"and A.reId=C.reId and B.meId=C.meId ";
						String sql2="select * from FeeItem where feId="
								+ "( select feId from RecipeFe where reId= "
								+ "(select reId from PatientHSP "
								+ "where pId='"+textField.getText()+"' and  "
								+ "convert(varchar(10),appTime,120) = '"
								+textField_1.getText()+"'))";
						//蔡烩编写的sql2语句
						ResultSet rs=OPDB.excuteSelect(sql1);
						while(rs.next())
						{
							Vector v1=new Vector();
							v1.addElement(rs.getString("meName"));
							v1.addElement(rs.getString("meNumber"));
							l.addRow(v1);
						}
						
						rs=OPDB.excuteSelect(sql2);
						
						while(rs.next())
						{
							Vector v2=new Vector();
							v2.addElement(rs.getString("feName"));
							l.addRow(v2);
						}
						jt.setModel(l);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			button_5.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_button_5 = new GridBagConstraints();
			gbc_button_5.gridwidth = 3;
			gbc_button_5.insets = new Insets(0, 0, 5, 5);
			gbc_button_5.gridx = 8;
			gbc_button_5.gridy = 5;
			p2.add(button_5, gbc_button_5);
			

			
			JLabel label_8 = new JLabel("\u75C5\u4EBA\u5C31\u8BCA\u4FE1\u606F");
			label_8.setFont(new Font("宋体", Font.PLAIN, 25));
			GridBagConstraints gbc_label_8 = new GridBagConstraints();
			gbc_label_8.insets = new Insets(0, 0, 5, 5);
			gbc_label_8.gridx = 2;
			gbc_label_8.gridy = 7;
			p2.add(label_8, gbc_label_8);
			
			
		}
	}
	Doctor getDoc() {
		return doc;
	}

	void setDoc(Doctor doc) {
		this.doc = doc;
	}

	Patient getPatient() {
		return patient;
	}

	void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}

