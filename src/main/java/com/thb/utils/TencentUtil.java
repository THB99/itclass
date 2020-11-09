package com.thb.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;

public class TencentUtil {
    public static COSClient TencentStart(){
// 指定要上传到的存储桶
        COSCredentials cred = new BasicCOSCredentials("", "");
// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
        ClientConfig clientConfig = new ClientConfig(new Region("ap-nanjing"));
// 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        return cosClient;
    }

}
