package com.qfedu.onedrive.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.onedrive.admin.core.vo.R;
import com.qfedu.onedrive.admin.dto.MenuDto;
import com.qfedu.onedrive.admin.dto.UserDto;
import com.qfedu.onedrive.admin.entity.Sys_member;

import java.util.List;

/**
 * @program: OneDrive
 * @ClassName: MemberService
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-17 21:53
 **/
public interface MemberService extends IService<Sys_member> {

    R login(UserDto userDto);
    R loginOut();
    R<List<MenuDto>> queryMenus();

}
