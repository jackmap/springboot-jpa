package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.SysRole;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月3日
*/
public interface RoleRepository  extends JpaRepository<SysRole, Integer> {
}
