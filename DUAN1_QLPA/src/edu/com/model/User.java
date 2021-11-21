package edu.com.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name = "Users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "User.dangky", procedureName = "sp_register", resultClasses = {
				User.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class),
						@StoredProcedureParameter(name = "fullname", type = String.class),
						@StoredProcedureParameter(name = "password", type = String.class),
						@StoredProcedureParameter(name = "email", type = String.class) }),

		@NamedStoredProcedureQuery(name = "User.checklogin", procedureName = "sp_login", resultClasses = User.class, parameters = {
				@StoredProcedureParameter(name = "id", type = String.class),
				@StoredProcedureParameter(name = "password", type = String.class) }),

		@NamedStoredProcedureQuery(name = "User.themUser", procedureName = "sp_insertUser", resultClasses = {
				User.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class),
						@StoredProcedureParameter(name = "password", type = String.class),
						@StoredProcedureParameter(name = "email", type = String.class),
						@StoredProcedureParameter(name = "fullname", type = String.class),
						@StoredProcedureParameter(name = "admin", type = Boolean.class) }),

		@NamedStoredProcedureQuery(name = "User.capnhatUser", procedureName = "sp_UpdateUser", resultClasses = {
				User.class }, parameters = { 
						@StoredProcedureParameter(name = "password", type = String.class),
						@StoredProcedureParameter(name = "email", type = String.class),
						@StoredProcedureParameter(name = "fullname", type = String.class),
						@StoredProcedureParameter(name = "admin", type = Boolean.class),
						@StoredProcedureParameter(name = "id", type = String.class)}),
	
		@NamedStoredProcedureQuery(name = "User.editthongtincanhan", procedureName = "sp_editprofile", resultClasses = {
				User.class }, parameters = {
						@StoredProcedureParameter(name = "fullname", type = String.class),
						@StoredProcedureParameter(name = "password", type = String.class),
						@StoredProcedureParameter(name = "email", type = String.class),
						 @StoredProcedureParameter(name = "id", type = String.class)}),

		@NamedStoredProcedureQuery(name = "User.xoaUser", procedureName = "sp_DeleteUser", resultClasses = {
				User.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class) }),

		@NamedStoredProcedureQuery(name = "User.selectUserbyID", procedureName = "sp_selectUserbyID", resultClasses = {
				User.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class) }),

		@NamedStoredProcedureQuery(name = "User.selectUserAll", procedureName = "sp_selectallUser", resultClasses = {
				User.class })

})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private boolean admin;

	private String email;

	private String fullname;

	private String password;
	


	// bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy = "user")
	private List<Favorite> favorites;

	// bi-directional many-to-one association to Share
	@OneToMany(mappedBy = "user")
	private List<Share> shares;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setUser(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setUser(null);

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
		share.setUser(this);

		return share;
	}

	public User(String id, boolean admin, String email, String fullname, String password, List<Favorite> favorites,
			List<Share> shares) {
		super();
		this.id = id;
		this.admin = admin;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.favorites = favorites;
		this.shares = shares;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setUser(null);

		return share;
	}

}