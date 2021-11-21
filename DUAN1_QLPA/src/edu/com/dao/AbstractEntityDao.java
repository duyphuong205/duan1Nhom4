package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.com.utils.JpaUtils;

public abstract class AbstractEntityDao<E> {
	private Class<E> entityClass;

	// entityClass đối tượng thể hiện của entity
	public AbstractEntityDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public void insert(E entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(entity);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			em.close();
		}
	}

	public void update(E entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.merge(entity);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			em.close();
		}
	}

	public void delete(Object id) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			E entity = em.find(entityClass, id);
			em.merge(entity);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			em.close();
		}
	}

	public E findByID(Object id) {
		EntityManager em = JpaUtils.getEntityManager();
		E entity = em.find(entityClass, id);
		return entity;
	}

	public List<E> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			// tạo CriteriaQuery để xây dựng các truy vấn
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			// from(entityClass) tạo ra truy vấn từ entity class
			cq.select(cq.from(entityClass));
			return em.createQuery(cq).getResultList();
		} finally {
			em.close();
		}
	}

	public Long count() {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			// tạo CriteriaQuery để xây dựng các truy vấn
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			// truy vấn bao nhiêu entity thì tạo root tương ứng
			Root<E> root = cq.from(entityClass);
			// đếm các phần tử dựa vào truy vấn
			cq.select(em.getCriteriaBuilder().count(root));
			Query query = em.createQuery(cq);
			return (Long) query.getSingleResult();
		} finally {
			em.close();
		}
	}

	// tìm kiếm phân trang và trả về số phần tử hiện có ở trong trang
	public List<E> findAll(boolean all, int firstresult, int maxresult) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			// tạo CriteriaQuery để xây dựng các truy vấn
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(entityClass));
			Query query = em.createQuery(cq);
			// all= true thì return về all result
			if (!all) {
				query.setFirstResult(firstresult);// thiết lập giá trị đầu tiên
				query.setMaxResults(maxresult);// trả về số phần tử tối đa
			}
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
