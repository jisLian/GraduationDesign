package com.jis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jis.pojo.RoomType;

public interface RoomTypeDao {
	/**
	 * 获取所有房间类型
	 * @return
	 */
	public List<RoomType> findAllRoomType();
	/**
	 * 修改包厢类型
	 * @param roomTypeId
	 */
	public void updateRoomTypeById(@Param("typeName")String typeName,@Param("perfee")int fee,@Param("roomTypeId")int roomTypeId);
	/**
	 * 新增包厢类型
	 */
	public void addRoomType(String roomTypeName,int fee);
	
	/**
	 * 根据房间编号查找该房间
	 * @param roomTypeId
	 * @return
	 */
	public RoomType findRoomTypeById(int roomTypeId);
}
