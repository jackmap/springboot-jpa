package com.example.until;

import org.apache.shiro.SecurityUtils;

import com.example.entity.SysUser;

public class StaticDataUtil {
	/**
	 * 获取session中的当前登陆用户
	 * @return
	 */
	public final static SysUser getSessionUser() {
		SysUser user = (SysUser)SecurityUtils.getSubject().getSession().getAttribute("user");
		return user;
	}
	
}
