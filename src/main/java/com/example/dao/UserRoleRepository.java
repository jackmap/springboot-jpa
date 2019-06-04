package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.SysUserRole;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月3日
*/
public interface UserRoleRepository  extends JpaRepository<SysUserRole, Integer> {

	 List<SysUserRole>  findByUid(Integer userId);
}
