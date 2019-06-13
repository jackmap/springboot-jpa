package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sys_role_permission database table.
 * 
 */
@Entity
@Table(name="sys_role_permission")
@NamedQuery(name="SysRolePermission.findAll", query="SELECT s FROM SysRolePermission s")
public class SysRolePermission implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    private int id;
	@Column(name="permission_id")
	private int permissionId;

	@Column(name="role_id")
	private int roleId;

	public SysRolePermission() {
	}

	public int getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}