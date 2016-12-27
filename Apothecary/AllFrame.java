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
	static String log_in;//登录信息
	static String duty="3";
	public AllFrame() throws SQLException{
		
		
		LoginFrame lframe = new LoginFrame();
		FuncFrame fframe=new FuncFrame();
		
		
		
		lframe.setVisible(true);
		lframe.getBtnNewButton().addActionListener(new ActionListener(){//“确认登陆”
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
						JOptionPane.showMessageDialog(null,"登陆成功！正在连接数据库...",null, JOptionPane.PLAIN_MESSAGE); 
						ip=is.readLine();//接收数据库地址
						//连接数据库
						if(OPDB.open(ip))
						{
							JOptionPane.showMessageDialog(null, "数据库连接成功！");
							//跳转界面
							lframe.dispose();
							fframe.setVisible(true);
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
				else
					JOptionPane.showMessageDialog(null, "请填写账号及密码！");
			}
		});
		lframe.getBtnNewButton_1().addActionListener(new ActionListener(){//“取消”
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "是", "否" }; 
				int i=JOptionPane.showOptionDialog(null, "确认重置？", "", 
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
