package com.peng.meng.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="sys_function")
@Entity
public class Function {

	@Id
	@Column(name="function_id")
	private String functionId;
	@Column(name="function_name")
	private String functionName;
	@Column(name="function_addr")
	private String functionAddr;
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	@Column(name="parent_id")
	private String parentId;
	
	@ManyToMany(mappedBy="functions")
	private List<Role> roleList;

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionAddr() {
		return functionAddr;
	}

	public void setFunctionAddr(String functionAddr) {
		this.functionAddr = functionAddr;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
}
