package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="videos")
public class Video implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="poster")
	private String poster;
	@Column(name="views")
	private Integer views;
	@Column(name="description")
	private String description;
	@Column(name="active")
	private Integer active;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "video",cascade = CascadeType.ALL)
	private List<Share> Shares;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "video",cascade = CascadeType.ALL)
	private List<Favorite> favorites;
	
	public List<Share> getShares() {
		return Shares;
	}
	public void setShares(List<Share> shares) {
		Shares = shares;
	}
	public List<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	public Video() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}

	
}
