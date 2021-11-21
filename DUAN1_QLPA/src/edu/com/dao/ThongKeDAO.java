package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.Favorite;
import edu.com.supportModel.FavoriteReport;
import edu.com.utils.JpaUtils;

public class ThongKeDAO {
	EntityManager em = JpaUtils.getEntityManager();
	public Favorite findByVideoID(String videoID) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("favorite.thongkeuserbyFV");
		query.setParameter("videoID", videoID);
		return (Favorite) query.getSingleResult();
	}

	public List<Favorite> countFavorite() {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("favorite.thongke");
		return query.getResultList();
	}
	public List<FavoriteReport> FavoriteReport() {
		String jpql="select new edu.com.supportModel.FavoriteReport(f.video.title,count(f),min(f.likeDate),max(f.likeDate)) "
				+ " from Favorite f group by f.video.title " ;
		List<FavoriteReport>list= null;
		try{
			TypedQuery<FavoriteReport>query = em.createQuery(jpql,FavoriteReport.class);
			list= query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		 return list;
	}
	
}
