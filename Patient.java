
public class Patient {
	long id;//���֤��
	String appointedDepart;//ԤԼ����
	String appointedDoctor;//ԤԼҽ��
	String appointedTime;//ԤԼ����ʱ��
	String name;//����
	String sex;//�Ա�
	int age;//����
	String contactNum;//��ϵ��ʽ
	long feesForRegis;//�Һŷ���
	//ҩƷ���ѣ�����+����+����+״̬Flag��
	class feesForDrug
	{
		String name;
		long fees;
		int num;
		int Flag;//�Ƿ���ҩ
	}
	//��Ŀ���ѣ�����+����+״̬Flag��
	class feesForItem
	{
		String name;
		long fees;
		int Flag;//�Ƿ����ø���Ŀ
	}
}
