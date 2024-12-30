package stu.loginservice.config;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    // 创建 GridFSBucket Bean，用于文件存储和访问
    @Bean
    public GridFSBucket gridFSBucket() {
        return GridFSBuckets.create(mongoTemplate.getDb());  // 获取数据库
    }
}