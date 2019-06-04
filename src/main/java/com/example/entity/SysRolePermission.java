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
    @GeneratedValue
    private int id;
	@Column(name="permission_id")
	private Integer permissionId;

	@Column(name="role_id")
	private Integer roleId;

	public SysRolePermission() {
	}

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}