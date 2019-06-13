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
	private int id;
	@Column(name = "role_id")
	private int roleId;

	private int uid;

	public SysUserRole() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}