package com.jis.dao;

public interface SongToTypeDao {
	/**
	 * ���ݸ���������Ӹ������
	 * @param songId
	 * @param styleId
	 */
	public void addSongStyleBySongId(int songId,int styleId );
	/**
	 * ���ݸ������ɾ���������
	 * @param songId
	 */
	public void deleteSongToTypeBySongId(int songId);
}
