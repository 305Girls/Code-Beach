import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class AllFrame {

	public AllFrame(){
		Patient p=new Patient();
		MainFrame mframe = new MainFrame();
		IdFrame iframe = new IdFrame();
		AppFrame1 a1frame = new AppFrame1();
		AppFrame2 a2frame = new AppFrame2();

		mframe.getBtnNewButton().addMouseListener(new MouseListener(){//ԤԼ
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mframe.dispose();
				iframe.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		iframe.getBtnNewButton().addMouseListener(new MouseListener(){//��һ��
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				p.setpId(iframe.getTextField().getText());
				iframe.dispose();
				iframe.getTextField().setText("");
				boolean i=false;
				if(p.check_pId(i))
					a1frame.setVisible(true);
				else
					a2frame.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		iframe.getBtnNewButton_1().addMouseListener(new MouseListener(){//����
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = { "��", "��" }; 
				int i=JOptionPane.showOptionDialog(null, "ȷ�Ϸ��أ�", "", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				if(i==JOptionPane.YES_OPTION){
					iframe.dispose();
					iframe.getTextField().setText("");
					mframe.setVisible(true);
					p.clear();
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}	
		});
		
		a1frame.getBtnNewButton().addMouseListener(new MouseListener(){//ȷ��
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(a1frame.getComboBox().getSelectedItem().toString()!=""
						&&a1frame.getComboBox_1().getSelectedItem().toString()!=""
						&&a1frame.getComboBox_2().getSelectedItem().toString()!="")
				{
					String dpmName=a1frame.getComboBox().getSelectedItem().toString();
					String dName=a1frame.getComboBox_1().getSelectedItem().toString();
					String t;
					if(a1frame.getComboBox_2().getSelectedIndex()==0) t="����";
					else t="����";
					String dpmId="",dId="";//ͨ��name�ҵ�id
					p.setDpmId(dpmId);p.setdId(dId);
					p.addPatient(p);
					int number=0;//��ȡ�ŶӺ�
					JOptionPane.showMessageDialog(null,"ԤԼ�ɹ���\nԤԼ���ң�"+dpmName+"\nԤԼҽ����"
					+dName+"\nԤԼʱ�䣺"+t+"\nԤԼ�ţ�"+number);
					a1frame.dispose();
					a1frame.getComboBox().setSelectedIndex(-1);a1frame.getComboBox_1().setSelectedIndex(-1);a1frame.getComboBox_2().setSelectedIndex(-1);
					mframe.setVisible(true);
					p.clear();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"��ѡ��ԤԼ��Ϣ ��");
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        a1frame.getBtnNewButton_1().addMouseListener(new MouseListener(){//ȡ��
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "��", "��" }; 
				int i=JOptionPane.showOptionDialog(null, "ȷ��ȡ����", "", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				if(i==JOptionPane.YES_OPTION){
					a1frame.dispose();
					a1frame.getComboBox().setSelectedIndex(-1);a1frame.getComboBox_1().setSelectedIndex(-1);a1frame.getComboBox_2().setSelectedIndex(-1);
					mframe.setVisible(true);
					p.clear();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
	    
        a2frame.getBtnNewButton().addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(a2frame.getComboBox().getSelectedItem().toString()!=""
						&&a2frame.getComboBox_1().getSelectedItem().toString()!=""
						&&a2frame.getComboBox_2().getSelectedItem().toString()!=""
						&&a2frame.getTextField().getText()!=""
						&&a2frame.getTextField_1().getText()!=""
						&&a2frame.getTextField_2().getText()!=""
						&&(a2frame.getRdbtnNewRadioButton().isSelected()||a2frame.getRdbtnNewRadioButton_1().isSelected()))
				{
					p.setName(a2frame.getTextField().getText());
					p.setAge(Integer.parseInt(a2frame.getTextField_1().getText()));
					if(a2frame.getBtnNewButton().isSelected()) p.setGender("��");
					else p.setGender("Ů");
					p.setPhone(a2frame.getTextField_2().getText());
					
					String dpmName=a2frame.getComboBox().getSelectedItem().toString();
					String dName=a2frame.getComboBox_1().getSelectedItem().toString();
					String t;
					if(a2frame.getComboBox_2().getSelectedIndex()==0) t="����";
					else t="����";
					String dpmId="",dId="";//ͨ��name�ҵ�id
					p.setDpmId(dpmId);p.setdId(dId);
					p.addPatient(p);
					int number=0;//��ȡ�ŶӺ�
					JOptionPane.showMessageDialog(null,"ԤԼ�ɹ���\nԤԼ���ң�"+dpmName+"\nԤԼҽ����"
					+dName+"\nԤԼʱ�䣺"+t+"\nԤԼ�ţ�"+number);
					a2frame.dispose();
					a2frame.getTextField().setText("");a2frame.getTextField_1().setText("");a2frame.getTextField_2().setText("");
					a2frame.getBtnNewButton().setSelected(false);a2frame.getBtnNewButton_1().setSelected(false);
					a2frame.getComboBox().setSelectedIndex(-1);a2frame.getComboBox_1().setSelectedIndex(-1);a2frame.getComboBox_2().setSelectedIndex(-1);
					mframe.setVisible(true);
					p.clear();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"����д��Ϣ ��");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        a2frame.getBtnNewButton_1().addMouseListener(new MouseListener(){//ȡ��
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "��", "��" }; 
				int i=JOptionPane.showOptionDialog(null, "ȷ��ȡ����", "", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				if(i==JOptionPane.YES_OPTION){
					a2frame.dispose();
					a2frame.getTextField().setText("");a2frame.getTextField_1().setText("");a2frame.getTextField_2().setText("");
					a2frame.getBtnNewButton().setSelected(false);a2frame.getBtnNewButton_1().setSelected(false);
					a2frame.getComboBox().setSelectedIndex(-1);a2frame.getComboBox_1().setSelectedIndex(-1);a2frame.getComboBox_2().setSelectedIndex(-1);
					mframe.setVisible(true);
					p.clear();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        
	}
	
}
