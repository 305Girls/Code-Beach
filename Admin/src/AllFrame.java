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

Socket server = null;
static String log_in;//��¼��Ϣ
static String duty="5";
public AllFrame(){

final LoginFrame lframe = new LoginFrame();


lframe.getBtnNewButton().addActionListener(new ActionListener(){//��ȷ�ϵ�½��
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
	 String id=lframe.getTextField().getText(),pwd=new String(lframe.getPasswordField().getPassword());
if(id!=""&&pwd!=""){
try {
server=new Socket("192.168.1.109", 4444);
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
String ip=is.readLine();//�������ݿ��ַ
//�������ݿ�
if(DB.open(ip))
{
JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ���");
//��ת����
lframe.dispose();
try {
	menudemo window = new menudemo();
	window.frmWelcome.setVisible(true);
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

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
int i=JOptionPane.showOptionDialog(null, "ȷ��ȡ����", "", 
JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
null, options, options[0]); 
if(i==JOptionPane.YES_OPTION){
lframe.getTextField().setText("");lframe.getPasswordField().setText("");
}
}
});



}
}