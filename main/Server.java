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
				server = new ServerSocket(4444); // 创建一个ServerSocket在端口4444监听客户请求
			} catch (Exception e) {
				System.out.println("Error:" + e);// 屏幕打印出错信息
				System.exit(-1);
			}
			try {
				client = server.accept(); // 使用accept()阻塞等待客户请求，有客户请求
				// 到来则产生一个Socket对象
			} catch (Exception e) {
				System.out.println("接受请求失败!");
				System.exit(-1);
			}
			System.out.println("Client"+Server.num+"登录！");
			ServerThread st=new ServerThread(client);
			Thread t=new Thread(st);
			t.start();
			try
			{
				server.close();
			}
			catch(IOException e)
			{
				System.out.println("关闭失败!");
			}
			num++;
		}
		}
}// 服务器端程序结束

class ServerThread implements Runnable//账号登录线程
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
		// 由Socket对象得到输入流，并构造相应的BufferedReader对象
		PrintWriter os = new PrintWriter(client.getOutputStream());
		// 由Socket对象得到输出流，并构造PrintWriter对象
		String id;//接收到的id
		String pwd;//接收到的pwd
		String duty;//接收到的duty
		String ip=new String("localhost:1433");//数据库ip地址
		Connection con=null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection("jdbc:sqlserver://"+ip+"; DatabaseName=HospitalDB","sa","sa");
		if(con!=null)
			System.out.println("连接成功！");
		else
			System.out.println("连接失败！");
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
						os.println("您无此客户端登录权限！");
						os.flush();
					}
				}
				else 
				{
					os.println("密码错误！");
					os.flush();
				}
					
			}
			else
			{
				os.println("账号错误！");
				os.flush();	
			}
			
		}
		os.close(); // 关闭Socket输出流
		is.close(); // 关闭Socket输入流
		client.close(); // 关闭Socket
		System.out.println("聊天结束!");
		} catch (Exception e) {
		System.out.println("Error:" + e);
	}
	}
}
