package main;
import java.sql.*;

public class Patient {
	String pId;
	String dpmId;
	String dId;
	String name;
	int age;
	String gender;
	String phone;
	Timestamp appTime;
	Timestamp qTime;
	int qNumber;
	String reld;
	int isVisit;
	int isTake;
	int isDo;
	//未有个人信息
	public Patient(String pId, String dpmId, String dId, String name, int age, String gender, String phone,
			Timestamp appTime, int qNumber) {
		super();
		this.pId = pId;
		this.dpmId = dpmId;
		this.dId = dId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.appTime = appTime;
		this.qNumber = qNumber;
	}
	//已有过个人信息
	public Patient(String pId,String dpmId, String dId,Timestamp appTime, int qNumber) {
		super();
		this.pId = pId;
		this.dpmId = dpmId;
		this.dId = dId;
		this.appTime = appTime;
		this.qNumber = qNumber;
		//其余采用默认值
		this.name = "";
		this.age = 0;
		this.gender = "";
		this.phone = "";
	}
	public Patient(String pId,String name,int qNumber,int isVisit)
	{
		this.pId=pId;
		this.name=name;
		this.qNumber=qNumber;
		this.isVisit=isVisit;
	}
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	Timestamp getAppTime() {
		return appTime;
	}
	void setAppTime(Timestamp appTime) {
		this.appTime = appTime;
	}
	int getqNumber() {
		return qNumber;
	}
	void setqNumber(int qNumber) {
		this.qNumber = qNumber;
	}
	String getReld() {
		return reld;
	}
	void setReld(String reld) {
		this.reld = reld;
	}
	int getIsVisit() {
		return isVisit;
	}
	void setIsVisit(int isVisit) {
		this.isVisit = isVisit;
	}
	int getIsTake() {
		return isTake;
	}
	void setIsTake(int isTake) {
		this.isTake = isTake;
	}
	int getIsDo() {
		return isDo;
	}
	void setIsDo(int isDo) {
		this.isDo = isDo;
	}
	String getpId() {
		return pId;
	}
	void setpId(String pId) {
		this.pId = pId;
	}
	String getDpmId() {
		return dpmId;
	}
	void setDpmId(String dpmId) {
		this.dpmId = dpmId;
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
	String getPhone() {
		return phone;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	Timestamp getqTime() {
		return qTime;
	}
	void setqTime(Timestamp qTime) {
		this.qTime = qTime;
	}
	
}
