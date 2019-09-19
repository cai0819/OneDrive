package com.qfedu;

import com.qfedu.onedrive.admin.core.config.SystemConfig;
import com.qfedu.onedrive.admin.core.util.EncryptionUtil;
import org.junit.Test;

/**
 * @program: OneDrive
 * @ClassName: admin
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-17 20:40
 **/
public class admin {
@Test
    public void pass1(){
    //1、创建秘钥
    //String key= EncryptionUtil.createAESKEY();
    //System.out.println(key);
    String msg="admin";
    //2、加密
    String mw=EncryptionUtil.AESEnc(SystemConfig.PASSKEY,msg);
    System.out.println("密文："+mw);
    //3、解密
    System.out.println("明文："+ EncryptionUtil.AESDec(SystemConfig.PASSKEY,mw));
}
}
