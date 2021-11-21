package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.Share;
import edu.com.model.User;
import edu.com.utils.JpaUtils;

public class ShareDAO  {

//	public ShareDAO() {
//		//extend superclass constructor
//		//Share.class = entityClass
//		super(Share.class);
//	}
	EntityManager em= JpaUtils.getEntityManager();
	public boolean insert(Share share) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Share.Video");
			em.persist(share);
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
	
}


























