package com.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.Favorite;
import com.entity.Share;
import com.entity.User;
import com.utils.HibernateUtils;

public class ShareDAO {
	private Session hSession;

	public ShareDAO() {
		hSession = HibernateUtils.getSession();
	}
	public List<Share> findAll() {
		String hql = "FROM Share";
		Query query = hSession.createQuery(hql);
		List<Share> list = query.getResultList();
		return list;
	}
	
	
	public List<Share> findID(User id) {
		String hql = " SELECT E FROM Share E WHERE E.user =:id";
		Query query = hSession.createQuery(hql);
		query.setParameter("id", id);
		List<Share> list = query.getResultList();
		return list;
	}
	public Share insert(Share entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		entity.setId(id);
		return entity;
	}

	
}
