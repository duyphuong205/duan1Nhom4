package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.User;
import edu.com.model.Video;
import edu.com.utils.JpaUtils;

public class VideoDAO {

//	public VideoDAO() {
//		//extend superclass constructor
//		//Video.class = entityClass
//		super(Video.class);
//	}
	EntityManager em = JpaUtils.getEntityManager();

	public boolean insert(Video video) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.themVideo");
			em.persist(video);
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

	public boolean update(Video video) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.capnhapVideo");
			em.merge(video);
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
			Video video= em.find(Video.class, id);
			em.remove(video);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public List<Video> findbyAll() {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.selectVideoAll");
		return query.getResultList();
	}

	public Video findByID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.selectVideobyID");
		query.setParameter("id", id);
		return (Video) query.getSingleResult();
	}
}
