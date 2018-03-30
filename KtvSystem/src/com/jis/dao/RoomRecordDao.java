package com.jis.dao;

import java.util.Date;
import java.util.List;

import com.jis.pojo.RoomRecord;

public interface RoomRecordDao {
	/**
	 * ͨ��ʱ�䷶Χ�ҷ���ʹ�ü�¼
	 * @param start
	 * @param end
	 * @return
	 */
	public List<RoomRecord> getRoomRecordByTime(Date start,Date end);
	/**
	 * ͨ�������id��ʱ�䷶Χ��ʹ�ü�¼
	 * @param start
	 * @param end
	 * @param roomId
	 * @return
	 */
	public List<RoomRecord> getRoomRecordByRoomAndTime(Date start,Date end,String roomId);
	
	/**
	 * ����µķ���ʹ�ü�¼
	 * @param r
	 */
	public void AddRecord(RoomRecord r);
	
	/**
	 * ���ݷ���id��������ʹ�õķ���ʹ�ü�¼��Ϣ
	 * @param roomId
	 * @return
	 */
	public RoomRecord findCustomerIdByRoomId(String roomId);
	/**
	 *���Ѳ������½���ʱ�������
	 * @param record
	 */
	public void updateRoomRecord(RoomRecord record);
	/**
	 * �˷���������ʵ�ʽ���ʱ��ͷ���
	 * @param record
	 */
	public void exitRoomRecord(RoomRecord record);
	public void insertExitRecord(String roomId);
	
	public RoomRecord findUserRoomRecord(String id);
}
