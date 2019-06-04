package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.SysRolePermission;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月3日
*/
public interface RolePermissionRepository  extends JpaRepository<SysRolePermission, Integer> {

    List<SysRolePermission>  findByRoleId(Integer roleId);
}
