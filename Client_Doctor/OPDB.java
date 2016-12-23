package main;
import java.math.*;
import java.security.Timestamp;
import java.sql.*;
import java.text.*;

class OPDB {

	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
	public static boolean open() 
	{
	 //打开连接
    try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
	      } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	      }
    
    try {
		con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=HospitalDB","sa","sa");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    if(con!=null)return true;
    else return false;
	}
	
	public static void close() 
	{//关闭连接
	 try {
   	  //rs.close();
   	     //st.close();
		con.close();
	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	     }

	   }

	public static void addPatient(Patient patient)
	{

        CallableStatement c;
		try {
			c = con.prepareCall("{call addPatient(?,?,?,?,?,?,?,?,?)}");
			//给存储过程的参数设置值
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
	public static void curePatient(Patient patient,Doctor doctor,String meName,int meNumber,String feName,java.sql.Timestamp reTime)//修改病人治疗信息
	{
		CallableStatement c;
		try {
			c = con.prepareCall("{call curePatient(?,?,?,?,?,?,?,?)}");
			//给存储过程的参数设置值
	        c.setString(1,patient.getpId());
	        c.setString(2,doctor.getdId());
	        c.setString(3,doctor.getdId()+Integer.toString(patient.getqNumber()));
	        c.setInt(4,4);
	        c.setString(5,meName);
	        c.setInt(6,meNumber);
	        c.setString(7,feName);
	        c.setTimestamp(8,reTime);
	        //执行存储过程
	        c.execute();
	        c.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}
	public static ResultSet getMeFee(Patient patient)//得到药费
	{
		CallableStatement c;
		try {
			c = con.prepareCall("{call getMeFee(?)}");
			//给存储过程的参数设置值
			c.setString(1,patient.getpId());
	        //执行存储过程
	        ResultSet rs=c.executeQuery();
	        c.close();
	        return rs;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		return null;
	}
	public static ResultSet getFeFee(Patient patient)//得到项目费用
	{
		CallableStatement c;
		try {
			c = con.prepareCall("{call getFeFee(?)}");
			//给存储过程的参数设置值
			c.setString(1,patient.getpId());
	        //执行存储过程
	        ResultSet rs=c.executeQuery();
	        c.close();
	        return rs;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		return null;
	}
	public static ResultSet excuteSelect(String sql) 
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
	public static boolean excuteIUD(String sql)
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

}
