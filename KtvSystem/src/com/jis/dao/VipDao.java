package com.jis.dao;

import java.util.List;

import com.jis.pojo.Vip;

public interface VipDao {
	/**
	 * ����vip�ı�Ų���VIP�û�
	 * @param vipId
	 * @return
	 */
	public Vip findVipByVipId(int vipId);
	/**
	 * ����VIP�ĵ绰�����û�
	 * @param vipTel
	 * @return
	 */
	public Vip findVipByVipTel(String vipTel);
	/**
	 * ����µĻ�Ա
	 * @param v
	 */
	public void AddVip(Vip v);
	/**
	 * ���»�Ա�ĵȼ����ۿ۱�׼
	 * @param vipId
	 */
	public void AddVipLevel(int vipId);
	/**
	 * ����VIP�����Ʋ���VIP�û�
	 * @param vipName
	 * @return
	 */
	public Vip findVipByName(String vipName);
	/**
	 * ����VIP�ı���޸�VIP������
	 * @param vipName
	 * @param vipId
	 */
	public void updateVipName(String vipName,int vipId);
	/**
	 * ��������VIp
	 * @return
	 */
	public List<Vip> findAllVip();
	/**
	 * ����vipɾ��Vip
	 * @param vipId
	 */
	public void deleteVipById(int vipId);
	/**
	 * ����vip����޸�vip����
	 * @param vipId
	 */
	public void updtatePwd(int vipId,String pwd);
}
