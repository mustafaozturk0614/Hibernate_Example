package com.bilgeadam.hibernateexample.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * username 
 * password
 * gender (String)
 * 
 * crud metotolar? yaz?lacak bir interface
 * UserDao bir class olu?trup buraya implement edece?iz
 * 
 */

@Entity
@Table(name = "tbluser")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(length = 32)
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	private UserDetail userDetail;

//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, UserDetail userDetail) {
		super();
		this.username = username;
		this.password = password;
		this.userDetail = userDetail;
	}

	public User(String username, String password, UserDetail userDetail, List<Post> posts) {
		super();
		this.username = username;
		this.password = password;
		this.userDetail = userDetail;
		this.posts = posts;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> post) {
		this.posts = post;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userDetail="
				+ userDetail.getId() + ", posts=" + posts + "]";
	}

}
