package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.SysUser;

/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
public interface UserService {

	SysUser findByName(String name);

	SysUser findByUserNameOrEmail(String username, String email);

	SysUser findByEmail(String email);

	@Transactional
	@Modifying
	@Query("delete from User where id = ?1")
	void deleteById(Integer id);

	void AddSysUser(SysUser user);

	List<SysUser> findAll();

	Page<SysUser> findAll(Pageable pageable);
}
