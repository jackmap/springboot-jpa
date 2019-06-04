package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sys_user_role database table.
 * 
 */
@Entity
@Table(name = "sys_user_role")
@NamedQuery(name = "SysUserRole.findAll", query = "SELECT s FROM SysUserRole s")
public class SysUserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "role_id")
	private Integer roleId;

	private Integer uid;

	public SysUserRole() {
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}