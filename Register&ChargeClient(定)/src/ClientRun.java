import java.awt.EventQueue;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;

public class ClientRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllFrame frame=new AllFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}

class Cashier{
	private String id,name,gender;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class Patient{//Patient类：基本信息+就诊信息
	private String pId,name,gender,phone; 
	private int age;
	private Timestamp appTime,qTime;
	private String dpmId,dId,reId;
	private int qNumber,isVisit,isTake,isDo;
	private float raprize,faprize;
	private String[] dpm=null,dd=null,qt=null;
	private int[] qn=null;
	public int[] getQn() {
		return qn;
	}
	public void setQn(int[] qn) {
		this.qn = qn;
	}
	public String[] getDpm() {
		return dpm;
	}
	public void setDpm(String[] dpm) {
		this.dpm = dpm;
	}
	public String[] getDd() {
		return dd;
	}
	public void setDd(String[] dd) {
		this.dd = dd;
	}
	public String[] getQt() {
		return qt;
	}
	public void setQt(String[] qt) {
		this.qt = qt;
	}

	public float getRaprize() {
		return raprize;
	}
	public void setRaprize(float raprize) {
		this.raprize = raprize;
	}
	public float getFaprize() {
		return faprize;
	}
	public void setFaprize(float faprize) {
		this.faprize = faprize;
	}
	public Timestamp getqTime() {
		return qTime;
	}
	public void setqTime(Timestamp qTime) {
		this.qTime = qTime;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDpmId() {
		return dpmId;
	}
	public void setDpmId(String dpmId) {
		this.dpmId = dpmId;
	}
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	public Timestamp getAppTime() {
		return appTime;
	}
	public void setAppTime(Timestamp appTime) {
		this.appTime = appTime;
	}
	public String getReId() {
		return reId;
	}
	public void setReId(String reId) {
		this.reId = reId;
	}
	public int getqNumber() {
		return qNumber;
	}
	public void setqNumber(int qNumber) {
		this.qNumber = qNumber;
	}
	public int getIsVisit() {
		return isVisit;
	}
	public void setIsVisit(int isVisit) {
		this.isVisit = isVisit;
	}
	public int getIsTake() {
		return isTake;
	}
	public void setIsTake(int isTake) {
		this.isTake = isTake;
	}
	public int getIsDo() {
		return isDo;
	}
	public void setIsDo(int isDo) {
		this.isDo = isDo;
	}
	
	public Patient(){
		this.appTime=null;
		this.qTime=null;
		this.reId=null;
		this.isVisit=0;
		this.isTake=0;
		this.isDo=0;
		this.raprize=0;
		this.faprize=0;
		dpm=null;dd=null;qt=null;qn=null;
	}
	
	public void clear(){
		/*初始化*/
		this.pId=null;
		this.appTime=null;this.qTime=null;this.reId=null;this.isVisit=0;this.isTake=0;this.isDo=0;
		this.raprize=0;this.faprize=0;dpm=null;dd=null;qt=null;qn=null;
	}
	public boolean check_pId(){//检查pId是否存在
		String sql="select name from Patient where pId='"+pId+"'";
		DBhandel a=new DBhandel();
		if(a.checkItem(sql))//pId已存在
			return true;
		else 
			return false;
	}
	public void addPatient(Patient patient){
		 CallableStatement c;
			try {
				DB db=new DB();
				c = db.con.prepareCall("{call addPatient(?,?,?,?,?,?,?,?,?,?,?)}");
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
		        c.setInt(10, patient.getIsVisit());
		        c.setTimestamp(11, patient.getqTime());
		        //执行存储过程
		        c.execute();
		        c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  

	}
	public void getInfo(){
		String sql="select * from Patient where pId='"+pId+"'";		
		DB db=new DB();
		ResultSet rs=db.excuteSelect(sql);
		try {
			if(rs.next()){
				this.age=Integer.parseInt(rs.getString("age"));
				this.gender=rs.getString("gender");
				this.name=rs.getString("name");
				this.phone=rs.getString("phone");
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		db.close();
		
	}
	public int getHSP(String date){
		String sql2="select dpmId,dId,qTime,qNumber from PatientHSP where pId='"+pId+"' AND isVisit=1 AND convert(varchar(10),qTime,120)='"+date+"'";
		DB db=new DB();
		try {
			db.st=db.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs2=db.st.executeQuery(sql2);
			rs2.last();
			int result=rs2.getRow();
			if(result!=0){
				dpm=new String[result];
				dd=new String[result];
				qt=new String[result];
				qn=new int[result];
				rs2.first();
				int i=0;
				dpm[i]=rs2.getString("dpmId");dd[i]=rs2.getString("dId");qt[i]=rs2.getString("qTime");qn[i]=rs2.getInt("qNumber");
				i++;
				while(rs2.next()){
					dpm[i]=rs2.getString("dpmId");dd[i]=rs2.getString("dId");qt[i]=rs2.getString("qTime");qn[i]=rs2.getInt("qNumber");
				}
				isVisit=1;
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return 0;
	}
	
	public String[] getreid(String date){
//		String sql="select reId from PatientHSP"+
//				" where pId='"+pId+"' AND (isTake=1 or isDo=1) AND (convert(varchar(10),qTime,120)='"+date+"' or convert(varchar(10),appTime,120)='"+date+"' )";
		String sql="select reId from PatientHSP"+
						" where pId='"+pId+"' AND (isTake=1 or isDo=1)";
		DB db=new DB();
		String[] a = null;
		try {
			db.st=db.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=db.st.executeQuery(sql);
			rs.last();
			int result=rs.getRow();
			if(result!=0){
				a=new String[result];
				rs.first();
				int i=0;a[i]=rs.getString("reId");i++;
				while(rs.next()){
					a[i]=rs.getString("reId");i++;
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return a;
	}
}

class Doctor{
	private String dId,name,gender,dpmId;
	private int age,patientNumber1,patientNumber2;
	private Timestamp date;
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDpmId() {
		return dpmId;
	}
	public void setDpmId(String dpmId) {
		this.dpmId = dpmId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPatientNumber1() {
		return patientNumber1;
	}
	public void setPatientNumber1(int patientNumber1) {
		this.patientNumber1 = patientNumber1;
	}
	public int getPatientNumber2() {
		return patientNumber2;
	}
	public void setPatientNumber2(int patientNumber2) {
		this.patientNumber2 = patientNumber2;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public void setDoctor(String did,Timestamp d){
		dId=did;
		date=d;
		DBhandel a=new DBhandel();
		String sql="select patientNumber1,patientNumber2 from DoctorDate where dId='"+dId+"' AND date='"+date+"'";
		if(a.getItem(sql, "patientNumber1")!=null){
			patientNumber1=Integer.parseInt(a.getItem(sql, "patientNumber1"));
			patientNumber2=Integer.parseInt(a.getItem(sql, "patientNumber2"));
		}
		else {
			patientNumber1=0;patientNumber2=0;
		    sql="insert into DoctorDate values('"+dId+"','"+date+"',0,0)";
		    a.updateItem(sql);
		}
	}
	public String getDotorNumber(String dpmName,int i,String date){//找排队人数最少的医生
		String name=null;
		if(i==1){//上午
			DBhandel a=new DBhandel();
			String sql="select name from DoctorDate,Doctor,Department where  DoctorDate.dId=Doctor.dId and Doctor.dpmId=Department.dpmId and dpmName='"+dpmName+"' and patientNumber1=0 AND date='"+date+"'";
			if(a.getItem(sql, "name")!=null)
				name=a.getItem(sql, "name");
			else{
				sql="select top 1 COUNT(qNumber) as pn ,Doctor.name as name from PatientHSP,Department,Doctor"+
			" where PatientHSP.dId=Doctor.dId and PatientHSP.dpmId=Department.dpmId and dpmName='"+dpmName+"' and  ((isVisit='2' and convert(varchar(10),appTime,120)='"+date+"' and convert(varchar(10),appTime,108)<'13:00:00')or( isVisit='3'and convert(varchar(10),qTime,120)='"+date+"' and convert(varchar(10),qTime,108)='08:00:00'))"+ 
						" group by Doctor.name order by pn asc";
				name=a.getItem(sql, "name");
			}
		}
		else if(i==2){//下午
			DBhandel a=new DBhandel();
			String sql="select name from DoctorDate,Doctor,Department where  DoctorDate.dId=Doctor.dId and Doctor.dpmId=Department.dpmId and dpmName='"+dpmName+"' and patientNumber2=0 AND date='"+date+"'";
			if(a.getItem(sql, "name")!=null)
				name=a.getItem(sql, "name");
			else{
				sql="select top 1 COUNT(qNumber) as pn ,Doctor.name as name from PatientHSP,Department,Doctor"+
			" where PatientHSP.dId=Doctor.dId and PatientHSP.dpmId=Department.dpmId and dpmName='"+dpmName+"' and  ((isVisit='2' and convert(varchar(10),appTime,120)='"+date+"' and convert(varchar(10),appTime,108)>='13:00:00')or( isVisit='3'and convert(varchar(10),qTime,120)='"+date+"' and convert(varchar(10),qTime,108)='13:00:00'))"+ 
						" group by Doctor.name order by pn asc";
				name=a.getItem(sql, "name");
			}
		}
		return name;
	}
	
}

class DBhandel{
	
	public void addComboBox(JComboBox comboBox,String sql,String item){
		comboBox.addItem("");
		DB db=new DB();
		ResultSet rs=db.excuteSelect(sql);
		try {
			while(rs.next()){
				String s=rs.getString(item);
				if(item.equals("dpmName")){
					if(!s.equals("待分配"))
						comboBox.addItem(s);
				}
				else{
					comboBox.addItem(s);
				}
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		db.close();
	}
	
	public String getItem(String sql,String item){
		String s=null;
		DB db=new DB();
		ResultSet rs=db.excuteSelect(sql);
		try {
			if(rs.next()){
				s=rs.getString(item);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		db.close();
		return s;
	}
	public boolean checkItem(String sql){
		boolean result=false;
		DB db=new DB();
		ResultSet rs=db.excuteSelect(sql);
		try {
			if(rs.next()){
				result=true;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		db.close();
		return result;
	}
	public boolean updateItem(String sql){
		boolean result;
		DB db=new DB();
		result=db.excuteIUD(sql);
		return result;
	}
	
}

class TimeHandel{
	public String getNowDate(){
		Calendar c = Calendar.getInstance();
		Date d=new Date();
        c.setTime(d);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(d);
	}
	public String getNowDateHour(){
		Calendar c = Calendar.getInstance();
		Date d=new Date();
        c.setTime(d);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(d);
	}
}