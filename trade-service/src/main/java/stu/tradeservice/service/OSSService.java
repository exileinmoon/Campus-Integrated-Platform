package stu.tradeservice.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OSSService {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    public String uploadFile(MultipartFile file) {
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 获取上传的文件输入流
            InputStream inputStream = file.getInputStream();

            // 使用UUID生成文件名，防止文件重名
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            // 上传文件到OSS
            ossClient.putObject(new PutObjectRequest(bucketName, fileName, inputStream));

            // 拼接文件的URL地址
            String fileUrl = "https://" + bucketName + "." + endpoint + "/" + fileName;

            // 返回文件的URL地址
            return fileUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭OSSClient
            ossClient.shutdown();
        }
    }
}
