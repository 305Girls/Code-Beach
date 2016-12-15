import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DB {
	static Connection con=null;  //���ӱ���
	static Statement st=null;   //������
	static ResultSet rs=null;          //�����
	static ArrayList<String> result=new ArrayList<String>();//�������
	
	
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
		con=DriverManager.getConnection("jdbc:sqlserver://192.168.1.110; DatabaseName=HospitalDB","sa","sa");
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
	    	con.close();
	        st.close();
		    rs.close();
	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	     }

	 }
	
	public boolean excuteIUD(String sql)
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
	
	public static ArrayList<String> excuteSelect(String sql) 
	//ִ�в�ѯ���
	{
		 try {
				st=con.createStatement();
				st.executeUpdate(sql);
				rs=st.executeQuery(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 try {
		 int row=rs.getRow();
		 for(int i=0;i<row;i++)
			 result.add(rs.getString(i));
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		return result;
	}
	
	
	
}
