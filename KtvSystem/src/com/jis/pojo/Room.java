package com.jis.pojo;
/**
 * 1.������ӳ����
 * @author shu
 *
 */
public class Room {
	//�����ţ�������
    private String roomId;
    //�������ͱ��
    private int roomTypeId;
    //ʹ�ñ�ʶ(0:δʹ�ã�1��ʹ��)
    private int useFlag;
    
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public int getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(int useFlag) {
		this.useFlag = useFlag;
	}
    
}
