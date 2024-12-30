package stu.tradeservice.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class ProductSearchService {
    @Autowired
    private RestHighLevelClient client;

    public List<Map<String, Object>> searchProducts(String query, Double minPrice, Double maxPrice, String category) throws IOException {
        SearchRequest searchRequest = new SearchRequest("products"); // 假设索引名称为 "products"

        // 构建 Bool 查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (query != null && !query.isEmpty()) {
            boolQuery.must(QueryBuilders.matchQuery("name", query)); // 根据商品名称搜索
        }
        if (minPrice != null && maxPrice != null) {
            boolQuery.filter(QueryBuilders.rangeQuery("price").from(minPrice).to(maxPrice));
        }
        if (category != null && !category.isEmpty()) {
            boolQuery.filter(QueryBuilders.termQuery("category", category));
        }

        // 创建查询请求
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(boolQuery);
        sourceBuilder.size(10); // 设置返回结果数量

        // 设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        sourceBuilder.highlighter(highlightBuilder);

        searchRequest.source(sourceBuilder);

        // 执行查询并处理结果
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        return Arrays.stream(response.getHits().getHits())
                .map(hit -> hit.getSourceAsMap())
                .collect(Collectors.toList());
    }
}
