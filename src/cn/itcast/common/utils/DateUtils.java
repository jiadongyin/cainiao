/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.itcast.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author jeeplus
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	/**
	  * 获取现在时间
	  * 
	  * @return返回短时间格式 yyyy-MM-dd
	  */
	 public static Date getNowDateShort() {
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		 Date time=null;
		 try {
		    time= sdf.parse(sdf.format(new Date()));
		 } catch (ParseException e) {

		    e.printStackTrace();
		 }
		  return time;
	 }
	 
	 /**
		 * 获取当年的第一天
		 * @param year
		 * @return
		 */
		public static Date getCurrYearFirst(){
			Calendar currCal=Calendar.getInstance();  
			int currentYear = currCal.get(Calendar.YEAR);
			return getYearFirst(currentYear);
		}
		
		/**
		 * 获取某年第一天日期
		 * @param year 年份
		 * @return Date
		 */
		public static Date getYearFirst(int year){
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, year);
			Date currYearFirst = calendar.getTime();
			return currYearFirst;
		}
		
		/**
		 * 获取某年第n月第一天日期
		 * @param year 年份
		 * @return Date
		 */
		public static Date getMonthInYear(int year, int n){
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, n-1);
			Date currYearFirst = calendar.getTime();
			return currYearFirst;
		}
		
		/**
		 * 获取某月第一天日期
		 * @param year 年份
		 * @param month 月份
		 * @return Date
		 */
		public static Date getMonthFirst(int year, int month){
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			Date currMonthFirst = calendar.getTime();
			return currMonthFirst;
		}
		
		/**
		 * 获取某月第n天日期
		 * @param year 年份
		 * @param month 月份
		 * @param n 第n天
		 * @return Date
		 */
		public static Date getDayInMonth(int year, int month, int n){
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DATE, n);
			Date currMonthFirst = calendar.getTime();
			return currMonthFirst;
		}
		
		/**
		 * 获取前一天日期
		 * @param year 年份 
		 * @param month 月份
		 * @param day 日期 
		 * @return Date
		 */
		public static Date getPreviousday(int year, int month, int day){
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DATE, day-1);
			Date previousDay = calendar.getTime();
			return previousDay;
		}
		
		/**
		 * 获取前一天日期
		 * @param year 年份 
		 * @param month 月份
		 * @param day 日期 
		 * @return Date
		 */
		public static Date getYesterDay(Date date) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			date = calendar.getTime();
			return date;
		}
		
		/**
		 * 获取今天零点日期
		 * @param year 年份 
		 * @param month 月份
		 * @param day 日期 
		 * @return Date
		 */
		public static Date getTodayAM(int year, int month, int day){
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DATE, day);
			Date previousDay = calendar.getTime();
			return previousDay;
		}
		
		
		/**
		 * 获取某年最后一天日期
		 * @param year 年份
		 * @return Date
		 */
		public static Date getYearLast(int year){
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, year);
			calendar.roll(Calendar.DAY_OF_YEAR, -1);
			Date currYearLast = calendar.getTime();
			
			return currYearLast;
		}
		
		 /**
		  * 获取某一个月有几天
		 * @param date
		 * @return
		 */
		public static int getDaysOfMonth(Date date) {  
		        Calendar calendar = Calendar.getInstance();  
		        calendar.setTime(date);  
		        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
		    }  
		
		//判断是否为当天
		public static boolean isToday(long time)  
	    {  
	       return isThisTime(time,"yyyy-MM-dd");  
	    }
		
		//判断选择的日期是否是本月  
	    public static boolean isThisMonth(long time)  
	    {  
	         return isThisTime(time,"yyyy-MM");  
	    }  
	    
	    private static boolean isThisTime(long time,String pattern) {  
	        Date date = new Date(time);  
	         SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
	         String param = sdf.format(date);//参数时间  
	         String now = sdf.format(new Date());//当前时间  
	         if(param.equals(now)){  
	           return true;  
	         }  
	         return false;  
	    }  
	    
	    /**
	     * 获取任意时间的下一个月
	     * 描述:<描述函数实现的功能>.
	     * @param repeatDate
	     * @return
	     */
	    public static String getPreMonth(String repeatDate) {
	        String lastMonth = "";
	        Calendar cal = Calendar.getInstance();
	        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
	        int year = Integer.parseInt(repeatDate.substring(0, 4));
	        String monthsString = repeatDate.substring(4, 6);
	        int month;
	        if ("0".equals(monthsString.substring(0, 1))) {
	            month = Integer.parseInt(monthsString.substring(1, 2));
	        } else {
	            month = Integer.parseInt(monthsString.substring(0, 2));
	        }
	        cal.set(year,month,Calendar.DATE);
	        lastMonth = dft.format(cal.getTime());
	        return lastMonth;
	    }
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
	}
}
