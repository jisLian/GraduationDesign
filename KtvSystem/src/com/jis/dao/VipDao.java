package com.jis.dao;

import java.util.List;

import com.jis.pojo.Vip;

public interface VipDao {
	/**
	 * 根据vip的编号查找VIP用户
	 * @param vipId
	 * @return
	 */
	public Vip findVipByVipId(int vipId);
	/**
	 * 根据VIP的电话查找用户
	 * @param vipTel
	 * @return
	 */
	public Vip findVipByVipTel(String vipTel);
	/**
	 * 添加新的会员
	 * @param v
	 */
	public void AddVip(Vip v);
	/**
	 * 更新会员的等级和折扣标准
	 * @param vipId
	 */
	public void AddVipLevel(int vipId);
	/**
	 * 根据VIP的名称查找VIP用户
	 * @param vipName
	 * @return
	 */
	public Vip findVipByName(String vipName);
	/**
	 * 根据VIP的编号修改VIP的名字
	 * @param vipName
	 * @param vipId
	 */
	public void updateVipName(String vipName,int vipId);
	/**
	 * 查找所有VIp
	 * @return
	 */
	public List<Vip> findAllVip();
	/**
	 * 根据vip删除Vip
	 * @param vipId
	 */
	public void deleteVipById(int vipId);
	/**
	 * 根据vip编号修改vip密码
	 * @param vipId
	 */
	public void updtatePwd(int vipId,String pwd);
}
