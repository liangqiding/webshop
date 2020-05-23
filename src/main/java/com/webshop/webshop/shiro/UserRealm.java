package com.webshop.webshop.shiro;

import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.UserServiceImp;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author
 * @version 1.0
 * @date 2019/12/12/012 20:59
 * @descriptio
 */

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserServiceImp userServiceImp;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection args0) {
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
//           User_role u= roleMapper.SelectRoleById(user.getR_id());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        try {
//            System.out.println("执行授权逻辑,权限为："+u.getAuthority());
//            info.addStringPermission(u.getAuthority());
//        } catch (Exception e) {
//            System.out.println("执行授权逻辑,您没有权限进入该页面！");
//            return null;
//        }
        System.out.println("11");
        return null;
    }
//执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken args) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        UsernamePasswordToken userToken= (UsernamePasswordToken) args;
        String username = userToken.getUsername();
//        判断用户名空
        User user = userServiceImp.SelectUserByUsername(username);
        if (user==null){
            System.out.println("用户名空");
            return null;
        }
        System.out.println("执行密码验证！");
        //自定义盐值
        ByteSource salt = ByteSource.Util.bytes("xxx");
//        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,//安全数据,存入凭证的信息，登陆成功后可以使用 SecurityUtils.getSubject().getPrincipal();在任何地方使用它
                user.getPassword(),//密码
                salt,
                getName()
        );
        System.out.println(authenticationInfo.getCredentials());
        return authenticationInfo;
    }
}
