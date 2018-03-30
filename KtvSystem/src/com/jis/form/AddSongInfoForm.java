package com.jis.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AddSongInfoForm {
	private String songName;
	private String songSinger;
	private String language;
	@DateTimeFormat(pattern="mm:ss")
	private Date songTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pblishDate;
	private String songPath;
	private String[] songStyle;
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongSinger() {
		return songSinger;
	}
	public void setSongSinger(String songSinger) {
		this.songSinger = songSinger;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getSongTime() {
		return songTime;
	}
	public void setSongTime(Date songTime) {
		this.songTime = songTime;
	}
	public Date getPblishDate() {
		return pblishDate;
	}
	public void setPblishDate(Date pblishDate) {
		this.pblishDate = pblishDate;
	}
	
	public String getSongPath() {
		return songPath;
	}
	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}
	public String[] getSongStyle() {
		return songStyle;
	}
	public void setSongStyle(String[] songStyle) {
		this.songStyle = songStyle;
	}
	
	
}
