package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.User;
import edu.com.utils.JpaUtils;

public class UserDAO {

//	public UserDAO() {
////		//extend superclass constructor
////		//User.class = entityClass
//		super(User.class);
//	}
	EntityManager em = JpaUtils.getEntityManager();

	public boolean signIn(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.dangky");
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public User chekckLogin(String username, String password) {
		try {
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.checklogin");
			query.setParameter("id", username);
			query.setParameter("password", password);
			return (User) query.getSingleResult();// trả về 1 đối tượng
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.themUser");
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public boolean update(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.capnhatUser");
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}
	public boolean editProfile(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.editthongtincanhan");			
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public void delete(String id) {
		try {
			em.getTransaction().begin();
			User user = em.find(User.class, id);
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public List<User> findbyAll() {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.selectUserAll");
		return query.getResultList();
	}

	public User findByID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.selectUserbyID");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}
}
