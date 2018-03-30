package com.jis.dao;

import java.util.List;

import com.jis.pojo.Room;

public interface RoomDao {
	/**
	 * ��ȡ���еķ���
	 * @return
	 * @author run
	 */
	public List<Room> getAllRoom();
	/**
	 * �޸İ�������
	 * @param roomTypeId���ͱ��
	 * @param roomId������
	 */
	public void updateRoomTypeByRoomId(int roomTypeId,String roomId);
	
	/**
	 * ���ݷ������ͱ�Ų��ҿյķ���
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> findEmptyRoomById(int roomTypeId);
	/**
	 * ���ݷ������ͱ�Ų����Ѿ�ʹ�õķ���
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> findHasUseRoomById(int roomTypeId);
	/**
	 * ���ݷ���id���·����ʹ�ñ�ʶ
	 * @param roomId
	 */
	public void updateRoomUseFlag(String roomId);
	/**
	 * ���ݷ���id�˶����䣬����ʹ�ñ�ʶ
	 * @param roomId
	 */
	public void updateRoomExitFlag(String roomId);
	
	/**
	 * ���ݷ����Ų��ҷ���
	 * @param roomId
	 * @return
	 */
	public Room findRoomByroomId(String roomId);
	public void setRoomFree(String roomId);
	/**
	 * �������ж���ʳ��İ���
	 * @return
	 */
	public List<Room> findGoodsRoomByRoomId();
}
