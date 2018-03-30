package com.jis.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转换工具
 * @author admin
 *
 */
public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	
	/**
	 * 将String转换成Date类型
	 * @param date
	 * @return
	 */
	public static Date format(String date){
		Date date2=null;
		try {
			date2=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			System.out.println("获取时间失败！");			
		}
		return date2;
	}
	public static String formatStr(Date date){
		String dateStr=null;
		dateStr=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return dateStr;
	}
	public static Date parseDate(String date){
		Date date2=null;
		try {
			date2=new SimpleDateFormat("mm:ss").parse(date);
		} catch (ParseException e) {
			System.out.println("获取时间失败！");			
		}
		return date2;
	}
	
	public static Date parseRoomDate(String date){
		Date date2=null;
		try {
			date2=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
		} catch (ParseException e) {
			System.out.println("获取时间失败！");			
		}
		return date2;
	}
	
	/**
	 * 将时间转换成字符串，用于格式化输出
	 * @param format
	 * @param date
	 * @return
	 */
	public static String DataToString(String format,Date date){
		sdf.applyPattern(format);
		return sdf.format(date);
	}
	
	/**
	 * 获取系统当前时间
	 * @return
	 */
	public static Date getNowDate(){
		Date date=new Date();
		return date;
	}
	
	/**
	 * 将字符串转换成时间
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date StringToDate(String dateString,String format){
		sdf.applyPattern(format);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 判断某个时间是否在某个时间范围内
	 * @param startdate
	 * @param endDate
	 * @param date
	 * @return
	 */
	public static boolean betweenTimeScale(Date startDate,Date endDate,Date date){
		if(date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0){
			return true;
		}
		else return false;
	}
	
	public static int compareTimeByDay(Date date1,Date date2){
		long n1=date1.getTime()/1000/60/60/24;
		long n2=date2.getTime()/1000/60/60/24;
		if(n1>n2){
			return -1;
		}else if(n1==n2){
			return 0;
		}else{
			return 1;
		}
	}
	
	/**
	 * 获取几个小时后的时间
	 * @param hours
	 * @return
	 */
	public static Date getAfterDate(Date date,int hours){
		int hour=date.getHours();	
		date.setHours(hour+hours);
		return date;
	}
	
	/**
	 * 获取两段时间内的小时数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getHoursBetweenTime(Date date1,Date date2){
		double hour=Math.floor((date1.getTime()-date2.getTime())/1000/60/60)+1;
		return (int) hour;
	}
}
