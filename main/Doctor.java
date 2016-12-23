package main;
import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;

import javax.swing.*;



public class Doctor extends Account
{

	String dId;
	String name;//医生姓名
	int age;
	String gender;
	String dpmId;
	Queue<Patient> Q=new LinkedList<Patient>();//排队队列
	Queue<Patient> W=new LinkedList<Patient>();//预约未到等候队列
	public Doctor()
	{
		
	}
	public Doctor(String dId)
	{
		this.dId=dId;
		Date date=new Date(System.currentTimeMillis()); 
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String timeNow=format.format(date);//当前系统时间
		try {
	    String sql1="select dId,name,age,gender,dpmId from Doctor "
	    		+ "where dId='"+dId+"'";
		String sql2="select B.name,A.pId,A.qNumber,A.isVisit,A.appTime,A.qTime "
				+" from PatientHSP A,Patient B,Doctor C " 
				+"where C.dId='1'and A.pId=B.pId and C.dId=A.dId "
				+"and ( convert(varchar(10),A.appTime,120) = '"+timeNow+"' "
				+"or (convert(varchar(10),A.qTime,120) = '"+timeNow+"' and A.appTime is null)) "
				+"order by qNumber";
		ResultSet rs=OPDB.excuteSelect(sql1);
		while(rs.next())
		{
			this.name=rs.getString("name");
			this.age=rs.getInt("age");
			this.gender=rs.getString("gender");
			this.dpmId=rs.getString("dpmId");
		}	
		rs=OPDB.excuteSelect(sql2);
		while(rs.next())
		{
			if(rs.getInt("isVisit")==2||(rs.getInt("isVisit")==3&&rs.getTimestamp("appTime")==null))
				Q.add(new Patient(rs.getString("pId"),rs.getString("name"),
					rs.getInt("qNumber"),rs.getInt("isVisit")));
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Doctor(String dId, String name, int age, String gender,  Queue<Patient> Q){
		super();
		this.dId = dId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.Q=Q;
	}
	public Patient choosePatient()//显示当前将看病的病人
	{
		Patient p=Q.peek();
		return p;
	}
    public Patient curedRegisPatient()//治疗病人
    {
    	Patient p=null;
    	if(Q.peek()==null)
    		return null;
    	p=Q.remove();
		String sql="update PatientHsp set isVisit=4 where "
				+ "pId='"+p.getpId()+"'";//设置状态位为4已就诊
		OPDB.excuteIUD(sql);	
    	return p;
    }
    public Patient passPatient()//过号
    {
    	Patient p=null;
    	if(Q.peek()==null)
    		return null;
    	else 
    		p=Q.remove();
    	if(p.getIsVisit()==2)//挂号病人，改状态位为0无状态
    	{
    		String sql="update PatientHsp set isVisit=0 where "
    				+ "pId='"+p.getpId()+"'";
    		OPDB.excuteIUD(sql);
    	}
    	else if(p.getIsVisit()==3)//预约病人，改appTime为当前系统时间
    	{
    		Date date=new Date(System.currentTimeMillis()); 
    		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String timeNow=format.format(date);//当前系统时间
    		String sql="update PatientHsp set appTime ='"
    		+timeNow+"' where pId='"+p.getpId()+"'";
    		OPDB.excuteIUD(sql);
    		this.getW().add(p);//预约叫号未到，加入等候队列
    	}
    	return p;
    }
    
	String getdId() {
		return dId;
	}

	void setdId(String dId) {
		this.dId = dId;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getGender() {
		return gender;
	}

	void setGender(String gender) {
		this.gender = gender;
	}
	Queue<Patient> getQ() {
		return Q;
	}
	void setQ(Queue<Patient> q) {
		Q = q;
	}
	String getDpmId() {
		return dpmId;
	}
	void setDpmId(String dpmId) {
		this.dpmId = dpmId;
	}
	Queue<Patient> getW() {
		return W;
	}
	void setW(Queue<Patient> w) {
		W = w;
	}
	


}
