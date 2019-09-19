package com.qfedu.onedrive.admin.web;

import com.qfedu.onedrive.admin.core.vo.R;
import com.qfedu.onedrive.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: OneDrive
 * @ClassName: PermissionController
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-18 14:37
 **/
@RestController
public class PermissionController {

    @Autowired(required = false)
    private PermissionService permissionService;
    //校验指定的权限是否存在
    @GetMapping("/web/permission/checkperms.do")
    public R checkper(String perms){
        return permissionService.checkPerms(perms);
    }

}
