package edu.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the Favorites database table.
 * 
 */
@Entity
@Table(name = "Favorites")
@NamedQuery(name = "Favorite.findAll", query = "SELECT f FROM Favorite f")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "favorite.thongke", procedureName = "sp_thongkefavorite", resultClasses = {
				Favorite.class,Video.class}),
		
		@NamedStoredProcedureQuery(name = "favorite.thongkeuserbyFV", procedureName = "sp_thongkeUserbyFivoriteVideo", resultClasses = {
				Favorite.class }, parameters = { @StoredProcedureParameter(name = "videoID", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "favorite.like", procedureName = "sp_yeuthichvideo", resultClasses = {
				Favorite.class }, parameters = { @StoredProcedureParameter(name = "userID", type = String.class),
						@StoredProcedureParameter(name = "videoID", type = String.class),
						@StoredProcedureParameter(name = "likeDate", type = Date.class) }),

		@NamedStoredProcedureQuery(name = "favorite.unlike", procedureName = "sp_boyeuthichVideo", resultClasses = {
				Favorite.class }, parameters = { @StoredProcedureParameter(name = "@fID", type = Integer.class) }) })

public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Date likeDate;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;

	// bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name = "videoID")
	private Video video;

	public Favorite() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLikeDate() {
		return this.likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Favorite(int id, Date likeDate, User user, Video video) {
		super();
		this.id = id;
		this.likeDate = likeDate;
		this.user = user;
		this.video = video;
	}


	@Override
	public String toString() {
		return "Favorite [id=" + id + ", likeDate=" + likeDate + ", user=" + user + ", video=" + video + "]";
	}

}