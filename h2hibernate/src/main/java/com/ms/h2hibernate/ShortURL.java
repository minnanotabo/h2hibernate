package com.ms.h2hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SHORTURL")
public class ShortURL {
	// long Id;
	String originalURL;
	String shortURL;
	Date createDate;
	Date updateDate;
	String loginId;
	
	@Column(name = "LOGINID", unique = false, nullable = true, length=100)
	public String getLoginId() {
		return loginId;
	}
	@Override
	public String toString() {
		return "ShortURL [originalURL=" + originalURL + ", shortURL="
				+ shortURL + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", loginId=" + loginId + "]";
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	@Column(name = "ORIGINALURL", unique = false, nullable = false, length=2000)
	public String getOriginalURL() {
		return originalURL;
	}
	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	@Id
	@Column(name = "SHORTURL", unique = false, nullable = false, length=2000)
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LASTUPDATEDATE", nullable = false, length = 7)
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
