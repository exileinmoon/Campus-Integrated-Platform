package stu.tradeservice.service;

import stu.tradeservice.entity.Sales;

import java.util.List;

public interface SalesService {
    int insertSale(Sales sale);
    List<Sales> selectAllSales();
    Sales selectSaleById(Long id);
    int updateSale(Sales sale);
    int deleteSale(Long id);
}