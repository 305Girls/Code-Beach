import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ClientRun {

	/**
	 * Launch the application.
	 */
	static Socket server = null;
	static String log_in;//登录信息
	static String duty="0";
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {    
					server=new Socket("127.0.0.1", 4444);
					PrintWriter os = new PrintWriter(server.getOutputStream());
					BufferedReader is= new BufferedReader(new InputStreamReader(server.getInputStream()));
					os.println("345112");
					os.flush();
					os.println("a85tx6");
					os.flush();
					os.println(duty);
					os.flush();
					log_in=is.readLine();
					if(log_in.matches("succeed"))
					{
						JOptionPane.showMessageDialog(null,"登陆成功！正在连接数据库...",null, JOptionPane.PLAIN_MESSAGE); 
						String ip=is.readLine();//接收数据库地址
						//连接数据库
						if(DB.open(ip))
						{
							JOptionPane.showMessageDialog(null, "数据库连接成功！");
							AllFrame f=new AllFrame();
							try {
								Doctor dd=new Doctor();
								TimeHandel t=new TimeHandel();
								Timestamp date=Timestamp.valueOf(t.getNowDate()+" 00:00:00");
								DB db=new DB();
								String sql="select dId from Doctor";
								db.st=db.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
								ResultSet rs=db.st.executeQuery(sql);
								rs.last();
								int result=rs.getRow();
								if(result!=0){
									String[] did=new String[result];
									rs.first();
									int i=0;did[i]=rs.getString("dId");i++;
									while(rs.next()){
										did[i]=rs.getString("dId");i++;
									}
									for(int j=0;j<did.length;j++){
										dd.setDoctor(did[j], date);
									}
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,log_in, "ERROR", JOptionPane.ERROR_MESSAGE); 
					}
					os.close();// 关闭Socket输出流
					is.close();// 关闭Socket输入流
					server.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}


class Patient{//Patient类：基本信息+就诊信息
	private String pId,name,gender,phone; 
	private int age;
	private Timestamp appTime,qTime;
	public Timestamp getqTime() {
		return qTime;
	}
	public void setqTime(Timestamp qTime) {
		this.qTime = qTime;
	}
	private String dpmId,dId,reId;
	private int qNumber,isVisit,isTake,isDo;
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
	}
	
	public void clear(){
		/*初始化*/
	}
	public boolean check_pId(){//检查pId是否存在
		String sql="select * from Patient where pId='"+pId+"'";
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

