import java.util.ArrayList;

public class Department
//������
{
String id;//���ұ��
String name;//��������
int patNum;  //���ҵ�ǰ�Ŷ����������������ھ��
int docNum;  //��������ҽ������
ArrayList <Doctor> docArray=new ArrayList <Doctor>();//�����Ҵ��ҽ���ļ�����
ArrayList <Patient> patArray=new ArrayList <Patient>();//�����Ҵ����ԤԼ�Ĳ��˵ļ�����


public Department(String id,String name,int docNum)
//���캯��
   {
	this.id=id;
	this.name=name;
	this.patNum=0;
    for(int i=0;i<docNum;i++)
      {Doctor a=new Doctor(String id,String pwd,String name);//����ҽ��ʵ��
       docArray.add(a);
       }
    }

public void appointdoctor(Patient patient)
//��ӿ���ԤԼ��¼
  {
   }

public void appointdoctor(Patient patient)
//ȡ������ԤԼ��¼������δ����������
  {
   }


public void curePatient(Patient patient)
//ɾ�������Ŷ��еĲ�����Ŀ�����˿��ò��뿪�������
  {
   }

public int showAssignment(Doctor doctor)
//��ѯ�ÿ���ĳҽ���Ŷ�����
  {
   }

public void assignPatient(Patient patient)
//Ϊ������ҽ�����䲡��
  {
   }



}