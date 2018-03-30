package com.jis.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UpdateSongForm {
	private int songId;
	private String songName;
	private String songLanguage;
	private String songSinger;
	@DateTimeFormat(pattern="mm:ss")
	private Date songTime;
	
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
	
}
