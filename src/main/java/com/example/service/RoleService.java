package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.SysRole;
import com.example.entity.SysUser;

/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
public interface RoleService {
	SysRole findByName(String name);

	void deleteById(Integer id);

	void AddSysRole(SysRole user);

	List<SysRole> findAll();

	Page<SysRole> findAll(Pageable pageable);
}
