import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OPDB {
	static Connection con=null;  //���ӱ���
	static Statement st=null;    //������
	static ResultSet rs=null;    //�����
	
	
	
	String sql="";
	public static boolean open(String ip) 
	{
	 //������
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
	{//�ر�����
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
	
	public static  ResultSet excuteSelect(String sql) 
	//ִ�в�ѯ���
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
	{//���Ӳ�����Ϣ

        CallableStatement c;
		try {
			c = con.prepareCall("{call addPatient(?,?,?,?,?,?,?,?,?)}");
			//���洢���̵ĵ�һ����������ֵ
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

	
	
	
}

