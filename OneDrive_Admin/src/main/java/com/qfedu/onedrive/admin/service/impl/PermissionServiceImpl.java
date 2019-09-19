package com.qfedu.onedrive.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.onedrive.admin.core.util.RUtil;
import com.qfedu.onedrive.admin.core.vo.R;
import com.qfedu.onedrive.admin.dao.PermissionDao;
import com.qfedu.onedrive.admin.entity.Sys_permission;
import com.qfedu.onedrive.admin.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;

/**
 * @program: OneDrive
 * @ClassName: PermissionServiceImpl
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-17 22:00
 **/
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Sys_permission> implements PermissionService {

    @Override
    public R checkPerms(String perms) {
        try {
            SecurityUtils.getSubject().checkPermission(perms);
            return RUtil.setOK("拥有此权限");
        } catch (Exception e) {
            return RUtil.setERROR("暂无权限");
        }

    }
}
