package stu.tradeservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Setter

public class ProductDetailsDTO {

    // 商品的基本信息
    private Long id;
    @Getter
    private String name;
    private BigDecimal price;



    // 卖家信息的嵌套类
    @Getter
    @Setter
    public static class SellerDTO {
        private Integer id;
        // Getters and Setters
        private String name;
        private String avatar; // 卖家头像URL
        private String phone; // 卖家的联系方式
        public SellerDTO(String username, String avatar, String phone, Integer id) {
            this.id = id;
            this.name = username;
            this.avatar = avatar;
            this.phone = phone;
        }


    }

    // 卖家信息
    private SellerDTO seller;


    // 商品的其他信息
    private boolean isAvailable=true; // 商品是否可用
    private List<String> tags; // 标签列表
    private String address;    // 商品地址
    private int views;         // 浏览量
    private List<String> images; // 商品图片URL列表
    private String description;  // 商品简介

    // 商品的评论
    public static class CommentDTO {
        private Long id;
        private String user;

        private String text;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    private List<CommentsDTO> comments; // 评论列表

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = true;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommentsDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentsDTO> comments) {
        this.comments = comments;
    }
}
