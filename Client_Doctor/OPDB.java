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
	 //������
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
	{//�ر�����
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
			//���洢���̵Ĳ�������ֵ
	        c.setString(1,patient.getpId());
	        c.setString(2,patient.getName());
	        c.setInt(3,patient.getAge());
	        c.setString(4,patient.getGender());
	        c.setString(5,patient.getPhone());
	        c.setString(6,patient.getDpmId());
	        c.setString(7,patient.getdId());
	        c.setTimestamp(8,patient.getAppTime());
	        c.setInt(9,patient.getqNumber());
	        //ִ�д洢����
	        c.execute();
	        c.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}
	public static void curePatient(Patient patient,Doctor doctor,String meName,int meNumber,String feName,java.sql.Timestamp reTime)//�޸Ĳ���������Ϣ
	{
		CallableStatement c;
		try {
			c = con.prepareCall("{call curePatient(?,?,?,?,?,?,?,?)}");
			//���洢���̵Ĳ�������ֵ
	        c.setString(1,patient.getpId());
	        c.setString(2,doctor.getdId());
	        c.setString(3,doctor.getdId()+Integer.toString(patient.getqNumber()));
	        c.setInt(4,4);
	        c.setString(5,meName);
	        c.setInt(6,meNumber);
	        c.setString(7,feName);
	        c.setTimestamp(8,reTime);
	        //ִ�д洢����
	        c.execute();
	        c.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}
	public static ResultSet getMeFee(Patient patient)//�õ�ҩ��
	{
		CallableStatement c;
		try {
			c = con.prepareCall("{call getMeFee(?)}");
			//���洢���̵Ĳ�������ֵ
			c.setString(1,patient.getpId());
	        //ִ�д洢����
	        ResultSet rs=c.executeQuery();
	        c.close();
	        return rs;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		return null;
	}
	public static ResultSet getFeFee(Patient patient)//�õ���Ŀ����
	{
		CallableStatement c;
		try {
			c = con.prepareCall("{call getFeFee(?)}");
			//���洢���̵Ĳ�������ֵ
			c.setString(1,patient.getpId());
	        //ִ�д洢����
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
	//ִ����ɾ�����
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
