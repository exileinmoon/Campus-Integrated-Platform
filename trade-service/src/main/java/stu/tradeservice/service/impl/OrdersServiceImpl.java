package stu.tradeservice.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.tradeservice.DTO.OrderDTO;
import stu.tradeservice.DTO.ProductDetailsDTO;
import stu.tradeservice.entity.Orders;
import stu.tradeservice.mapper.OrdersMapper;
import stu.tradeservice.service.OrdersService;
import stu.tradeservice.service.ProductDetailService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private ProductDetailService productDetailService;

    @Override
    public void createOrders(Orders orders) {
        ordersMapper.createOrders(orders);
    }

    @Override
    public OrderDTO getOrdersById(Integer id) {
        Orders order = ordersMapper.getOrdersById(id);
        // 获取商品详情
        Long productId = Long.valueOf(order.getProduct_id());
        ProductDetailsDTO productDetails = productDetailService.getProductDetails(productId);

        // 返回订单和商品详情
        return new OrderDTO(productDetails, order); }

    @Override
    public List<OrderDTO> getOrdersByUserId(Integer userId) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(Orders order : ordersMapper.getOrdersByUserId(userId)) {
          OrderDTO orderDTO= new OrderDTO(productDetailService.getProductDetails(Long.valueOf(order.getProduct_id())), order);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

    @Override
    public void updateOrdersStatus(Integer id, String status) {
        ordersMapper.updateOrdersStatus(id, status);
    }

    @Override
    public void deleteOrders(Integer id) {
        ordersMapper.deleteOrders(id);
    }

}