package cn.camork.utils;

import cn.camork.model.UserBean;
import cn.camork.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Camork on 2017-05-18.
 */
@Controller
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		String username = upToken.getUsername();

		UserBean user = userService.userLogin(username);
		if (user == null) {
			throw new UnknownAccountException("用户不存在!");
		}
		String realmName = getName();

		return new SimpleAuthenticationInfo(user.getUserName(), user.getUserPass(), realmName);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		String principal = (String) principals.getPrimaryPrincipal();

		int userRole = userService.userLogin(principal).getUserRole();

		Set<String> roles = new HashSet<>();
		roles.add("user");
		if (userRole == 1) {
			roles.add("admin");
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

		return info;
	}
}
