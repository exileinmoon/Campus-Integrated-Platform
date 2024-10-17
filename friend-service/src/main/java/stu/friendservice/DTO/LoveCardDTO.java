package stu.friendservice.DTO;

public class LoveCardDTO {
    private Long userId;        // 用户ID
    private String avatar;      // 用户头像URL
    private String photoUrl;    // 照片URL
    private String declaration;  // 表白内容
    private String username;     // 用户名
    private int views;          // 浏览量
    private int flowers;        // 鲜花数
    private int likes;          // 点赞数

    // 构造函数
    public LoveCardDTO(Integer userId, String avatar, String photoUrl, String declaration, String username, int views, int flowers, int likes) {
        this.userId = Long.valueOf(userId);
        this.avatar = avatar;
        this.photoUrl = photoUrl;
        this.declaration = declaration;
        this.username = username;
        this.views = views;
        this.flowers = flowers;
        this.likes = likes;
    }

    // Getter 和 Setter 方法
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getFlowers() {
        return flowers;
    }

    public void setFlowers(int flowers) {
        this.flowers = flowers;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
