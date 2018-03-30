package com.jis.dao;

import java.util.List;

import com.jis.pojo.Room;

public interface RoomDao {
	/**
	 * 获取所有的房间
	 * @return
	 * @author run
	 */
	public List<Room> getAllRoom();
	/**
	 * 修改包厢类型
	 * @param roomTypeId类型编号
	 * @param roomId房间编号
	 */
	public void updateRoomTypeByRoomId(int roomTypeId,String roomId);
	
	/**
	 * 根据房间类型编号查找空的房间
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> findEmptyRoomById(int roomTypeId);
	/**
	 * 根据房间类型编号查找已经使用的房间
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> findHasUseRoomById(int roomTypeId);
	/**
	 * 根据房间id更新房间的使用标识
	 * @param roomId
	 */
	public void updateRoomUseFlag(String roomId);
	/**
	 * 根据房间id退订房间，销毁使用标识
	 * @param roomId
	 */
	public void updateRoomExitFlag(String roomId);
	
	/**
	 * 根据房间编号查找房间
	 * @param roomId
	 * @return
	 */
	public Room findRoomByroomId(String roomId);
	public void setRoomFree(String roomId);
	/**
	 * 查找所有订购食物的包厢
	 * @return
	 */
	public List<Room> findGoodsRoomByRoomId();
}
