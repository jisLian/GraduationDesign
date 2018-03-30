package com.jis.dao;

import java.util.List;

import com.jis.pojo.SystemInfo;

public interface SystemInfoDao {
	/**
	 * 添加系统通知消息
	 * @param titleContent
	 * @param relative
	 * @param content
	 */
	public void addSystemInfo(SystemInfo systemInfo);
	/**
	 * 根据身份查找前台人员相关的消息（公用信息）
	 * @return
	 */
	public List<SystemInfo> findfrontEmpInfo(int Flag);
	/**
	 * 根据员工的电话查找相关消息(私信)
	 * @param empTel
	 * @return
	 */
	public List<SystemInfo> findfrontEmpInfoByempTel(String empTel);
	/**
	 * 根据电话和身份标识查找系统消息
	 * @param tel
	 * @param flag
	 * @return
	 */
	public List<SystemInfo> findinfo(String tel,int flag);
}
