package stu.tradeservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import stu.tradeservice.entity.Products;
import stu.tradeservice.entity.Sales;
import stu.tradeservice.mapper.SalesMapper;
import stu.tradeservice.service.ProductsService;
import stu.tradeservice.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 针对表【products】的数据库操作Service实现
 * @createDate 2024-10-02 22:15:59
 */
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsMapper productsMapper;
    @Autowired
    private SalesMapper sellMapper;

    @Override
    public boolean createProduct(Products product) {
        return productsMapper.insertProduct(product) > 0;
    }

    @Override
    public Products getProductById(Long id) {
        return productsMapper.selectProductById(id);
    }

    @Override
    public boolean updateProduct(Products product) {
        return productsMapper.updateProduct(product) > 0;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productsMapper.deleteProduct(id) > 0;
    }

    @Override
    public boolean addComments(Long productId, Long userId, String text, Integer stars) {
        return false;
    }

    @Override
    public List<Products> getMyProducts(Long id) {
         return  sellMapper.selectProductsByUserId(id);
    }

    @Override
    public List<Products> getAllProducts() {
        return productsMapper.selectAllProducts();
    }


    @Override
    public IPage<Products> getProducts(int page, int size) {
    // 创建分页对象
    IPage<Products> productPage = new Page<>(page, size);
    // 使用 MyBatis-Plus 提供的分页查询方法
        return productsMapper.selectPage(productPage, null); // null 表示不添加任何查询条件
        }
}