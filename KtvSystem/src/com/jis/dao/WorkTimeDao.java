package com.jis.dao;

import java.util.List;

import com.jis.pojo.WorkTime;

public interface WorkTimeDao {
	/**
	 * 查找营业时间
	 * @return
	 */
	public List<WorkTime> findAllWorkTime();
}
