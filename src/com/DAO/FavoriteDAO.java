package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.entity.Favorite;
import com.entity.FavoriteReport;
import com.entity.FavoriteUserReport;
import com.entity.User;
import com.entity.Video;
import com.utils.HibernateUtils;

public class FavoriteDAO {
	private Session hSession;

	public FavoriteDAO() {
		hSession = HibernateUtils.getSession();
	}

	public List<Favorite> findID(User id) {
		String hql = " SELECT E FROM Favorite E WHERE E.user =:id";
		Query query = hSession.createQuery(hql);
		query.setParameter("id", id);
		List<Favorite> list = query.getResultList();
		return list;
	}

	public Favorite insert(Favorite entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		entity.setId(id);
		return entity;
	}

	public void delete(Favorite entity) {
		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.delete(entity);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
			throw e;
		}
	}

	public Favorite findById(int id) {
		Favorite entity = this.hSession.get(Favorite.class, id);
		return entity;
	}

	public List<Favorite> findAll() {
		String hql = "FROM Favorite";
		Query query = hSession.createQuery(hql);
		List<Favorite> list = query.getResultList();
		return list;
	}

	public List<FavoriteUserReport> reportFavoriteUsersByVideos(int video_id) {
		String hql = "select new com.entity.FavoriteUserReport(f.user.id,f.user.fullname,"
				+ " f.user.email,f.like_date) from Favorite f where f.video.id = :video_id";
		Query query = hSession.createQuery(hql);
		query.setParameter("video_id", video_id);
		List<FavoriteUserReport> list = query.getResultList();
		return list;
	}

	public List<FavoriteReport> reportFavoritesByVideos() {
		String hql = "select new com.entity.FavoriteReport(f.video.title,count(f),min(f.like_date),max(f.like_date)) "
				+ " from Favorite f group by f.video.title ";
		Query query = hSession.createQuery(hql);
		List<FavoriteReport> list = query.getResultList();
		return list;
	}

}
