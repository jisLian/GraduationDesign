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
	 * �������и���
	 * @return
	 */
	public List<Song> findSongByPageCode(int pageCode);
	/**
	 * ��ѯ���е�����
	 * @return
	 */
	public List<Language> findAllLanguage(); 
	/**
	 * �������ֲ��Ҹ���
	 * @param language
	 * @return
	 */
	public List<Song> findSongByLanguage(String language,int pageCode);
	/**
	 * ��ѯ������������
	 * @return
	 */
	public int findCount();
	/**
	 * �������ֲ��Ҹ���������
	 * @param language
	 * @return
	 */
	public int findCountByLanguage(String language);
	/**
	 * ���������������ݲ��Ҹ���
	 * @param input
	 * @return
	 */
	public List<Song> findSongBySearch(String input);
	/**
	 * ���ݸ�����������
	 * @param songName
	 * @return
	 */
	public List<Song> findSongBySongName(String songName);
	/**
	 * ���ݸ����ı��ɾ������
	 * @param songId
	 */
	public void deleteSongBySongId(int songId);
	/**
	 * ���ݸ�����Ų�ѯ����
	 * @param songId
	 * @return
	 */
	public Song findSongBySongId(int songId);
	/**
	 * ���ݸ�����Ÿ��¸�������
	 * @param form
	 */
	public void updateSongBySongId(UpdateSongForm form);
	/**
	 * ��Ӹ���
	 * @param songName
	 * @param songSinger
	 * @param language
	 * @param songTime
	 * @param pblishDate
	 * @param path
	 */
	public void addSong(AddSongInfoForm addSongForm);
	/**
	 * ���ݸ���·�����Ҹ������
	 * @param path
	 * @return
	 */
	public Song findSongBySongPath(String path);
}
