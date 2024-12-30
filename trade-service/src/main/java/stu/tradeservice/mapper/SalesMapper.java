package stu.tradeservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import stu.tradeservice.entity.Products;
import stu.tradeservice.entity.Sales;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SalesMapper extends BaseMapper<Sales> {

    // 增加销售记录
    @Insert("INSERT INTO sales(product_id, user_id, sold_at) " +
            "VALUES(#{productId}, #{userId}, #{soldAt})")
    int insertSale(Sales sale);

    // 查询所有销售记录
    @Select("SELECT * FROM sales")
    List<Sales> selectAllSales();

    // 根据 ID 查询销售记录
    @Select("SELECT * FROM sales WHERE id = #{id}")
    Sales selectSaleById(Long id);

    // 更新销售记录
    @Update("UPDATE sales SET product_id = #{productId}, user_id = #{userId}, sold_at = #{soldAt} WHERE id = #{id}")
    int updateSale(Sales sale);

    // 根据 ID 删除销售记录
    @Delete("DELETE FROM sales WHERE id = #{id}")
    int deleteSale(Long id);
    @Select("SELECT * FROM sales WHERE product_id = #{id}")
    Sales selectSaleByProductId(Long id);
    @Select("SELECT * FROM sales join products WHERE  sales.product_id = products.id and sales.user_id = #{id}")
    List<Products> selectProductsByUserId(Long id);
}