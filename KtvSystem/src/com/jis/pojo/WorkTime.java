package com.jis.pojo;

import java.util.Date;

/**
 * 20.工作时间表映射类
 * @author shu
 *
 */
public class WorkTime {
	 //始工作时间	  
     private Date StartTime;
     //结束工作时间	
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
