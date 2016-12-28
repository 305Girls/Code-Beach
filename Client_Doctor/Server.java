package main;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class Server {

	static int num=1;
	public static void main(String args[]) {
		ServerSocket server = null;
		Socket client = null;
		while(true){
			try {
				server = new ServerSocket(4444); // ����һ��ServerSocket�ڶ˿�4444�����ͻ�����
			} catch (Exception e) {
				System.out.println("Error:" + e);// ��Ļ��ӡ������Ϣ
				System.exit(-1);
			}
			try {
				client = server.accept(); // ʹ��accept()�����ȴ��ͻ������пͻ�����
				// ���������һ��Socket����
			} catch (Exception e) {
				System.out.println("��������ʧ��!");
				System.exit(-1);
			}
			System.out.println("Client"+Server.num+"��¼��");
			ServerThread st=new ServerThread(client);
			Thread t=new Thread(st);
			t.start();
			try
			{
				server.close();
			}
			catch(IOException e)
			{
				System.out.println("�ر�ʧ��!");
			}
			num++;
		}
		}
}// �������˳������

class ServerThread implements Runnable//�˺ŵ�¼�߳�
{

	private Socket client;
	public ServerThread(Socket client)
	{
		this.client=client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
		BufferedReader is = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		// ��Socket����õ�����������������Ӧ��BufferedReader����
		PrintWriter os = new PrintWriter(client.getOutputStream());
		// ��Socket����õ��������������PrintWriter����
		String id;//���յ���id
		String pwd;//���յ���pwd
		String duty;//���յ���duty
		String ip=new String("localhost:1433");//���ݿ�ip��ַ
		Connection con=null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection("jdbc:sqlserver://"+ip+"; DatabaseName=HospitalDB","sa","sa");
		if(con!=null)
			System.out.println("���ӳɹ���");
		else
			System.out.println("����ʧ�ܣ�");
		Statement st=con.createStatement();
		while(!client.isClosed())
		{
			id=is.readLine();
			pwd=is.readLine();
			duty=is.readLine();
			String sql="Select password,duty from Account where id='"+id+"'";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				if(rs.getString("password").equals(pwd))
				{
					if(rs.getString("duty").equals(duty)){
					    os.println("succeed");
						os.flush();
						os.println(ip);
						os.flush();
					}
					else{
						os.println("���޴˿ͻ��˵�¼Ȩ�ޣ�");
						os.flush();
					}
				}
				else 
				{
					os.println("�������");
					os.flush();
				}
					
			}
			else
			{
				os.println("�˺Ŵ���");
				os.flush();	
			}
			
		}
		os.close(); // �ر�Socket�����
		is.close(); // �ر�Socket������
		client.close(); // �ر�Socket
		System.out.println("�������!");
		} catch (Exception e) {
		System.out.println("Error:" + e);
	}
	}
}
