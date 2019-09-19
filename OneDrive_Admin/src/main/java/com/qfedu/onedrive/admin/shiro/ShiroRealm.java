package com.qfedu.onedrive.admin.shiro;

import com.qfedu.onedrive.admin.dao.MemberDao;
import com.qfedu.onedrive.admin.entity.Sys_member;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @program: OneDrive
 * @ClassName: ShiroRealm
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-17 20:04
 **/
@Service
public class ShiroRealm extends AuthorizingRealm {
    @Autowired(required = false)
    private MemberDao memberDao;
    /**
     * 授权 查询当前登录用户的所有权限和角色
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1、获取登录的用户
        Sys_member member =(Sys_member) SecurityUtils.getSubject().getSession().getAttribute("member");
        //2、根据登录用户查询权限
        Set<String> perms =memberDao.selectPerms(member.getId());
        //3、设置权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(perms);
        return authorizationInfo;
    }
    /**
     * 认证 登录*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        if (token != null){
            //创建票据对象
            return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());

        }else {
            return null;
        }


    }
}
