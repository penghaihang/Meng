package com.peng.meng.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Table(name = "sys_role")
@Entity
public class Role implements GrantedAuthority {

  @Id
  @Column(name = "role_id")
  private String roleId;
  @Column(name = "role_name")
  private String roleName;

  @ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER)
  private List<User> userList;

  @ManyToMany
  @JoinTable(name = "sys_role_func", joinColumns = @JoinColumn(columnDefinition = "role_id",
      referencedColumnName = "role_id"), inverseJoinColumns = @JoinColumn(
      columnDefinition = "function_id", referencedColumnName = "function_id"))
  private List<Function> functions = new ArrayList<>();

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  public List<Function> getFunctions() {
    return functions;
  }

  public void setFunctions(List<Function> functions) {
    this.functions = functions;
  }

  @Override
  public String getAuthority() {

    return roleName;
  }
}
