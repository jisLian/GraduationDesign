package com.jis.pojo;

import java.util.Date;

/**
 * 8.歌曲表的映射类
 * @author shu
 *
 */
public class Song {
	//歌曲编号（主键）
    private int songId;
    //歌曲名称
    private String songName;
    //歌曲语种
    private String songLanguage;
    //歌曲歌手   
    private String songSinger;
    //歌曲时长
    private Date songTime;
    //歌曲点歌数
    private int songCount;
    //歌曲发布时间
    private Date songPublishTime;
    //歌曲路径
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
