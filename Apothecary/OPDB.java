import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OPDB {
	static Connection con=null;  //连接变量
	static Statement st=null;    //语句变量
	static ResultSet rs=null;    //结果集
	
	
	
	String sql="";
	public static boolean open(String ip) 
	{
	 //打开连接
    try {
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
	      } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	      }
    
    try {
		con=DriverManager.getConnection("jdbc:sqlserver://"+ip+"; DatabaseName=HospitalDB","sa","sa");
	} catch (SQLException e) {
		// TODO Auto-generated catch blockd
		e.printStackTrace();
	}
    if(con!=null)return true;
    else return false;
	}
	
	
	
	public static void close() 
	{//关闭连接
	    try {
	    	con.close();
	        st.close();
		    rs.close();
	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	     }

	 }
	
	public  static boolean excuteIUD(String sql)
	//执行增删改语句
	{    int n=0;
		 try {
				st=con.createStatement();
				n=st.executeUpdate(sql);
				
		      } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(n!=0)return true;
		return false;
			
	}
	
	public static  ResultSet excuteSelect(String sql) 
	//执行查询语句
	{
		 try {
				st=con.createStatement();
                rs=st.executeQuery(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return rs;
	}
	
	
	public static void addPatient(Patient patient)
	{//增加病人信息

        CallableStatement c;
		try {
			c = con.prepareCall("{call addPatient(?,?,?,?,?,?,?,?,?)}");
			//给存储过程的第一个参数设置值
	        c.setString(1,patient.getpId());
	        c.setString(2,patient.getName());
	        c.setInt(3,patient.getAge());
	        c.setString(4,patient.getGender());
	        c.setString(5,patient.getPhone());
	        c.setString(6,patient.getDpmId());
	        c.setString(7,patient.getdId());
	        c.setTimestamp(8,patient.getAppTime());
	        c.setInt(9,patient.getqNumber());
	        //执行存储过程
	        c.execute();
	        c.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}

	
	
	
}

