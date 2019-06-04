package com.example.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.PermissionRepository;
import com.example.dao.RolePermissionRepository;
import com.example.dao.UserRepository;
import com.example.dao.UserRoleRepository;
import com.example.entity.SysPermission;
import com.example.entity.SysRolePermission;
import com.example.entity.SysUser;
import com.example.entity.SysUserRole;


/**
 * 获取用户的角色和权限信息 
 */
public class ShiroRealm extends AuthorizingRealm {

	private Log logger = LogFactory.getLog(ShiroRealm.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private RolePermissionRepository rolePermissionRepository;
	@Autowired
	private PermissionRepository permissionRepository;

	/**
	 * 登录认证
	 *
	 * @param authenticationToken
	 *            身份验证令牌
	 * @return
	 * @throws AuthenticationException
	 *             身份验证异常
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		logger.info("验证当前Subject时获取到token为：" + token.toString());
		// 查出是否有此用户
		SysUser hasUser = userRepository.findByName(token.getUsername());
		if (hasUser != null) {
			Session session = SecurityUtils.getSubject().getSession();
			// 成功则放入session
			session.setAttribute("user", hasUser);
			List<SysUserRole> roleIds=userRoleRepository.findByUid(hasUser.getUid());
			List<SysPermission> permissionslist =new ArrayList<SysPermission>();
			for(SysUserRole role:roleIds) {
				List<SysRolePermission> pIds=rolePermissionRepository.findByRoleId(role.getRoleId());
				for(SysRolePermission pId:pIds) {
					SysPermission sys=permissionRepository.findById(pId.getPermissionId()).get();
					permissionslist.add(sys);
					}
			}
			session.setAttribute("permissionslist", permissionslist);
			ByteSource salt = ByteSource.Util.bytes(hasUser.getSalt());
			String realmName = this.getName();
			logger.info("<<<<<<<<<<<<<<<<"+realmName+"====登录成功>>>>>>>>>>>>>>");
			// 将账户名，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理
			return new SimpleAuthenticationInfo(hasUser.getName(), hasUser.getPassword(), salt, realmName);
		}
		return null;
	}

	/**
	 * 权限认证
	 *
	 * @param principalCollection
	 *            主要收集
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.info("<<<<<<<<<<<<   执行Shiro权限认证     >>>>>>>>>>");
		// 获取当前登录输入的用户名，等价于(String)
		// principalCollection.fromRealm(getName()).iterator().next();
		// String loginName = (String) super.getAvailablePrincipal(principalCollection);
		SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
		// 到数据库查是否有此对象
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		// user = userMapper.findByName(loginName);
		SysUser data_user = userRepository.findByName(user.getUsername());
		if (data_user != null) {
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户的角色集合
			// info.addRoles(user.getRoleStrlist());
			// 用户的权限集合
			// info.addStringPermissions(user.getPerminsStrlist());
			return info;
		}
		// 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
		return null;
	}

}