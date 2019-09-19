package com.qfedu.onedrive.admin.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.onedrive.admin.core.util.RUtil;
import com.qfedu.onedrive.admin.core.vo.R;
import com.qfedu.onedrive.admin.out.service.CarBrandService;
import com.qfedu.onedrive.entity.car.CarBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @program: OneDrive
 * @ClassName: CarBrandController
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-18 15:54
 **/
@RestController
public class CarBrandController {
    @Autowired
    private CarBrandService brandService;

    //新增

    @PostMapping("/web/carbrand/save.do")
    public R save(CarBrand carBrand) {
        return RUtil.setR(brandService.save(carBrand), "新增品牌");
    }
    //删除

    @DeleteMapping("/web/carbrand/del.do")
    public R del(int id){
        return RUtil.setR(brandService.removeById(id),"删除品牌");
    }
    //批量删除

    @DeleteMapping("/web/carbrand/delbatchids.do")
    public R delBatch(int[] ids){
        return RUtil.setR(brandService.removeByIds(Arrays.asList(ids)),"删除品牌");
    }

    //查询 条件 分页

    @GetMapping("/web/carbrand/querypage.do")
    public R query(Map<String,Object> map){
        //分页
        Page<CarBrand> page =new Page<CarBrand>((long)map.get("page"),(long)map.get("size"));
        //查询对象
        QueryWrapper<CarBrand> queryWrapper = new QueryWrapper<>();
        if(map.containsKey("name") && map.containsKey("country")){
            //lambda
            queryWrapper.lambda().like(CarBrand::getName,"%"+map.get("name")+"%").eq(CarBrand::getCountry,map.get("country"));
        }else {
            if (map.containsKey("name")){
                queryWrapper.like("name","%"+map.get("name")+"%");
            }
            if (map.containsKey("country")){
                String c=map.get("country").toString();
                if (c.equals("国产系列")){
                    queryWrapper.eq("country",c);
                }else {
                    queryWrapper.ne("country",c);
                }
            }
        }
        return RUtil.setOK("Ok",brandService.page(page,queryWrapper));
    }
    //详情信息
    @GetMapping("/web/carbrand/querydetail.do")
    public R query(int id){
        return RUtil.setOK("OK",brandService.getById(id));
    }
}
