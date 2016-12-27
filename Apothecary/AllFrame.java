import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AllFrame {
	public static String ip;
	Socket server = null;
	static String log_in;//��¼��Ϣ
	static String duty="3";
	public AllFrame() throws SQLException{
		
		
		LoginFrame lframe = new LoginFrame();
		FuncFrame fframe=new FuncFrame();
		
		
		
		lframe.setVisible(true);
		lframe.getBtnNewButton().addActionListener(new ActionListener(){//��ȷ�ϵ�½��
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			String id=lframe.getTextField().getText(),pwd=new String(lframe.getPasswordField().getPassword());
				if(id!=""&&pwd!=""){
					try {
					server=new Socket("192.168.1.109", 4444);//127.0.0.1
					PrintWriter os = new PrintWriter(server.getOutputStream());
					BufferedReader is= new BufferedReader(new InputStreamReader(server.getInputStream()));
					os.println(id);
					os.flush();
					os.println(pwd);
					os.flush();
					os.println(duty);
					os.flush();
					log_in=is.readLine();
					if(log_in.matches("succeed"))
					{
						JOptionPane.showMessageDialog(null,"��½�ɹ��������������ݿ�...",null, JOptionPane.PLAIN_MESSAGE); 
						ip=is.readLine();//�������ݿ��ַ
						//�������ݿ�
						if(OPDB.open(ip))
						{
							JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ���");
							//��ת����
							lframe.dispose();
							fframe.setVisible(true);
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null,log_in, "ERROR", JOptionPane.ERROR_MESSAGE); 
					}
					os.close();// �ر�Socket�����
					is.close();// �ر�Socket������
					server.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else
					JOptionPane.showMessageDialog(null, "����д�˺ż����룡");
			}
		});
		lframe.getBtnNewButton_1().addActionListener(new ActionListener(){//��ȡ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "��", "��" }; 
				int i=JOptionPane.showOptionDialog(null, "ȷ�����ã�", "", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, options, options[0]); 
				if(i==JOptionPane.YES_OPTION){
				
					lframe.getTextField().setText("");
					lframe.getPasswordField().setText("");
					
				}
			}
		});
		
	}

		
	
	public static void main(String[] args) throws SQLException 
	{
		
		
		AllFrame a=new AllFrame();
	}
}
