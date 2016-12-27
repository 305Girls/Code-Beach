import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class FuncFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u53D6\u836F\u8EAB\u4EFD\u8BC1\u53F7");
	private final JButton button = new JButton("\u641C\u7D22");
	private final JButton button_2 = new JButton("\u786E\u8BA4\u53D6\u836F");
	private static JTextField textField_1 = new JTextField();
	private final JButton button_3 = new JButton("\u53D6\u6D88\u53D6\u836F");
	private int labelNull=1;   //��������
	private final JLabel lblyymmdd = new JLabel("\u5904\u65B9\u65E5\u671F(yy-mm-dd)");
	private static JTextField textField_2 = new JTextField();
	private final JButton btnNewButton = new JButton("\u91CD\u7F6E");
	private final JComboBox comboBox = new JComboBox();
	public String inputDate=textField_2.getText();
	public String reId = null;
	private  JTable table_1 = new JTable();
	public JScrollPane scrollPane = new JScrollPane();
	public JTextField getTextField() {
		return textField_1;
	}
	public void setTextField(JTextField textField) {
		this.textField_1 = textField;
	}
	
	public JButton getBtnNewButton() {
		return button_3;
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FuncFrame() throws SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		

		boolean flag=OPDB.open(AllFrame.ip);
		System.out.println("���ݿ�����"+flag);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 3;
		
		panel.add(comboBox, gbc_comboBox);
		
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 5, 5);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 1;
		gbc_table_1.gridy = 4;
		
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 230, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 8;
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 5;
		gbc_button.gridy = 8;
		button.setFont(new Font("����", Font.PLAIN, 15));
		

		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//ȷ�ϲ������֤�Ű�ť�Ĵ����¼�	
				
				String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
				inputDate=textField_2.getText();
				boolean match=inputDate.matches(regex);
            	 if(!match)
            	 { JOptionPane.showMessageDialog(null, "����������yyyy-MM-dd");
       	          return;  
            	 }
            	 labelNull=1; 
				 ResultSet r2;
				 String sql2="select  distinct A.reId "+
					        "from PatientHSP A,Medicine B,recipeMe C "+
					        "where A.pId='"+ textField_1.getText() +"' and convert(varchar(10),C.retime,120) like '"+  
					        inputDate+"%' and A.reId=C.reId and B.meId=C.meId";
				 
				 r2=OPDB.excuteSelect(sql2);
				 final DefaultComboBoxModel cm=new DefaultComboBoxModel();
				 try {
					 while(r2.next())
					 {
					 cm.addElement(r2.getString("reId"));
					 labelNull=0; 
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 comboBox.setModel(cm);
				
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			//�������Ĵ����¼�,����reId
				public void actionPerformed(ActionEvent arg0) {
						 //int i = comboBox.getSelectedIndex();
					int n=comboBox.getSelectedIndex();
					if(n!=-1)
						reId=(String) comboBox.getSelectedItem();
						   
					System.out.println(reId);
					
					int label=0;   //���¿���־

					String sql0;//���ҵ��첡��ҩƷ��¼
					String sql1;//���¿��
					ResultSet r0=null;  //���˼�¼�����
					ResultSet r1=null;  //���˴������־λ�����
					Boolean update=false;//��ѯ�����־
					
					scrollPane.setBounds(230, 60, 400, 183);
					
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
					gbc_scrollPane.gridx = 0;
					gbc_scrollPane.gridy = 0;
					panel.add(scrollPane, gbc_scrollPane);
					
					JTable table = new JTable();
			
					final DefaultTableModel m=new DefaultTableModel();
					m.addColumn("ҩƷ����");
					m.addColumn("ҩƷ�۸�");
					m.addColumn("ҩƷ���");
					m.addColumn("ȡҩ����");
					table.setFont(new Font("����", Font.PLAIN, 12));
					
					sql0="select  B.meName,B.mePrize,B.meCount,C.meNumber "+
			        "from PatientHSP A,Medicine B,recipeMe C "+
			        "where A.pId='"+ textField_1.getText() +"' and A.reId='"+reId+"' and convert(varchar(10),C.retime,120) like '"+  
			        inputDate+"%' and A.reId=C.reId and B.meId=C.meId";
					
				
				    labelNull=1;  //1��ʾΪ��*/
					r0=OPDB.excuteSelect(sql0);
						
					try {
						while(r0.next())
						{
						Vector v=new Vector();
						labelNull=0;  //0��ʾ�ǿ�
						if(r0.getInt("meCount")<r0.getInt("meNumber"))
						{
							label=1;//������
							sql1= "update Medicine set meCount=100 where meName='"+r0.getString("meName")+"'";
							update=OPDB.excuteIUD(sql1);
							if(update)System.out.println("��治�㣬�Ѳ���");
									
						}
								
							v.addElement(r0.getString("meName"));
							v.addElement(r0.getString("mePrize"));
								
								
							if(label==1)	
							v.addElement(100);
							else 
							v.addElement(r0.getString("meCount"));
								
							v.addElement(r0.getString("meNumber"));
							m.addRow(v);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				
						table_1.setModel(m);
					    scrollPane.setViewportView(table_1);
					
				}
			});
		
		button_2.setFont(new Font("����", Font.PLAIN, 15));
		button_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	    //ȷ��ȡҩ�ļ���
			    String sql0;
				String sql1;  //������
				String sql2;  //ȡҩ����¿��
				String sql3;  //�鿴��־λ
				String sql4;   //������ҩ��־λ
				Boolean update1=false;
				Boolean update2=false;
				Boolean update3=false;
				Boolean update4=false;
				
				ResultSet r0=null;
				ResultSet r1=null;
				Date date=new Date(System.currentTimeMillis()); 
				String inputDate=textField_2.getText();
				//System.out.println(time);
				
				
				
				sql0="select  B.meName,B.mePrize,B.meCount,C.meNumber "+
		           "from PatientHSP A,Medicine B,recipeMe C "+
		           "where A.pId='"+ textField_1.getText() +"' and A.reId='"+reId+"' and convert(varchar(10),C.retime,120) like '"+  
		            inputDate+"%' and A.reId=C.reId and B.meId=C.meId";
			
				if(labelNull==1)
				
					{JOptionPane.showMessageDialog(null, "�޼�¼������ȡҩ��");
					  return;
					}
					
				else{
				
					try {sql3=" select IsVisit,isTake from PatientHSP where PId='"+textField_1.getText()  +"' and reId='"+reId+"'";
						r1=OPDB.excuteSelect(sql3);
						if(r1.next())
						{
						if(r1.getInt("IsVisit")!=4) 
							{JOptionPane.showMessageDialog(null, "���˻�δ���");return;}
						if(r1.getInt("isTake")==0) 
						{JOptionPane.showMessageDialog(null, "�����޴�����¼��");return;}
						if(r1.getInt("isTake")==1) 
						{JOptionPane.showMessageDialog(null, "���˻�δ���");return;}
							if(r1.getInt("isTake")==3) 
							{JOptionPane.showMessageDialog(null, "������ȡ��ҩ��");return;}
						}
							r0=OPDB.excuteSelect(sql0);
							while(r0.next())
							{
							//Vector v=new Vector();
							/*if(r0.getInt("meCount")<r0.getInt("meNumber"))
									{
									label=1;//������
									sql1= "update Medicine set meCount=100 where meName='"+r0.getString("meName")+"'";
									update1=OPDB.excuteIUD(sql1);
								    if(update1)System.out.println("��治�㣬�Ѳ���");
									
									}*/
							
							sql2="update Medicine set meCount=meCount-'"+r0.getInt("meNumber")+"' where meName='"+r0.getString("meName")+"'";
						    update2=OPDB.excuteIUD(sql2);
						    if(update2)System.out.println("�Ѹ��¿��");
						    System.out.println(update2);
						    sql4="update PatientHSP set isTake=3 where PId='"+textField_1.getText()  +"' and reId='"+reId+"'";
						    update4=OPDB.excuteIUD(sql4);
						    //if(update4)System.out.println("�Ѹ�״̬λ");
						    //System.out.println(update4);
						  
						  }
							JOptionPane.showMessageDialog(null, "ȡҩ�ɹ���");
						}catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
						}
						
					}
				
			}
		});
		textField_1.setColumns(10);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 8;
		panel.add(textField_1, gbc_textField_1);
		
		panel.add(button, gbc_button);
		
		GridBagConstraints gbc_lblyymmdd = new GridBagConstraints();
		gbc_lblyymmdd.anchor = GridBagConstraints.EAST;
		gbc_lblyymmdd.insets = new Insets(0, 0, 5, 5);
		gbc_lblyymmdd.gridx = 1;
		gbc_lblyymmdd.gridy = 9;
		lblyymmdd.setFont(new Font("����", Font.PLAIN, 18));
		panel.add(lblyymmdd, gbc_lblyymmdd);
		
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.EAST;
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 11;
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 9;
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//���ð�ť�Ĵ����¼�
				Object[] options = { "��", "��" }; 
				int i=JOptionPane.showOptionDialog(null, "ȷ�����ã�", "", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				
				if(i==JOptionPane.YES_OPTION)
					{FuncFrame.textField_1.setText("");
					FuncFrame.textField_2.setText("");
					}
					
			}
		});
		
		textField_2.setColumns(10);
		
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 9;
		panel.add(textField_2, gbc_textField_2);
		
		
		
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		panel.add(btnNewButton, gbc_btnNewButton);
		panel.add(button_2, gbc_button_2);
		
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 11;
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//ȡ��ȡҩ
				
				Object[] options = { "��", "��" }; 
				int i=JOptionPane.showOptionDialog(null, "ȷ��ȡ����", "", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				
				if(i==JOptionPane.YES_OPTION)
				{
					
					    String sql0;
						String sql1;  //������
						String sql2;  //ȡҩ����¿��
						String sql3;  //�鿴��־λ
						String sql4;   //������ҩ��־λ
						int label=0;
						Boolean update1=false;
						Boolean update2=false;
						Boolean update3=false;
						Boolean update4=false;
						//String sql0="select ";
						ResultSet r0=null;
						ResultSet r1=null;
						Date date=new Date(System.currentTimeMillis()); 
						String inputDate=textField_2.getText();
						//System.out.println(time);
						
						sql0="select  B.meName,B.mePrize,B.meCount,C.meNumber "+
				                   "from PatientHSP A,Medicine B,recipeMe C "+
				                   "where A.pId='"+ textField_1.getText() + "' and A.reId='"+reId+"' and convert(varchar(10),C.retime,120) like '"+  
				                   inputDate+"%' and A.reId=C.reId and B.meId=C.meId";
						r0=OPDB.excuteSelect(sql0);
						
						
						
						if(labelNull==1)
						
							{JOptionPane.showMessageDialog(null, "�޼�¼��������Ч��");
							  return;
							}
							
						else{
							try {
									
									sql3=" select IsVisit,isTake from PatientHSP where PId='"+textField_1.getText()  +"' and reId='"+reId+"'";
									r1=OPDB.excuteSelect(sql3);
									if(r1.next())
									{
									if(r1.getInt("IsVisit")!=4) 
										{JOptionPane.showMessageDialog(null, "���˻�δ���");return;}
									if(r1.getInt("isTake")!=3) 
									{JOptionPane.showMessageDialog(null, "���˻�δȡҩ��");return;}
									}
									
									
									r0=OPDB.excuteSelect(sql0);
									while(r0.next()){
										//Vector v=new Vector();
										
									
									sql2="update Medicine set meCount=meCount+'"+r0.getString("meNumber")+"' where meName='"+r0.getString("meName")+"'";
								    update2=OPDB.excuteIUD(sql2);
								    //if(update2)System.out.println("�ѳ����Կ��Ĳ������");
								    //System.out.println(update2);
								    sql4="update PatientHSP set isTake=2 where PId='"+textField_1.getText() +"' and reId='"+reId+"'";
								    update4=OPDB.excuteIUD(sql4);
								    //if(update4)System.out.println("�ѳ�����״̬λ�Ĳ���");
								    //System.out.println(update4);
								  
								  }
									JOptionPane.showMessageDialog(null, "ȡ���ɹ���");
								}catch (SQLException ex) {
									// TODO Auto-generated catch block
									ex.printStackTrace();
								
								}
							}
			
				}
				
				
			}
		});
		
		button_3.setFont(new Font("����", Font.PLAIN, 15));
		panel.add(button_3, gbc_button_3);
		
		GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
		gbc_btnNewButton1.gridx = 6;
		gbc_btnNewButton1.gridy = 7;
		

    }
}
