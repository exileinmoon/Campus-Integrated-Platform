package stu.tradeservice.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {
    @Bean
    public RestHighLevelClient client() {
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("localhost", 9200, "http")); // 配置 Elasticsearch 地址
        return new RestHighLevelClient(builder);
    }
}
