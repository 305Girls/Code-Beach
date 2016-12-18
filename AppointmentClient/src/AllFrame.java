import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

		mframe.getBtnNewButton().addActionListener(new ActionListener(){//“预约”
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mframe.dispose();
				iframe.setVisible(true);
			}
		});
		
		iframe.getBtnNewButton().addActionListener(new ActionListener(){//“下一步”
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
		iframe.getBtnNewButton_1().addActionListener(new ActionListener(){//“返回”
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "是", "否" }; 
				int i=JOptionPane.showOptionDialog(null, "确认返回？", "", 
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
		
		a1frame.getBtnNewButton().addActionListener(new ActionListener(){//“确定”
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a1frame.getComboBox().getSelectedItem().toString()!=""
						&&a1frame.getComboBox_1().getSelectedItem().toString()!=""
						&&a1frame.getComboBox_2().getSelectedItem().toString()!="")
				{
					String dpmName=a1frame.getComboBox().getSelectedItem().toString();
					String dName=a1frame.getComboBox_1().getSelectedItem().toString();
					String t;
					if(a1frame.getComboBox_2().getSelectedIndex()==0) t="上午";
					else t="下午";
					String dpmId="",dId="";//通过name找到id
					p.setDpmId(dpmId);p.setdId(dId);
					p.addPatient(p);
					int number=0;//获取排队号
					JOptionPane.showMessageDialog(null,"预约成功！\n预约科室："+dpmName+"\n预约医生："
					+dName+"\n预约时间："+t+"\n预约号："+number);
					a1frame.dispose();
					a1frame.getComboBox().setSelectedIndex(-1);a1frame.getComboBox_1().setSelectedIndex(-1);a1frame.getComboBox_2().setSelectedIndex(-1);
					mframe.setVisible(true);
					p.clear();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"请选择预约信息 ！");
				}
			}
		});
		a1frame.getBtnNewButton_1().addActionListener(new ActionListener(){//“取消”
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "是", "否" }; 
				int i=JOptionPane.showOptionDialog(null, "确认取消？", "", 
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
        
	    a2frame.getBtnNewButton().addActionListener(new ActionListener(){//“确定”
			@Override
			public void actionPerformed(ActionEvent e) {
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
					if(a2frame.getBtnNewButton().isSelected()) p.setGender("男");
					else p.setGender("女");
					p.setPhone(a2frame.getTextField_2().getText());
					
					String dpmName=a2frame.getComboBox().getSelectedItem().toString();
					String dName=a2frame.getComboBox_1().getSelectedItem().toString();
					String t;
					if(a2frame.getComboBox_2().getSelectedIndex()==0) t="上午";
					else t="下午";
					String dpmId="",dId="";//通过name找到id
					p.setDpmId(dpmId);p.setdId(dId);
					p.addPatient(p);
					int number=0;//获取排队号
					JOptionPane.showMessageDialog(null,"预约成功！\n预约科室："+dpmName+"\n预约医生："
					+dName+"\n预约时间："+t+"\n预约号："+number);
					a2frame.dispose();
					a2frame.getTextField().setText("");a2frame.getTextField_1().setText("");a2frame.getTextField_2().setText("");
					a2frame.getBtnNewButton().setSelected(false);a2frame.getBtnNewButton_1().setSelected(false);
					a2frame.getComboBox().setSelectedIndex(-1);a2frame.getComboBox_1().setSelectedIndex(-1);a2frame.getComboBox_2().setSelectedIndex(-1);
					mframe.setVisible(true);
					p.clear();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"请填写信息 ！");
				}
			}
	    });
        a2frame.getBtnNewButton_1().addActionListener(new ActionListener(){//“取消”
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "是", "否" }; 
				int i=JOptionPane.showOptionDialog(null, "确认取消？", "", 
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
        
        
	}
	
}
