
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
    	df = new SimpleDateFormat("yyyy.MM.dd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时
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
    	
        // 创建饼图数据对象  
 
        DefaultPieDataset dfp = new DefaultPieDataset();  
        
        while(r1.next()){
        	dfp.setValue(r1.getString("dpmName"),searchdepart(r1.getString("dpmName"),c));
        	//System.out.println(r1.getString("dpmName")+searchdepart(r1.getString("dpmName"),c));
        	
        	}
        
 
        // 饼状图的解决办法  
        // createpieChart3D创建3D饼图  
        // createpieChart创建饼图  
        JFreeChart chart = ChartFactory.createPieChart3D("科室挂号量",dfp, true, true, true);  
        // 图片背景色  
        chart.setBackgroundPaint(Color.white);  
        // 设置标题文字  
        frame = new ChartFrame("科室挂号量 ",chart, true);  
        // 取得饼图plot对象  
        // PiePlot plot = (PiePlot) chart.getPlot();  
        // 取得3D饼图对象  
        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
        // 图形边框颜色  
        plot.setBaseSectionOutlinePaint(Color.RED);  
        // plot.setBaseSectionPaint(Color.WHITE);  
        // 图形边框粗细  
        plot.setBaseSectionOutlineStroke(new BasicStroke(1.0f));  
 
        // 指定图片的透明度(0.0-1.0)  
        plot.setForegroundAlpha(0.65f);  
        // 指定显示的饼图上圆形(false)还椭圆形(true)  
        plot.setCircular(true);  
 
        // 设置第一个 饼块section 的开始位置，默认是12点钟方向  
        plot.setStartAngle(360);  
        // 设置鼠标悬停提示  
        plot.setToolTipGenerator(new StandardPieToolTipGenerator());  
 
        // 设置突出显示的数据块  
        plot.setExplodePercent("One", 0.1D);  
        // 设置饼图各部分标签字体  
        plot.setLabelFont(new Font("宋体", Font.ITALIC, 20));  
        // 设置分饼颜色  
        plot.setSectionPaint(0, new Color(244, 194, 144));  
        // plot.setSectionPaint("2", new Color(144, 233, 144));  
        // 设置图例说明Legend上的文字  
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 30));  
        // 定义字体格式  
        Font font = new java.awt.Font("黑体", java.awt.Font.CENTER_BASELINE,50);  
        TextTitle title = new TextTitle("科室挂号量");  
        title.setFont(font);  
        // 设置字体,非常关键不然会出现乱码的,下方的字体  
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