import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

public class AllFrame {

	public AllFrame(){
		Patient p=new Patient();
		Doctor d=new Doctor();
		MainFrame mframe = new MainFrame();
		IdFrame iframe = new IdFrame();
		AppFrame1 a1frame = new AppFrame1();
		AppFrame2 a2frame = new AppFrame2();

		mframe.getBtnNewButton().addActionListener(new ActionListener(){//��ԤԼ��
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mframe.dispose();
				iframe.setVisible(true);
			}
		});
		
		iframe.getBtnNewButton().addActionListener(new ActionListener(){//����һ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id=iframe.getTextField().getText();
				String rex="\\d{18}";
				if(!id.matches(rex))
					JOptionPane.showMessageDialog(null,"������18λ���֤�� ��");
				else{
					p.setpId(id);
					iframe.dispose();
					iframe.getTextField().setText("");
					if(p.check_pId())
						a1frame.setVisible(true);
					else
						a2frame.setVisible(true);
				}	
			}
		});
		iframe.getBtnNewButton_1().addActionListener(new ActionListener(){//�����ء�
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
		
		a1frame.getBtnNewButton().addActionListener(new ActionListener(){//��ȷ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a1frame.getComboBox().getSelectedItem().toString()!=""
						&&a1frame.getComboBox_1().getSelectedItem().toString()!=""
						&&a1frame.getComboBox_2().getSelectedItem().toString()!=""
						&&a1frame.getComboBox_3().getSelectedItem().toString()!="")
				{
					String dpmName=a1frame.getComboBox().getSelectedItem().toString();
					String dName=a1frame.getComboBox_1().getSelectedItem().toString();
					String t=a1frame.getComboBox_2().getSelectedItem().toString();
					String time=a1frame.getComboBox_3().getSelectedItem().toString();
					String ptime=time,ts=t;
					DBhandel a =new DBhandel();
					String sql="select dpmId from Department where dpmName='"+dpmName+"'",
							sql2="select dId from Doctor where name='"+dName+"'";
					String dpmId=a.getItem(sql, "dpmId");String dId=a.getItem(sql2, "dId");
					p.setDpmId(dpmId);p.setdId(dId);
					
					sql="select qNumber from PatientHSP where pId='"+p.getpId()+"' AND dId='"+p.getdId()+"' AND (convert(varchar(10),qTime,120)='"+time+"' or convert(varchar(10),appTime,120)='"+time+"' )";
					if(a.getItem(sql, "qNumber")!=null){
						JOptionPane.showMessageDialog(null,"ԤԼʧ�ܣ�������"+time+"ԤԼ����ҽ����");
					}
					else{
					String sql3,sql4;int number;
					int wrong=0;
					if(t=="����"){
						d.setDoctor(dId,Timestamp.valueOf(time+" 00:00:00"));
						ptime+=" 08:00:00";
						ts+="8:00~12:00";
						if(d.getPatientNumber1()<20){
							number=d.getPatientNumber1()+1;
							sql4="update DoctorDate set patientNumber1="+number+" where dId='"+dId+"'";
							a.updateItem(sql4);
						}
						else{
							JOptionPane.showMessageDialog(null,"�����Ŷ�������������ѡ�����磡");
							wrong=1;number=-1;
						}
					}
					else{
						d.setDoctor(dId,Timestamp.valueOf(time+" 00:00:00"));
						ptime+=" 13:00:00";
						ts+="13:00~17:00";
						number=d.getPatientNumber2()+1;
						sql4="update DoctorDate set patientNumber2="+number+" where dId='"+dId+"'";
						a.updateItem(sql4);
						number+=20;
					}
					if(wrong!=1){
					p.setqTime(Timestamp.valueOf(ptime));
					p.setIsVisit(1);
					p.setqNumber(number);
					p.addPatient(p);
					JOptionPane.showMessageDialog(null,"ԤԼ�ɹ���\nԤԼ���ң�"+dpmName+"\nԤԼҽ����"
					+dName+"\nԤԼ���ڣ�"+time+"\nԤԼʱ�䣺"+t+"\nԤԼ�ţ�"+number
					+"\n\n����"+ts+"ʱ���ǰ��ҽԺ���\n");
					a1frame.dispose();
					a1frame.getComboBox().setSelectedIndex(-1);a1frame.getComboBox_1().setSelectedIndex(-1);
					a1frame.getComboBox_2().setSelectedIndex(-1);a1frame.getComboBox_3().setSelectedIndex(-1);
					mframe.setVisible(true);
					p.clear();
					}
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"��ѡ��ԤԼ��Ϣ ��");
				}
			}
		});
		a1frame.getBtnNewButton_1().addActionListener(new ActionListener(){//��ȡ����
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
        a1frame.getComboBox().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				a1frame.getComboBox_1().removeAllItems();
				if(a1frame.getComboBox().getSelectedIndex()!=-1){
					String dpmName=a1frame.getComboBox().getSelectedItem().toString();
					String sql="select name from Doctor where dpmId=(select dpmId from Department where dpmName='"+dpmName+"')";
					DBhandel a =new DBhandel();
					a.addComboBox(a1frame.getComboBox_1(), sql, "name");
				}
			}
        });
		
	    a2frame.getBtnNewButton().addActionListener(new ActionListener(){//��ȷ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a2frame.getComboBox().getSelectedItem().toString()!=""
						&&a2frame.getComboBox_1().getSelectedItem().toString()!=""
						&&a2frame.getComboBox_2().getSelectedItem().toString()!=""
						&&a2frame.getComboBox_3().getSelectedItem().toString()!=""
						&&a2frame.getTextField().getText()!=""
						&&a2frame.getTextField_1().getText()!=""
						&&a2frame.getTextField_2().getText()!=""
						&&(a2frame.getRdbtnNewRadioButton().isSelected()||a2frame.getRdbtnNewRadioButton_1().isSelected()))
				{
					p.setName(a2frame.getTextField().getText());
					p.setAge(Integer.parseInt(a2frame.getTextField_1().getText()));
					if(a2frame.getRdbtnNewRadioButton().isSelected()) p.setGender("��");
					else p.setGender("Ů");
					p.setPhone(a2frame.getTextField_2().getText());
					
					String dpmName=a2frame.getComboBox().getSelectedItem().toString();
					String dName=a2frame.getComboBox_1().getSelectedItem().toString();
					String t=a2frame.getComboBox_2().getSelectedItem().toString();
					String time=a2frame.getComboBox_3().getSelectedItem().toString();
					String ptime=time,ts=t;
					DBhandel a =new DBhandel();
					String sql="select dpmId from Department where dpmName='"+dpmName+"'",
							sql2="select dId from Doctor where name='"+dName+"'";
					String dpmId=a.getItem(sql, "dpmId");String dId=a.getItem(sql2, "dId");
					p.setDpmId(dpmId);p.setdId(dId);
					String sql3,sql4;int number;
					int wrong=0;
					if(t=="����"){
						d.setDoctor(dId,Timestamp.valueOf(time+" 00:00:00"));
						ptime+=" 08:00:00";
						ts+="8:00~12:00";
						if(d.getPatientNumber1()<20){
							number=d.getPatientNumber1()+1;
							sql4="update DoctorDate set patientNumber1="+number+" where dId='"+dId+"'";
							a.updateItem(sql4);
						}
						else{
							JOptionPane.showMessageDialog(null,"�����Ŷ�������������ѡ�����磡");
							wrong=1;number=-1;
						}
					}
					else{
						d.setDoctor(dId,Timestamp.valueOf(time+" 00:00:00"));
						ptime+=" 13:00:00";
						ts+="13:00~17:00";
						number=d.getPatientNumber2()+1;
						sql4="update DoctorDate set patientNumber2="+number+" where dId='"+dId+"'";
						a.updateItem(sql4);
						number+=20;
					}
					p.setqTime(Timestamp.valueOf(ptime));
					p.setIsVisit(1);
					p.setqNumber(number);
					p.addPatient(p);
					JOptionPane.showMessageDialog(null,"ԤԼ�ɹ���\nԤԼ���ң�"+dpmName+"\nԤԼҽ����"
					+dName+"\nԤԼ���ڣ�"+time+"\nԤԼʱ�䣺"+t+"\nԤԼ�ţ�"+number
					+"\n\n����"+ts+"ʱ���ǰ��ҽԺ���\n");
					a2frame.dispose();
					a2frame.getTextField().setText("");a2frame.getTextField_1().setText("");a2frame.getTextField_2().setText("");
					a2frame.getRdbtnNewRadioButton().setSelected(false);a2frame.getRdbtnNewRadioButton_1().setSelected(false);
					a2frame.getComboBox().setSelectedIndex(-1);a2frame.getComboBox_1().setSelectedIndex(-1);
					a2frame.getComboBox_2().setSelectedIndex(-1);a2frame.getComboBox_3().setSelectedIndex(-1);
					mframe.setVisible(true);
					p.clear();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"����д��Ϣ ��");
				}
			}
	    });
        a2frame.getBtnNewButton_1().addActionListener(new ActionListener(){//��ȡ����
			@Override
			public void actionPerformed(ActionEvent e) {
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
        });
        a2frame.getComboBox().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				a2frame.getComboBox_1().removeAllItems();
				if(a2frame.getComboBox().getSelectedIndex()!=-1){
					String dpmName=a2frame.getComboBox().getSelectedItem().toString();
					String sql="select name from Doctor where dpmId=(select dpmId from Department where dpmName='"+dpmName+"')";
					DBhandel a =new DBhandel();
					a.addComboBox(a2frame.getComboBox_1(), sql, "name");
				}
			}
        });
        
	}
	
}
