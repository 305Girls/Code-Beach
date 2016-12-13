
public class Medicine {
//Ò©Æ·±àºÅ+Ò©Æ·Ãû³Æ+µ¥¼Û+Æ´Òô¼òÂë
	private String MeID,Mename;
	private float Meprize;
	private String PYJM;
	public String getMeID() {
		return MeID;
	}
	public void setMeID(String meID) {
		MeID = meID;
	}
	public String getMename() {
		return Mename;
	}
	public void setMename(String mename) {
		Mename = mename;
	}
	public float getMeprize() {
		return Meprize;
	}
	public void setMeprize(float meprize) {
		Meprize = meprize;
	}
	public String getPYJM() {
		return PYJM;
	}
	public void setPYJM(String pYJM) {
		PYJM = pYJM;
	}
	
	public Medicine(String id,String name,float prize,String pyjm){
		this.MeID=id;
		this.Mename=name;
		this.Meprize=prize;
		this.PYJM=pyjm;
	}
	
}
