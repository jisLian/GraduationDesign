package com.jis.pojo;
/**
 * ϵͳ֪ͨӳ���
 * @author shu
 *
 */
import java.util.Date;
public class SystemInfo{
	//����
    private String title;
    //����
    private String contentInfo;
    //����
    private Date dateInfo;
    //��ɫ��ݱ�ʶ
    private int roleFlag;
    //��ɫ�绰�������
    private String roleTel;
    
	public SystemInfo() {
		super();
	}
	public SystemInfo(String title, String contentInfo, Date dateInfo, int roleFlag, String roleTel) {
		super();
		this.title = title;
		this.contentInfo = contentInfo;
		this.dateInfo = dateInfo;
		this.roleFlag = roleFlag;
		this.roleTel = roleTel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentInfo() {
		return contentInfo;
	}
	public void setContentInfo(String contentInfo) {
		this.contentInfo = contentInfo;
	}
	public Date getDateInfo() {
		return dateInfo;
	}
	public void setDateInfo(Date dateInfo) {
		this.dateInfo = dateInfo;
	}
	public int getRoleFlag() {
		return roleFlag;
	}
	public void setRoleFlag(int roleFlag) {
		this.roleFlag = roleFlag;
	}
	public String getRoleTel() {
		return roleTel;
	}
	public void setRoleTel(String roleTel) {
		this.roleTel = roleTel;
	}
	
    
}
