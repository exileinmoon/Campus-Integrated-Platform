package stu.tradeservice.service;

import stu.tradeservice.DTO.ProductDetailsDTO;
import stu.tradeservice.client.UserClient;
import stu.tradeservice.entity.Comments;
import stu.tradeservice.entity.Products;
import stu.tradeservice.entity.Sales;
import stu.tradeservice.entity.Users;
import stu.tradeservice.mapper.CommentsMapper;
import stu.tradeservice.mapper.ProductsMapper;
import stu.tradeservice.mapper.SalesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductDetailService {
    private static final Logger logger = LoggerFactory.getLogger(ProductDetailService.class);

    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private SalesMapper salesMapper;
    @Autowired
    private ProductsMapper productsMapper;
    @Autowired
    private UserClient userClient;

    public ProductDetailsDTO getProductDetails(Long id) {
        logger.info("Fetching product details for product ID: {}", id);

        // 获取商品信息
        Products product = productsMapper.selectById(id);
        if (product == null) {
            return null;
        }

        // 获取销售信息
        Sales sales = salesMapper.selectSaleByProductId(id);

        // 获取评论列表
        List<Comments> commentsList = commentsMapper.selectByProductId(id);

        // 获取卖家信息
        Long sellerId = Long.valueOf(sales.getUser_id());
        Users seller = userClient.getUserById(sellerId);
        System.out.println(seller);

        // 封装成 ProductDetailsDTO
        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        productDetailsDTO.setId(Long.valueOf(product.getId()));
        productDetailsDTO.setName(product.getName());
        productDetailsDTO.setPrice(product.getPrice());
        productDetailsDTO.setTags(Arrays.asList(product.getTags().split(","))); // 处理多个标签
        productDetailsDTO.setAddress(product.getAddress());
        productDetailsDTO.setViews(product.getViews());
        productDetailsDTO.setImages(Arrays.asList(product.getImages().split(","))); // 处理多个图片
        productDetailsDTO.setDescription(product.getDescription());
        productDetailsDTO.setComments(commentsList);

        // 设置卖家信息
        productDetailsDTO.setSeller(new ProductDetailsDTO.SellerDTO(seller.getUsername(), seller.getAvatar(), seller.getPhone()));

        return productDetailsDTO;
    }
}
