package com.peng.meng.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="sys_user")
public class User {

	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	

	@ManyToMany
	@JoinTable(name="sys_user_role",joinColumns=@JoinColumn(columnDefinition="user_id",referencedColumnName="user_id")
	,inverseJoinColumns=@JoinColumn(columnDefinition="role_id",referencedColumnName="role_id"))
	private List<Role> roleList = new ArrayList<Role>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
}
