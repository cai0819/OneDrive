package com.qfedu.onedrive.entity.car;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("t_carbrand")
public class CarBrand {
   private int id;
   private String name;
   private String imgurl;
   private String info;
   private String country ;
}
