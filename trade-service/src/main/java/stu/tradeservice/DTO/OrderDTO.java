package stu.tradeservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import stu.tradeservice.entity.Orders;
@Getter
@Setter
@Data
public class OrderDTO {
    private Orders order;
    private ProductDetailsDTO productDetails;

    public OrderDTO(ProductDetailsDTO productDetails, Orders order) {
        this.productDetails = productDetails;
        this.order = order;
    }
}
