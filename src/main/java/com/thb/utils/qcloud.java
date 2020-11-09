package com.thb.utils;

import ch.qos.logback.core.pattern.FormatInfo;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.region.Region;

import java.util.List;

public class qcloud {
    public static void main(String[] args){
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDby3rOfMXCj13vZTQancHerpY0BeQRNZB";
        String secretKey = "UkkUP5Wif02nHXWFgx3uhRvFJ6ey4mUy";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("itclass-1300650300.cos.ap-nanjing.myqcloud.com");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        List<Bucket> buckets = cosClient.listBuckets();
        for (Bucket bucketElement : buckets) {
            String bucketName = bucketElement.getName();
            String bucketLocation = bucketElement.getLocation();
            System.out.println("bucketName:"+bucketName+"   bucketLocation:"+bucketLocation);
        }

    }

}
