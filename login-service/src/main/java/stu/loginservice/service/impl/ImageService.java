package stu.loginservice.service.impl;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import stu.loginservice.entity.Image;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    // 上传图片并返回 URL
    public String uploadImage(MultipartFile file) throws IOException {
        // 获取文件输入流
        InputStream inputStream = file.getInputStream();

        // 创建上传选项，设置文件的类型等
        GridFSUploadOptions options = new GridFSUploadOptions()
                .chunkSizeBytes(1024)  // 每块的大小，可根据需求调整
                .metadata(new Document("contentType", file.getContentType()));

        // 上传文件到 GridFS
        ObjectId fileId = gridFSBucket.uploadFromStream(file.getOriginalFilename(), inputStream, options);

        // 创建图片 URL
        String fileUrl = "http://localhost:8080/images/" + fileId.toString();

        // 存储图片 URL 到 MongoDB
        Image image = new Image();
        image.setImageUrl(fileUrl);
        image.setDescription("Uploaded image");

        mongoTemplate.save(image);  // 将图片 URL 存储到数据库

        return fileUrl;  // 返回图片的 URL
    }
}