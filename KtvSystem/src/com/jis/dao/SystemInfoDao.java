package com.jis.dao;

import java.util.List;

import com.jis.pojo.SystemInfo;

public interface SystemInfoDao {
	/**
	 * ���ϵͳ֪ͨ��Ϣ
	 * @param titleContent
	 * @param relative
	 * @param content
	 */
	public void addSystemInfo(SystemInfo systemInfo);
	/**
	 * ������ݲ���ǰ̨��Ա��ص���Ϣ��������Ϣ��
	 * @return
	 */
	public List<SystemInfo> findfrontEmpInfo(int Flag);
	/**
	 * ����Ա���ĵ绰���������Ϣ(˽��)
	 * @param empTel
	 * @return
	 */
	public List<SystemInfo> findfrontEmpInfoByempTel(String empTel);
	/**
	 * ���ݵ绰����ݱ�ʶ����ϵͳ��Ϣ
	 * @param tel
	 * @param flag
	 * @return
	 */
	public List<SystemInfo> findinfo(String tel,int flag);
}
