package com.jis.dao;

import java.util.List;

import com.jis.pojo.StyleType;

public interface StyleTypeDao {
	/**
	 * 查询所有的风格
	 * @return
	 */
	public List<StyleType> findAllStyle();
	/**
	 * 根据歌曲编号查询歌曲
	 * @param songId
	 * @return
	 */
	public List<StyleType> findTyleBySongId(int songId);
}
