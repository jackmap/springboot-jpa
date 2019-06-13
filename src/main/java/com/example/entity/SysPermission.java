package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sys_pression database table.
 * 
 */
@Entity
@Table(name = "sys_pression")
@NamedQuery(name = "SysPermission.findAll", query = "SELECT s FROM SysPermission s")
public class SysPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;// 主键.
	private String name;// 名称.
	@Column(columnDefinition = "enum('menu','button')")
	private String resourceType;// 资源类型，[menu|button]
	private String url;// 资源路径.
	private String permission; // 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
	private String parentId; // 父编号
	private Boolean available = Boolean.FALSE;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}

}