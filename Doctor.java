import java.util.LinkedList;

import javax.swing.JPanel;

public class Doctor extends Account
{
String name;//ҽ������
private LinkedList<Patient> patList = new LinkedList<Patient>();//�ŶӵĲ��˶��У���һ�����˵�ǰ���ڿ���
JPanel docPanel1=new JPanel();//ҽ����½������


public Doctor(String id,String pwd,String name)
//���캯��
  {
this.id=id;
this.pwd=pwd;
this.name=name;
  }

public void recipe(/*����*/)
//������
  {
   /*��ѯҩƷ*/
   /*�ڴ��������ҩƷ*/
   }

public void cure(Patient patient)
//����һ������
  {/*���ڵ�һ���Ĳ��˳�����*/
  }
public void turnToPanel()
  {
   }

}
