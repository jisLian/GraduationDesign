package com.jis.pojo;

import java.util.Date;

/**
 * 8.�������ӳ����
 * @author shu
 *
 */
public class Song {
	//������ţ�������
    private int songId;
    //��������
    private String songName;
    //��������
    private String songLanguage;
    //��������   
    private String songSinger;
    //����ʱ��
    private Date songTime;
    //���������
    private int songCount;
    //��������ʱ��
    private Date songPublishTime;
    //����·��
    private String songPath;
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongLanguage() {
		return songLanguage;
	}
	public void setSongLanguage(String songLanguage) {
		this.songLanguage = songLanguage;
	}
	public String getSongSinger() {
		return songSinger;
	}
	public void setSongSinger(String songSinger) {
		this.songSinger = songSinger;
	}
	public Date getSongTime() {
		return songTime;
	}
	public void setSongTime(Date songTime) {
		this.songTime = songTime;
	}
	public int getSongCount() {
		return songCount;
	}
	public void setSongCount(int songCount) {
		this.songCount = songCount;
	}
	public Date getSongPublishTime() {
		return songPublishTime;
	}
	public void setSongPublishTime(Date songPublishTime) {
		this.songPublishTime = songPublishTime;
	}
	public String getSongPath() {
		return songPath;
	}
	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}
    
}
