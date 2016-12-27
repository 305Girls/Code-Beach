
import java.awt.BasicStroke;  
import java.awt.Color;  
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartFrame;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.StandardPieToolTipGenerator;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.chart.plot.PiePlot3D;  
import org.jfree.chart.title.TextTitle;  
import org.jfree.data.general.DefaultPieDataset;

import com.ibm.icu.text.SimpleDateFormat;  
 

public class chart extends JFrame {  

	static ChartFrame frame ;
	public static SimpleDateFormat df;
    public chart() throws SQLException {  
    	df = new SimpleDateFormat("yyyy.MM.dd");//�������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ
    	boolean flag;
    	int c = 0;
    	//flag=DB.open("localhost:1433");
    	//System.out.println(flag);
    	String sql1="select dpmName from Department where not dpmId='0'";
    	ResultSet r1=null;
    	r1=DB.excuteSelect(sql1);
    	String sql2="select SUM(patientNumber1+patientNumber2) as sumnum from Doctor,Department,DoctorDate where Department.dpmId=Doctor.dpmId and convert(varchar(10),date,102)<='"+df.format(new Date())+"' and DoctorDate.dId=Doctor.dId";
    	ResultSet r2=null;
    	r2=DB.excuteSelect(sql2);
    	while(r2.next()){
    		c=r2.getInt("sumnum");
    	}
    	System.out.println(c);
    	
        // ������ͼ���ݶ���  
 
        DefaultPieDataset dfp = new DefaultPieDataset();  
        
        while(r1.next()){
        	dfp.setValue(r1.getString("dpmName"),searchdepart(r1.getString("dpmName"),c));
        	//System.out.println(r1.getString("dpmName")+searchdepart(r1.getString("dpmName"),c));
        	
        	}
        
 
        // ��״ͼ�Ľ���취  
        // createpieChart3D����3D��ͼ  
        // createpieChart������ͼ  
        JFreeChart chart = ChartFactory.createPieChart3D("���ҹҺ���",dfp, true, true, true);  
        // ͼƬ����ɫ  
        chart.setBackgroundPaint(Color.white);  
        // ���ñ�������  
        frame = new ChartFrame("���ҹҺ��� ",chart, true);  
        // ȡ�ñ�ͼplot����  
        // PiePlot plot = (PiePlot) chart.getPlot();  
        // ȡ��3D��ͼ����  
        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
        // ͼ�α߿���ɫ  
        plot.setBaseSectionOutlinePaint(Color.RED);  
        // plot.setBaseSectionPaint(Color.WHITE);  
        // ͼ�α߿��ϸ  
        plot.setBaseSectionOutlineStroke(new BasicStroke(1.0f));  
 
        // ָ��ͼƬ��͸����(0.0-1.0)  
        plot.setForegroundAlpha(0.65f);  
        // ָ����ʾ�ı�ͼ��Բ��(false)����Բ��(true)  
        plot.setCircular(true);  
 
        // ���õ�һ�� ����section �Ŀ�ʼλ�ã�Ĭ����12���ӷ���  
        plot.setStartAngle(360);  
        // ���������ͣ��ʾ  
        plot.setToolTipGenerator(new StandardPieToolTipGenerator());  
 
        // ����ͻ����ʾ�����ݿ�  
        plot.setExplodePercent("One", 0.1D);  
        // ���ñ�ͼ�����ֱ�ǩ����  
        plot.setLabelFont(new Font("����", Font.ITALIC, 20));  
        // ���÷ֱ���ɫ  
        plot.setSectionPaint(0, new Color(244, 194, 144));  
        // plot.setSectionPaint("2", new Color(144, 233, 144));  
        // ����ͼ��˵��Legend�ϵ�����  
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 30));  
        // ���������ʽ  
        Font font = new java.awt.Font("����", java.awt.Font.CENTER_BASELINE,50);  
        TextTitle title = new TextTitle("���ҹҺ���");  
        title.setFont(font);  
        // ��������,�ǳ��ؼ���Ȼ����������,�·�������  
        chart.setTitle(title);  
        frame.pack();  
        frame.setVisible(true);  
 
    }  
	public static int searchdepart(Object q1,int c) throws SQLException {
		// TODO Auto-generated method stub
		String sql11="select SUM(patientNumber1+patientNumber2) as num from Doctor,Department,DoctorDate  where Department.dpmId=Doctor.dpmId and DoctorDate.dId=Doctor.dId and convert(varchar(10),date,102)<='"+df.format(new Date())+"' and Department.dpmName='"+q1+"'";
		ResultSet r11=null;
		r11=DB.excuteSelect(sql11);
		int a=0;
		if(r11.next())
		a=r11.getInt("num");
		return (a*100/c);
	}
 
} 