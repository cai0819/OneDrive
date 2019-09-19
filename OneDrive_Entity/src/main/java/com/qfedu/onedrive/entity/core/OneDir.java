package com.qfedu.onedrive.entity.core;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: OneDrive
 * @ClassName: OneDir
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-16 20:44
 **/
@Data
@TableName("t_dir")
public class OneDir {
    private int id;
    private String name;
}
