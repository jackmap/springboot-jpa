package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.SysPression;
import com.example.entity.SysUser;

/**
 * @deprecated:
 * @author作者：mp 2019年6月3日
 */
public interface PressionService {
	SysPression findByName(String name);

	void deleteById(Integer id);

	void AddSysPression(SysUser user);

	List<SysPression> findAll();

	Page<SysPression> findAll(Pageable pageable);
}
