package stu.tradeservice.service.impl;

import stu.tradeservice.entity.Sales;
import stu.tradeservice.mapper.SalesMapper;
import stu.tradeservice.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesMapper salesMapper;

    @Override
    public int insertSale(Sales sale) {
        return salesMapper.insertSale(sale);
    }

    @Override
    public List<Sales> selectAllSales() {
        return salesMapper.selectAllSales();
    }

    @Override
    public Sales selectSaleById(Long id) {
        return salesMapper.selectSaleById(id);
    }

    @Override
    public int updateSale(Sales sale) {
        return salesMapper.updateSale(sale);
    }

    @Override
    public int deleteSale(Long id) {
        return salesMapper.deleteSale(id);
    }
}