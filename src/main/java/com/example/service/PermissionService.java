package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.SysPermission;

/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
public interface PermissionService {
	SysPermission findByName(String name);

	void deleteById(Integer id);

	void AddSysPression(SysPermission user);

	List<SysPermission> findAll();

	Page<SysPermission> findAll(Pageable pageable);
}
