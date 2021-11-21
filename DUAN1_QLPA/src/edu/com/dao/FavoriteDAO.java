package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.Favorite;
import edu.com.model.User;
import edu.com.utils.JpaUtils;

public class FavoriteDAO  {

//	public FavoriteDAO() {
//		//extend superclass constructor
//		//Favorite.class = entityClass
//		super(Favorite.class);
//	}
    EntityManager em= JpaUtils.getEntityManager();
	public boolean inserLike(Favorite fa) {
		try {
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("favorite.like");
			em.getTransaction().begin();
			em.persist(fa);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}finally {
			em.close();
		}
		return true;
		}
		
		public void unLike(Integer fid) {
			try {
				em.getTransaction().begin();
				Favorite fa = em.find(Favorite.class, fid);
				em.remove(fid);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			}finally {
				em.close();
			}
		}

	
}


























