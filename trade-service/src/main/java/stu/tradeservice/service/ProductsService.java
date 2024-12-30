package stu.tradeservice.service;

import stu.tradeservice.entity.Products;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;


/**
 * @author 李
 * @description 针对表【products】的数据库操作Service
 * @createDate 2024-10-02 22:15:59
 */
public interface ProductsService {
    List<Products> getAllProducts();

    IPage<Products> getProducts(int page, int size);

    boolean createProduct(Products product);

    Products getProductById(Long id);

    boolean updateProduct(Products product);

    boolean deleteProduct(Long id);

    boolean addComments(Long productId, Long userId, String text, Integer stars);

    List<Products> getMyProducts(Long id);
}