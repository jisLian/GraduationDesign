package com.jis.dao;

import java.util.List;

import com.jis.pojo.WorkTime;

public interface WorkTimeDao {
	/**
	 * ����Ӫҵʱ��
	 * @return
	 */
	public List<WorkTime> findAllWorkTime();
}
