package com.marks.common.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 日期工具类
 * 
 * @author zxming4
 * @createTime 2014-12-31
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class DateUtil {
	
	
	
	
	/**
	 * 获得月第一天
	 * @param month（0本月-1上月1下月）
	 * @param simpleDateFormat（如：new SimpleDateFormat("yyyyMMdd")）
	 * @return
	 */
	public static String getMonthFirstDay(int month, SimpleDateFormat simpleDateFormat) {
        Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        return simpleDateFormat.format(c.getTime());
	}

	/**
	 * 获得星期一的日期
	 * @param weeks（0本周-1上周+1下周）
	 * @param simpleDateFormat（如：new SimpleDateFormat("yyyyMMdd")）
	 * @return
	 */
	public static String getMonday(int weeks, SimpleDateFormat simpleDateFormat) {
		int mondayPlus = getMondayPlus();  
		GregorianCalendar currentDate = new GregorianCalendar();  
		currentDate.add(GregorianCalendar.DATE, mondayPlus+7*weeks);  
		Date monday = currentDate.getTime();  
		DateFormat df = DateFormat.getDateInstance();  
		if (null!=simpleDateFormat) {
			df = simpleDateFormat;
		}
		String preMonday = df.format(monday);  
		return preMonday;  
	}  

	/**
	 * 获得当前日期与本周一相差的天数  
	 * @return
	 */
	public static int getMondayPlus() {  
	Calendar cd = Calendar.getInstance();  
	// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......  
	int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);  
		if (dayOfWeek == 1) {  
		    return -6;  
		} else {  
		   return 2 - dayOfWeek;  
		}  
	}

	/**
	 * 
	 * lhyan3
	 * 2015年3月10日上午11:12:17
	 * TODO 获取当前时间的一个月以前的第一天
	 * @param format
	 * @return
	 */
	public static String getFirstDayBeforeOneMonth(String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		Date date = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String str = dateFormat.format(date);
		return str;
	}  
	
	

	/**
	 * 
	 * lhyan3
	 * 2015年3月14日下午4:21:45
	 * TODO 日期格式化
	 * @param value
	 * @param string
	 * @return
	 * @throws ParseException 
	 */
	public static Date format(Object value, String format) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = simpleDateFormat.parse(value.toString());
		return date;
	}

	/**
	 * 把日期转化成规定的字符串
	 * lhyan3
	 * 2015年4月9日上午9:42:22
	 * TODO
	 * @param date
	 * @param format
	 * @return
	 */
	public static String parseDate(Date date,String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String result = simpleDateFormat.format(date);
		return result;
	}
	
	public static boolean validateData(Date startDate,Date endDate){
		boolean flag=false;
		try {
			Date current=new Date();
			if(current.compareTo(startDate)>=0 && current.compareTo(endDate)<=0){
				flag=true;
			}
		} catch (Exception e) {
		}
		return flag;
	}
	
	public static String formatDate(String date,String format){
		String dateStr=date;
		if(date.length()==8){
			dateStr=date.substring(0, 4)+format+date.substring(4, 6)+format+date.substring(6, 8);
		}else if(date.length()==6 || date.length()==9){
			dateStr=date.substring(0, 2)+format+date.substring(2, 4)+format+date.substring(4, 6);
		}
		return dateStr;
	}
	
	/**
	 * 获取本月最后一天
	 * getLastDayOfMonth:描述 <br/>
	 *
	 * @param sDate1
	 * @return
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public static Date getLastDayOfMonth(Date sDate1){
		Calendar cDay1=Calendar.getInstance();
		cDay1.setTime(sDate1);
		final int lastDay=cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
		Date lastDate=cDay1.getTime();
		lastDate.setDate(lastDay);
		return lastDate;
	}
	public static String getLastDayOfMonth(Date sDate1,String formate){
		Date lastDate=getLastDayOfMonth(sDate1);
		return parseDate(lastDate,formate);
	}

	/**
	 * 获取几天之后
	 * 
	 * @param sDate1
	 *            yyyy-MM-dd
	 * @param days
	 *            天数
	 * @return
	 * @throws ParseException
	 */
	public static String getAfterDateByDays(String sDate1, int days) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(sDate1);
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		c.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(c.getTime());
	}
	
}



