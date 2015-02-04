package com.ms.h2hibernate;

public class Product {
	private String type; // audio, video
	private String PID;
	private String title;
	private String artist;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Product [type=" + type + ", PID=" + PID + ", title=" + title
				+ ", artist=" + artist + "]";
	}
	
}
