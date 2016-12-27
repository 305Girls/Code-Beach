import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class DB {
	static Connection con=null;  //连接变量
	static Statement st=null;   //语句变量
	static ResultSet rs=null;          //结果集
	
	public DB(){
		String ip=new String("localhost:1433");//数据库ip地址
		if(!open(ip))
			JOptionPane.showMessageDialog(null, "连接失败！请联系管理员！");
	}
	
	public static boolean open(String ip) {//打开连接
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://"+ip+"; DatabaseName=HospitalDB","sa","sa");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con!=null) 
			return true;
		else 
			return false;
	}
	
	public static void close() {//关闭连接
	    try {
	    	rs.close();
			st.close();
			con.close();
	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	     }
	 }
	
	public static boolean excuteIUD(String sql){//执行增删改语句
	     int n=0;
		 try {
				st=con.createStatement();
				n=st.executeUpdate(sql);			
		      } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(n!=0)
			return true;
		else 
			return false;
			
	}
	
	public static ResultSet excuteSelect(String sql) {//执行查询语句
		 try {
				st=con.createStatement();
				rs=st.executeQuery(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;
	}
	
	
	
}