package com.qfedu.onedrive.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.onedrive.admin.core.vo.R;
import com.qfedu.onedrive.admin.entity.Sys_permission;

/**
 * @program: OneDrive
 * @ClassName: MemberService
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-17 21:53
 **/
public interface PermissionService extends IService<Sys_permission> {

    R checkPerms(String perms);
}
