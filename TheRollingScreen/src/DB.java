import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class DB {
	static Connection con=null;  //���ӱ���
	static Statement st=null;   //������
	static ResultSet rs=null;          //�����
	
	public DB(){
		String ip=new String("localhost:1433");//���ݿ�ip��ַ
		if(!open(ip))
			JOptionPane.showMessageDialog(null, "����ʧ�ܣ�����ϵ����Ա��");
	}
	
	public static boolean open(String ip) {//������
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
	
	public static void close() {//�ر�����
	    try {
	    	rs.close();
			st.close();
			con.close();
	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	     }
	 }
	
	public static boolean excuteIUD(String sql){//ִ����ɾ�����
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
	
	public static ResultSet excuteSelect(String sql) {//ִ�в�ѯ���
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