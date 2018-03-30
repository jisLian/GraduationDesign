package com.jis.dao;

public interface SongToTypeDao {
	/**
	 * 根据歌曲编号增加歌曲风格
	 * @param songId
	 * @param styleId
	 */
	public void addSongStyleBySongId(int songId,int styleId );
	/**
	 * 根据歌曲编号删除歌曲风格
	 * @param songId
	 */
	public void deleteSongToTypeBySongId(int songId);
}
