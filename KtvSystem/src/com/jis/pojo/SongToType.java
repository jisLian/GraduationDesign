package com.jis.pojo;
/**
 * 9.歌曲与类型的关系表映射类
 * @author shu
 *
 */
public class SongToType {
	//歌曲编号(外键)
    private int songId;
    //歌曲类型编号(外键)
    private int styleTypeId;
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public int getStyleTypeId() {
		return styleTypeId;
	}
	public void setStyleTypeId(int styleTypeId) {
		this.styleTypeId = styleTypeId;
	}
    
}
