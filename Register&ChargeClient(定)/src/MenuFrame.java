import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;

public class MenuFrame extends JFrame {
	
	AddPatientFrame af=new AddPatientFrame();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final RegisterPanel panel = new RegisterPanel();
	private final ChargePanel panel_1 = new ChargePanel();
	private final InfoPanel panel_2;
	public InfoPanel getPanel_2() {
		return panel_2;
	}
	/**
	 * Create the frame.
	 */
	public MenuFrame(Cashier c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 0, 1200, 750);
		tabbedPane.setFont(new Font("����", Font.PLAIN, 15));
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("  �Һ�  ", null, panel, null);
		
		tabbedPane.addTab("  �շ�  ", null, panel_1, null);
		
		panel_2 = new InfoPanel(c);
		tabbedPane.addTab("�ҵ���Ϣ", null, panel_2, null);
		
		panel.getBtnNewButton_3().addActionListener(new ActionListener(){//��ȷ�ϡ�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimeHandel t=new TimeHandel();
		        String date =t.getNowDate(); 
				String id=panel.getTextField().getText();
				String rex="\\d{18}";
				if(!id.matches(rex))
					JOptionPane.showMessageDialog(null,"������18λ���֤�� ��");
				else{
					panel.p.setpId(id);
					DBhandel a =new DBhandel();
					String sql="select dpmName from Department";
					a.addComboBox(panel.getComboBox(),sql,"dpmName");
					if(panel.p.check_pId()){//��鲡���Ƿ�Ǽǻ�����Ϣ
						panel.p.getInfo();//����������Ϣ
						panel.getButton().setVisible(true);panel.getBtnNewButton_4().setVisible(true);
						if(panel.p.getHSP(date)==1){//����������ԤԼ��δ���ѵ�ԤԼ
							panel.getBtnNewButton_3().setVisible(false);panel.getTextField().setEnabled(false);
							panel.getLblNewLabel_6().setVisible(true);panel.getLblNewLabel_7().setVisible(true);
							panel.getLblNewLabel_9().setVisible(true);panel.getLblNewLabel_5().setVisible(true);
							panel.getLblNewLabel_4().setVisible(true);panel.getLblNewLabel_10().setVisible(true);
							panel.getLblNewLabel_11().setVisible(true);panel.getLblNewLabel_12().setVisible(true);
							panel.getComboBox_2().setVisible(true);
							panel.getComboBox_2().addItem("");
							for(int i=0;i<panel.p.getDpm().length;i++)
								panel.getComboBox_2().addItem(i+1);
						}
						else{
							panel.getBtnNewButton_3().setVisible(false);panel.getTextField().setEnabled(false);
							panel.getLblNewLabel_1().setVisible(true);panel.getLblNewLabel_2().setVisible(true);
							panel.getComboBox().setVisible(true);panel.getComboBox_1().setVisible(true);
						}
					}
					else{//����δ�Ǽǻ�����Ϣ
						panel.getBtnNewButton_3().setVisible(false);panel.getTextField().setEnabled(false);
						af.setVisible(true);
					}
				}	
			}
		});
		
		
		af.getBtnNewButton().addActionListener(new ActionListener(){//��Ӳ�����Ϣ--��ȷ����ӡ�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(af.getTextField_3().getText()!=""
						&&af.getTextField_1().getText()!=""
						&&af.getTextField_2().getText()!=""
						&&(af.getRdbtnNewRadioButton().isSelected()||af.getRdbtnNewRadioButton_1().isSelected()))
				{
					panel.p.setName(af.getTextField_1().getText());
					panel.p.setAge(Integer.parseInt(af.getTextField_2().getText()));
					if(af.getRdbtnNewRadioButton().isSelected()) panel.p.setGender("��");
					else panel.p.setGender("Ů");
					panel.p.setPhone(af.getTextField_2().getText());
					JOptionPane.showMessageDialog(null,"��ӳɹ���");
					af.getTextField_1().setText("");af.getTextField_2().setText("");af.getTextField_3().setText("");
					af.getRdbtnNewRadioButton().setSelected(false);af.getRdbtnNewRadioButton_1().setSelected(false);
					af.dispose();
					panel.getLblNewLabel_1().setVisible(true);panel.getLblNewLabel_2().setVisible(true);
					panel.getComboBox().setVisible(true);panel.getComboBox_1().setVisible(true);
					panel.getButton().setVisible(true);panel.getBtnNewButton_4().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"����д��Ϣ ��");
				}
			}
		});
		af.getBtnNewButton_1().addActionListener(new ActionListener(){//��Ӳ�����Ϣ--��ȡ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "��", "��" }; 
				int i=JOptionPane.showOptionDialog(null, "ȷ��ȡ����", "", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				if(i==JOptionPane.YES_OPTION){
					af.getTextField_1().setText("");af.getTextField_2().setText("");af.getTextField_3().setText("");
					af.getRdbtnNewRadioButton().setSelected(false);af.getRdbtnNewRadioButton_1().setSelected(false);
					af.dispose();
					panel.getBtnNewButton_3().setVisible(true);
					panel.getTextField().setEnabled(true);panel.getTextField().setText("");
				}
			}
		});
		
	}

}
