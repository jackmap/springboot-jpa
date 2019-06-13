package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sys_role database table.
 * 
 */
@Entity
@Table(name = "sys_role")
@NamedQuery(name = "SysRole.findAll", query = "SELECT s FROM SysRole s")
public class SysRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id; // 编号
	private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
	private String description; // 角色描述,UI界面显示使用
	private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户

	// 角色 -- 权限关系：多对多关系;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "SysRolePermission", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {
//			@JoinColumn(name = "permissionId") })
//	private List<Integer> permissions;
	private String permissions;
	// 用户 - 角色关系定义;
//	@ManyToMany
//	@JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {
//			@JoinColumn(name = "uid") })
//	private List<SysUser> users;// 一个角色对应多个用户

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
}