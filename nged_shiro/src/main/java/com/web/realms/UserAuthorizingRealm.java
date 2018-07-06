package com.web.realms;

import com.web.model.TRole;
import com.web.model.TUser;
import com.web.service.PermissionService;
import com.web.service.RoleService;
import com.web.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


public class UserAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //查询用户
        String username = (String)authenticationToken.getPrincipal();
        TUser user = userService.queryUserByUserName(username);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(),getName());
        return simpleAuthenticationInfo;
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户 角色和权限
        String username = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        TUser user = userService.queryUserByUserName(username);
        //getRolesByUsername
        Set<String> roleSet = roleService.queryRolesByUserId(user.getId());
        simpleAuthorizationInfo.setRoles(roleSet);
        //getPermissionByUsername
        Set<String> permissionSet = permissionService.queryPermissionsByUserId(user.getId());
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;


    }
}
