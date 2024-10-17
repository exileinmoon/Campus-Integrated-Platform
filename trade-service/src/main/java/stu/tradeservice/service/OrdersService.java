package stu.tradeservice.service;

import stu.tradeservice.DTO.OrderDTO;
import stu.tradeservice.entity.Orders;

import java.util.List;

/**
* @author 李
* @description 针对表【orders】的数据库操作Service
* @createDate 2024-10-12 15:01:32
*/
public interface OrdersService {
    void createOrders(Orders orders);

    OrderDTO getOrdersById(Integer id);

    List<OrderDTO> getOrdersByUserId(Integer userId);

    void updateOrdersStatus(Integer id, String status);

    void deleteOrders(Integer id);
}
