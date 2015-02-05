package com.ms.h2hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	private String type; // audio, video
	private String PID;
	private String title;
	private String artist;
	private int duration;
	
	@Column(name = "DURATION", nullable = false)
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Column(name = "TYPE", nullable = false, length = 20)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Id
	@Column(name = "PID", unique = true, nullable = false, length = 12)
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}

	@Column(name = "TITLE", nullable = false, length = 1000)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "ARTIST", nullable = false, length = 1000)
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Product [type=" + type + ", PID=" + PID + ", title=" + title
				+ ", artist=" + artist + ", duration=" + duration + "]";
	}
	
}
