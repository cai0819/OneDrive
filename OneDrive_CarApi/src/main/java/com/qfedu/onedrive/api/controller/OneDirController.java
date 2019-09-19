package com.qfedu.onedrive.api.controller;

import com.qfedu.onedrive.api.service.OneDirService;
import com.qfedu.onedrive.common.vo.R;
import com.qfedu.onedrive.entity.core.OneDir;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: OneDrive
 * @ClassName: OneDirController
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-16 21:45
 **/
@Api(value = "字典操作",tags = "字典操作")
@RestController
public class OneDirController {

    @Autowired
    private OneDirService dirService;

    //新增
    @ApiOperation(value = "新增字典内容",notes = "新增字典内容")
    @PostMapping("/server/dir/savedir.do")
    public R save(@RequestBody OneDir dir){
        return dirService.save(dir);
    }
    //查询
    @ApiOperation(value = "查询字典内容",notes = "查询字典内容")
    @GetMapping("/server/dir/querydir.do")
    public R detail(@RequestParam("id") int id){
        return dirService.detail(id);
    }
    //删除
    @ApiOperation(value = "删除字典内容",notes = "删除字典内容")
    @DeleteMapping("/server/dir/deldir.do")
    public R del(@RequestParam int id){
        return dirService.del(id);
    }
}

