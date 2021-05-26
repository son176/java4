package com.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.entity.User;
import com.entity.Video;
import com.utils.HibernateUtils;

public class VideoDAO {
	private Session hSession;

	public VideoDAO() {
		hSession = HibernateUtils.getSession();
	}

	public List<Video> pagiate(int offset, int limit) {
		String hql = "FROM Video entity WHERE entity.id >= 1 ORDER BY entity.views DESC ";
		Query query = this.hSession.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		List<Video> listVideo = query.getResultList();
		return listVideo;
	}

	public Video findById(int id) {
		Video entity = this.hSession.get(Video.class, id);
		return entity;
	}

	public List<Video> findAll() {
		String hql = "FROM Video";
		Query query = hSession.createQuery(hql);
		List<Video> listVideo = query.getResultList();
		return listVideo;
	}

	public void update(Video entity) {
		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.update(entity);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
		}
	}
	public void delete(Video entity) {
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

	public Video store(Video entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		entity.setId(id);
		return entity;
	}

}
