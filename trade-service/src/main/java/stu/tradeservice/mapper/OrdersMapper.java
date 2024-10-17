package stu.tradeservice.mapper;


import org.apache.ibatis.annotations.*;
import stu.tradeservice.entity.Orders;

import java.util.List;

@Mapper
public interface OrdersMapper {

    @Insert("INSERT INTO orders (user_id, product_id, status, recipient_name, recipient_address, " +
            "recipient_phone,  payment_method) VALUES (#{userId}, #{productId}, #{status}, " +
            "#{recipientName}, #{recipientAddress}, #{recipientPhone},  #{paymentMethod})")
    void createOrders(Orders orders);

    @Select("SELECT * FROM orders WHERE id = #{id}")
    Orders getOrdersById(@Param("id") Integer id);

    @Select("SELECT * FROM orders WHERE user_id = #{userId}")
    List<Orders> getOrdersByUserId(@Param("userId") Integer userId);

    @Update("UPDATE orders SET status = #{status}, updated_at = CURRENT_TIMESTAMP WHERE id = #{id}")
    void updateOrdersStatus(@Param("id") Integer id, @Param("status") String status);

    @Delete("DELETE FROM orders WHERE id = #{id}")
    void deleteOrders(@Param("id") Integer id);
}
