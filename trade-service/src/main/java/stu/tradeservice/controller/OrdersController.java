package stu.tradeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.tradeservice.DTO.OrderDTO;
import stu.tradeservice.entity.Orders;
import stu.tradeservice.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/api/trade/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @GetMapping("/order/{Id}")
    public OrderDTO getOrderByUserId(@PathVariable Integer Id) {
        return ordersService.getOrdersById(Id);
    }

    @PostMapping
    public void createOrders(@RequestBody Orders orders) {
        ordersService.createOrders(orders);
    }

    @GetMapping("/{userId}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable Integer userId) {
        return ordersService.getOrdersByUserId(userId);
    }

    @PutMapping("/{id}/status")
    public void updateOrdersStatus(@PathVariable Integer id, @RequestParam String status) {
        ordersService.updateOrdersStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteOrders(@PathVariable Integer id) {
        ordersService.deleteOrders(id);
    }
}