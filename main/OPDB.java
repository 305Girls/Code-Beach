package main;
import java.math.*;
import java.security.Timestamp;
import java.sql.*;
import java.text.*;
import java.util.Date;

class OPDB {

	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
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
	public static void curePatient(Patient patient,Doctor doctor,String[] meName,int[] meNumber,String[] feName,java.sql.Timestamp reTime)//修改病人治疗信息
	{

		try {

			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strReTime=format.format(reTime);
			String timeNow=format.format(reTime).replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
			String reId=doctor.getdId()+timeNow+patient.getpId();//reId格式
			Patient p=new Patient();
			System.out.println(patient.getpId());
			String sql="select * from PatientHSP where pId='"+patient.getpId()+"' "
					+ "and (convert(varchar(10),appTime,120) = convert(varchar(10),'"+strReTime+"',120) or "
					+ " convert(varchar(10),qTime,120) = convert(varchar(10),'"+strReTime+"',120)) "
					+ "and dId = '"+doctor.getdId()+"' ";
			ResultSet rs=OPDB.excuteSelect(sql);
			if(rs.next())
			{
				p.setpId(rs.getString("pId"));
				p.setDpmId(rs.getString("dpmId"));
				p.setdId(rs.getString("dId"));
				p.setAppTime(rs.getTimestamp("appTime"));
				p.setqNumber(rs.getInt("qNumber"));
				p.setReld(rs.getString("reId"));
				p.setIsVisit(rs.getInt("isVisit"));
				p.setIsTake(rs.getInt("isTake"));
				p.setIsDo(rs.getInt("isDo"));
				p.setqTime(rs.getTimestamp("qTime"));
			}
			if(p.getReld()==null)//第一次治疗
			{
				System.out.println(reId);
				System.out.println(strReTime);
				System.out.println(p.getpId());
				System.out.println(doctor.getdId());
				sql="update PatientHSP set reId='"+reId+"',isVisit=4 "
						+ "where pId='"+p.getpId()+"' and dId='"+doctor.getdId()+"' "
								+ "and (convert(varchar(10),appTime,120) = convert(varchar(10),'"+strReTime+"',120) or "
								+ " convert(varchar(10),qTime,120) = convert(varchar(10),'"+strReTime+"',120)) ";
				if(OPDB.excuteIUD(sql)) 
					System.out.println("更新病人信息成功");
				if(meName.length!=0&&meNumber.length!=0)//加药
				{
					System.out.println("加药1：");
					for(int i=0;i<meName.length;i++)
					{
						 String meId=null;
							sql="select meId from Medicine where meName='"+meName[i]+"'";
							rs=OPDB.excuteSelect(sql);
							if(rs.next())
								meId=rs.getString("meId");
						    sql="Insert into recipeMe values ( "
						    		+ " '"+reId+"','"+meId+"',"+meNumber[i]+",'"+strReTime+"')";
						    OPDB.excuteIUD(sql);
						    sql="update PatientHSP set isTake=1 "
									+ "where pId='"+p.getpId()+"' and dId='"+doctor.getdId()+"' "
									+ "and reId='"+reId+"'";
					
						    OPDB.excuteIUD(sql);
					}
				}
				if(feName.length!=0)//加项目
				{
					System.out.println("加处方1：");
					for(int i=0;i<feName.length;i++)
					{
						 String feId=null;
							sql="select feId from FeeItem where feName='"+feName[i]+"'";
							rs=OPDB.excuteSelect(sql);
							if(rs.next())
								feId=rs.getString("feId");
						    sql="Insert into recipeFe values ( "
						    		+ " '"+reId+"','"+feId+"','"+strReTime+"')";
						    OPDB.excuteIUD(sql);
						    sql="update PatientHSP set isDo=1 "
									+ "where pId='"+p.getpId()+"' and dId='"+doctor.getdId()+"' "
									+"and reId='"+reId+"'";
					
						    OPDB.excuteIUD(sql);
					}				   
				}
			}
			else//不是第一次开处方
			{
				System.out.println("添加新处方:");
				System.out.println(reId);
				System.out.println(p.getpId());
				System.out.println(doctor.getdId());
				//添加处方信息
				if(p.getAppTime()==null)
				{
					System.out.println("预约病人");
					sql="Insert into PatientHSP values "
							+ "( '"+p.getpId()+"', '"
							+p.getDpmId()+"', '"
							+p.getdId()+"',null,"
							+p.getqNumber()+",null,4,0,0,'"
							+format.format(p.getqTime())+"')";
				}
				else if(p.getqTime()==null)
				{
					System.out.println("挂号病人");
					sql="Insert into PatientHSP values "
							+ "( '"+p.getpId()+"', '"
							+p.getDpmId()+"', '"
							+p.getdId()+"','"
							+format.format(p.getAppTime())+"',"
							+p.getqNumber()+",null,4,0,0,null)";
				}
				else{
					sql="Insert into PatientHSP values "
							+ "( '"+p.getpId()+"', '"
							+p.getDpmId()+"', '"
							+p.getdId()+"','"
							+format.format(p.getAppTime())+"',"
							+p.getqNumber()+",null,4,"
							+p.getIsTake()+","
							+p.getIsDo()+",'"
							+format.format(p.getqTime())+"')";
				}
				
				if(OPDB.excuteIUD(sql)) 
					System.out.println("添加新处方信息成功1");
			   if(meName.length!=0&&meNumber.length!=0)//加药
			{
				System.out.println("加药2：");
				for(int i=0;i<meName.length;i++)
				{
					String meId=null;
					sql="select meId from Medicine where meName='"+meName[i]+"'";
					rs=OPDB.excuteSelect(sql);
					if(rs.next())
						meId=rs.getString("meId");
				    sql="Insert into recipeMe values ( "
				    		+ " '"+reId+"','"+meId+"',"+meNumber[i]+",'"+strReTime+"')";
				    OPDB.excuteIUD(sql);
				    sql="update PatientHSP set isTake=1 "
							+ "where pId='"+p.getpId()+"' and dId='"+doctor.getdId()+"' "
							+ "and (convert(varchar(10),appTime,120) = convert(varchar(10),'"+strReTime+"',120) or "
							+ " convert(varchar(10),qTime,120) = convert(varchar(10),'"+strReTime+"',120)) "
									+ " and reId is null";
			
				    OPDB.excuteIUD(sql);
				}
			    
			}
			if(feName.length!=0)//加项目
			{
				System.out.println("加处方2：");
				for(int i=0;i<feName.length;i++)
				{
					String feId=null;
					sql="select feId from FeeItem where feName='"+feName[i]+"'";
					rs=OPDB.excuteSelect(sql);
					if(rs.next())
						feId=rs.getString("feId");
				    sql="Insert into recipeFe values ( "
				    		+ " '"+reId+"','"+feId+"','"+strReTime+"')";
				    OPDB.excuteIUD(sql);
				    sql="update PatientHSP set isDo=1 "
							+ "where pId='"+p.getpId()+"' and dId='"+doctor.getdId()+"' "
							+ "and (convert(varchar(10),appTime,120) = convert(varchar(10),'"+strReTime+"',120) or "
							+ " convert(varchar(10),qTime,120) = convert(varchar(10),'"+strReTime+"',120)) "
									+ " and reId is null ";
			
				    OPDB.excuteIUD(sql);
				}
			    
			  }
		    //添加reId
			  sql="update PatientHSP set reId='"+reId+"' "
					+ "where pId='"+p.getpId()+"' and dId='"+doctor.getdId()+"' "
							+ "and (convert(varchar(10),appTime,120) = convert(varchar(10),'"+strReTime+"',120) or "
							+ " convert(varchar(10),qTime,120) = convert(varchar(10),'"+strReTime+"',120)) "
									+ "and reId is null";
			   if(OPDB.excuteIUD(sql))
				   System.out.println("添加reId成功");
			
			}
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
