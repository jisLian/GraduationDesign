package com.jis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jis.pojo.RoomType;

public interface RoomTypeDao {
	/**
	 * ��ȡ���з�������
	 * @return
	 */
	public List<RoomType> findAllRoomType();
	/**
	 * �޸İ�������
	 * @param roomTypeId
	 */
	public void updateRoomTypeById(@Param("typeName")String typeName,@Param("perfee")int fee,@Param("roomTypeId")int roomTypeId);
	/**
	 * ������������
	 */
	public void addRoomType(String roomTypeName,int fee);
	
	/**
	 * ���ݷ����Ų��Ҹ÷���
	 * @param roomTypeId
	 * @return
	 */
	public RoomType findRoomTypeById(int roomTypeId);
}
