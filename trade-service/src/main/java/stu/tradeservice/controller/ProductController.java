package stu.tradeservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import stu.tradeservice.DTO.ProductDetailsDTO;
import stu.tradeservice.entity.Comments;
import stu.tradeservice.entity.Products;
import stu.tradeservice.service.CommentsService;
import stu.tradeservice.service.ProductDetailService;
import stu.tradeservice.service.ProductSearchService;
import stu.tradeservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;







@RestController
@RequestMapping("/api/trade/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;
    @Autowired
    private ProductDetailService productDetailService;

    // 获取商品列表，支持分页
    @GetMapping
    public Map<String, Object> getProducts(@RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        IPage<Products> productPage = productsService.getProducts(page, size);
        Map<String, Object> result = new HashMap<>();
        result.put("list", productPage.getRecords());
        result.put("total", productPage.getTotal());
        result.put("current", productPage.getCurrent());
        result.put("pages", productPage.getPages());
        return result;
    }
    @Autowired
    private ProductSearchService productSearchService;

    @PostMapping("/search")
    public List<Map<String, Object>> searchProducts(@RequestBody Map<String, Object> params) throws IOException {
        System.out.println("params: " + params);
        String query = (String) params.get("query");
        Double minPrice = params.get("minPrice") != null ? ((Number) params.get("minPrice")).doubleValue() : null;
        Double maxPrice = params.get("maxPrice") != null ? ((Number) params.get("maxPrice")).doubleValue() : null;

        String category = (String) params.get("category");

        return productSearchService.searchProducts(query, minPrice, maxPrice, category);
    }
    @GetMapping("/myproducts/{id}")
    public List<Products> getMyProducts(@PathVariable Long id) {
        return productsService.getMyProducts(id);
    }

    // 根据ID获取商品详情
    @GetMapping("/{id}")
    public ProductDetailsDTO getProductById(@PathVariable Long id) {
        return productDetailService.getProductDetails(id);
    }
    // 创建新商品
    @PostMapping
    public Map<String, Object> createProduct(@RequestBody Products product) {
        boolean success = productsService.createProduct(product);
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        return result;
    }

    // 更新商品
    @PutMapping("/{id}")
    public Map<String, Object> updateProduct(@PathVariable Long id, @RequestBody Products product) {
        product.setId(Math.toIntExact(id));  // 确保设置正确的 ID
        boolean success = productsService.updateProduct(product);
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        return result;
    }

    // 删除商品
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteProduct(@PathVariable Long id) {
        boolean success = productsService.deleteProduct(id);
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        return result;
    }
    @Autowired
    private CommentsService commentsService;
    @PostMapping("/addcomments")
    public void addComments( @RequestBody Comments comments) {
        System.out.println(comments);
        commentsService.addComments(comments);
    }
}
