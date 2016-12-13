
public class Apothecary extends Account {
	String name;//药师姓名
	public Apothecary(String id,String pwd,String name){//构造函数
		this.id=id;
		this.pwd=pwd;
		this.name=name;
	}
	public void login(String id,String pwd){
		/*匹配账号及密码*/
	}
	public void receiveRecipe(/*处方,病人信息*/){
		/*显示处方信息*/
		/*准备药品*/
	}
	public void delieverRecipe(/*病人信息*/){
		/*匹配病人信息*/
		/*分配药品*/
		/*设置处方已分配完毕*/
	}
}
