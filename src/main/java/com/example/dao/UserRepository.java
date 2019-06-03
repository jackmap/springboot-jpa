package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.SysUser;

/**
  *@deprecated:
  *@author作者：mp
  *2019年6月3日
*/
public interface UserRepository  extends JpaRepository<SysUser, Integer> {

	SysUser findByUserNameOrEmail(String username, String email);
}
