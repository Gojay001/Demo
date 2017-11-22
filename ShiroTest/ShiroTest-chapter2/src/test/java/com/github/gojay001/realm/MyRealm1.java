package com.github.gojay001.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author Gojay
 * @date 2017/11/21
 */
public class MyRealm1 implements Realm {
    public String getName() {
        return "myRealm1";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 得到用户名
        String username = (String)authenticationToken.getPrincipal();
        // 得到密码
        String password = new String((char[])authenticationToken.getCredentials());
        if(!"root".equals(username)) {
            //用户名错误
            throw new UnknownAccountException();
        }
        if(!"root".equals(password)) {
            //密码错误
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
