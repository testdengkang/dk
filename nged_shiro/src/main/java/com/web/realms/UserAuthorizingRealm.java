package com.web.realms;

import com.core.utils.SecurityUtil;
import com.web.common.ReturnMessage;
import com.web.common.StatusCodeUtils;
import com.web.model.TRole;
import com.web.model.TUser;
import com.web.service.PermissionService;
import com.web.service.RoleService;
import com.web.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Set;


public class UserAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    //认证 登录是会调用
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //查询用户
        String username = (String)authenticationToken.getPrincipal();
        String pwd = new String((char[])authenticationToken.getCredentials());

        TUser quser = userService.queryUserByUserName(username);

        //根据username 查询用户

        if(quser==null){
            throw new UnknownAccountException(); //如果用户名错误
        }

        if(!("1").equals(quser.getLocked())){
           throw new LockedAccountException();
        }

        //根据用户名获取盐
        //验证用户
        if(!quser.getPassword().equals(getEncryptMd5String(pwd,quser.getSalt()))){
            throw new IncorrectCredentialsException();
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,
                pwd,getName());
        return simpleAuthenticationInfo;
    }

    public String getEncryptMd5String(String str,String salt){
        return SecurityUtil.encryptMd5NoBase64(SecurityUtil.encryptMd5NoBase64(str)+salt);
    }

    public TUser EncryptPwd(TUser user){
        String salt = String.valueOf((new Date()).getTime());
        user.setPassword(getEncryptMd5String(user.getPassword(),salt));
        user.setSalt(salt);
        return user;
    }

    //授权 每次拦截访问权限时 会调用
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
