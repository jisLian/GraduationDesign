package com.jis.dao;

import java.util.List;

import com.jis.pojo.StyleType;

public interface StyleTypeDao {
	/**
	 * ��ѯ���еķ��
	 * @return
	 */
	public List<StyleType> findAllStyle();
	/**
	 * ���ݸ�����Ų�ѯ����
	 * @param songId
	 * @return
	 */
	public List<StyleType> findTyleBySongId(int songId);
}
