package com.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;
import com.entity.Video;
import com.utils.HibernateUtils;

public class UserDAO {
	private Session hSession;

	public UserDAO() {
		hSession = HibernateUtils.getSession();
	}

	public User login(String email, String password) {
		String hql = "SELECT entity FROM User entity WHERE entity.email =:email AND entity.password =:password";
		Query query = this.hSession.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			User entity = (User) query.getSingleResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<User> findAll() {
		String hql = "FROM User";
		Query query = hSession.createQuery(hql);
		List<User> list = query.getResultList();
		return list;
	}
	public User findById(int id) {
		User entity = this.hSession.get(User.class, id);
		return entity;
	}
	public void update(User user) {
		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.update(user);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
		}
	}
	public void delete(User entity) {
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
	public User selectByEmail(String email) {
		String hql = "select e from User e where e.email = :email ";
		Query query = hSession.createQuery(hql);
		query.setParameter("email", email);
		User user = (User) query.getSingleResult();
		return user;
	}
}