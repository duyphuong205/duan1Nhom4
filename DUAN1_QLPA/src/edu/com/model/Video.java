package edu.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Videos database table.
 * 
 */
@Entity
@Table(name = "Videos")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "Video.themVideo", procedureName = "sp_insertVideo", resultClasses = {
				Video.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class),
						@StoredProcedureParameter(name = "title", type = String.class),
						@StoredProcedureParameter(name = "poster", type = String.class),
						@StoredProcedureParameter(name = "view", type = Integer.class),
						@StoredProcedureParameter(name = "description", type = String.class),
						@StoredProcedureParameter(name = "active", type = Boolean.class) }),

		@NamedStoredProcedureQuery(name = "Video.capnhapVideo", procedureName = "sp_update_video", resultClasses = {
				Video.class }, parameters = { @StoredProcedureParameter(name = "title", type = String.class),
						@StoredProcedureParameter(name = "poster", type = String.class),
						@StoredProcedureParameter(name = "view", type = Integer.class),
						@StoredProcedureParameter(name = "description", type = String.class),
						@StoredProcedureParameter(name = "active", type = Boolean.class),
						@StoredProcedureParameter(name = "id", type = String.class) }),

		@NamedStoredProcedureQuery(name = "Video.xoaVideo", procedureName = "sp_xoaVideo", resultClasses = {
				Video.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class) }),

		@NamedStoredProcedureQuery(name = "Video.selectVideobyID", procedureName = "SP_videoID", resultClasses = {
				Video.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class) }),

		@NamedStoredProcedureQuery(name = "Video.selectVideoAll", procedureName = "SP_selectAllVideo", resultClasses = {
				Video.class })

})
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private boolean active;

	private String description;

	private String poster;

	private String title;

	private int views;

	// bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy = "video")
	private List<Favorite> favorites;

	// bi-directional many-to-one association to Share
	@OneToMany(mappedBy = "video")
	private List<Share> shares;

	public Video() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setVideo(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setVideo(null);

		return favorite;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setVideo(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setVideo(null);

		return share;
	}

	public Video(String id, boolean active, String description, String poster, String title, int views,
			List<Favorite> favorites, List<Share> shares) {
		super();
		this.id = id;
		this.active = active;
		this.description = description;
		this.poster = poster;
		this.title = title;
		this.views = views;
		this.favorites = favorites;
		this.shares = shares;
	}

}