package com.jis.pojo;

import java.util.Date;

/**
 * 20.����ʱ���ӳ����
 * @author shu
 *
 */
public class WorkTime {
	 //ʼ����ʱ��	  
     private Date StartTime;
     //��������ʱ��	
     private Date Endtime;
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndtime() {
		return Endtime;
	}
	public void setEndtime(Date endtime) {
		Endtime = endtime;
	}
     
}
