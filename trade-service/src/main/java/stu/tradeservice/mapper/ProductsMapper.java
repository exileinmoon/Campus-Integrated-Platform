package stu.tradeservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import stu.tradeservice.entity.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 李
 * @description 针对表【products】的数据库操作Mapper
 * @createDate 2024-10-02 22:15:59
 * @Entity entity.stu.tradeservice.Products
 */
@Mapper
public interface ProductsMapper extends BaseMapper<Products> {

    // 增加产品
    @Insert("INSERT INTO products(name, price, images, description, created_at, updated_at) " +
            "VALUES(#{name}, #{price}, #{image}, #{description}, #{created_at}, #{updated_at})")
    int insertProduct(Products product);
    @Select("SELECT * FROM products")
    List<Products> selectList();
    @Select("SELECT * FROM products WHERE id = #{id}")
    Products selectById();
    // 查询所有产品
    @Select("SELECT * FROM products")
    List<Products> selectAllProducts();

    // 根据 ID 查询产品
    @Select("SELECT * FROM products WHERE id = #{id}")
    Products selectProductById(Long id);

    // 更新产品
    @Update("UPDATE products SET name = #{name}, price = #{price}, images = #{image}, " +
            "description = #{description}, updated_at = #{updated_at} WHERE id = #{id}")
    int updateProduct(Products product);

    // 根据 ID 删除产品
    @Delete("DELETE FROM products WHERE id = #{id}")
    int deleteProduct(Long id);
}
