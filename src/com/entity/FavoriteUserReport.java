package com.entity;

import java.util.Date;

public class FavoriteUserReport {
	
private Integer id;
private String fullname;
private String email;
private Date like_date;


public FavoriteUserReport(Integer id, String fullname, String email, Date like_date) {
	
	this.id = id;
	this.fullname = fullname;
	this.email = email;
	this.like_date = like_date;
}
public FavoriteUserReport() {
	
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getLike_date() {
	return like_date;
}
public void setLike_date(Date like_date) {
	this.like_date = like_date;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getLikeDate() {
	return like_date;
}
public void setLikeDate(Date likeDate) {
	this.like_date = likeDate;
}
}
