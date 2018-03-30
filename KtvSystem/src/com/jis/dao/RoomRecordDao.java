package com.jis.dao;

import java.util.Date;
import java.util.List;

import com.jis.pojo.RoomRecord;

public interface RoomRecordDao {
	/**
	 * 通过时间范围找房间使用记录
	 * @param start
	 * @param end
	 * @return
	 */
	public List<RoomRecord> getRoomRecordByTime(Date start,Date end);
	/**
	 * 通过房间的id和时间范围找使用记录
	 * @param start
	 * @param end
	 * @param roomId
	 * @return
	 */
	public List<RoomRecord> getRoomRecordByRoomAndTime(Date start,Date end,String roomId);
	
	/**
	 * 添加新的房间使用记录
	 * @param r
	 */
	public void AddRecord(RoomRecord r);
	
	/**
	 * 根据房间id查找正在使用的房间使用记录信息
	 * @param roomId
	 * @return
	 */
	public RoomRecord findCustomerIdByRoomId(String roomId);
	/**
	 *续费操作更新结束时间和消费
	 * @param record
	 */
	public void updateRoomRecord(RoomRecord record);
	/**
	 * 退房操作更新实际结束时间和费用
	 * @param record
	 */
	public void exitRoomRecord(RoomRecord record);
	public void insertExitRecord(String roomId);
	
	public RoomRecord findUserRoomRecord(String id);
}
