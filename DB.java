import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DB {
	static Connection con=null;  //连接变量
	static Statement st=null;   //语句变量
	static ResultSet rs=null;          //结果集
	static ArrayList<String> result=new ArrayList<String>();//结果容器
	
	
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
		con=DriverManager.getConnection("jdbc:sqlserver://192.168.1.110; DatabaseName=HospitalDB","sa","sa");
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
	    	con.close();
	        st.close();
		    rs.close();
	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	     }

	 }
	
	public boolean excuteIUD(String sql)
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
	
	public static ArrayList<String> excuteSelect(String sql) 
	//执行查询语句
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
