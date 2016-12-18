import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClientRun {

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllFrame f=new AllFrame();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}


class Patient{//Patient类：基本信息+就诊信息
	private String pId,name,gender,phone; 
	private int age;
	
	private String dpmId,dId,appTime,reId;
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
	public String getAppTime() {
		return appTime;
	}
	public void setAppTime(String appTime) {
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
	
	public void clear(){
		/*初始化*/
	}
	public boolean check_pId(boolean i){//检查pId是否存在
		if(i)//pId已存在
			return true;
		else 
			return false;
	}
	public void addPatient(Patient p){
		/*添加病人信息*/
	}
	
}