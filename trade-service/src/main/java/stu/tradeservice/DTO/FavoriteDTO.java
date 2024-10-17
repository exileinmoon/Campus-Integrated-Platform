package stu.tradeservice.DTO;


import java.math.BigDecimal;

public class FavoriteDTO {

    private Long id; // 可选，通常在更新时使用

    private String productId; // 商品 ID

    private String productName; // 商品名称

    private BigDecimal price; // 商品价格

    private String image; // 商品图片 URL

    // Getters 和 Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
