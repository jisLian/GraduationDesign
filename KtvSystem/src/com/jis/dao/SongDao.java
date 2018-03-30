package com.jis.dao;

import java.util.Date;
import java.util.List;

import com.jis.bean.Count;
import com.jis.bean.Language;
import com.jis.form.AddSongInfoForm;
import com.jis.form.UpdateSongForm;
import com.jis.pojo.Song;

public interface SongDao {
	/**
	 * 查找所有歌曲
	 * @return
	 */
	public List<Song> findSongByPageCode(int pageCode);
	/**
	 * 查询所有的语种
	 * @return
	 */
	public List<Language> findAllLanguage(); 
	/**
	 * 根据语种查找歌曲
	 * @param language
	 * @return
	 */
	public List<Song> findSongByLanguage(String language,int pageCode);
	/**
	 * 查询歌曲的总数量
	 * @return
	 */
	public int findCount();
	/**
	 * 根据语种查找歌曲的数量
	 * @param language
	 * @return
	 */
	public int findCountByLanguage(String language);
	/**
	 * 根据搜索搜索内容查找歌曲
	 * @param input
	 * @return
	 */
	public List<Song> findSongBySearch(String input);
	/**
	 * 根据歌名搜索歌曲
	 * @param songName
	 * @return
	 */
	public List<Song> findSongBySongName(String songName);
	/**
	 * 根据歌曲的编号删除歌曲
	 * @param songId
	 */
	public void deleteSongBySongId(int songId);
	/**
	 * 根据歌曲编号查询歌曲
	 * @param songId
	 * @return
	 */
	public Song findSongBySongId(int songId);
	/**
	 * 根据歌曲编号更新歌曲内容
	 * @param form
	 */
	public void updateSongBySongId(UpdateSongForm form);
	/**
	 * 添加歌曲
	 * @param songName
	 * @param songSinger
	 * @param language
	 * @param songTime
	 * @param pblishDate
	 * @param path
	 */
	public void addSong(AddSongInfoForm addSongForm);
	/**
	 * 根据歌曲路径查找歌曲编号
	 * @param path
	 * @return
	 */
	public Song findSongBySongPath(String path);
}
