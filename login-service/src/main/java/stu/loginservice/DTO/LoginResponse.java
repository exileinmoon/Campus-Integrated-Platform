package stu.loginservice.DTO;

import lombok.Getter;
import stu.loginservice.entity.Users;
@Getter
public class LoginResponse {
    private final int id;
    private final String token;
    private final String username;
    private final String role;
    private final String phone;
    private final String email;
    private final int status;
    private final String avatar;
    // 可以根据需要添加更多字段，如用户ID、邮箱等

    public LoginResponse(String token, Users users) {
        this.id = users.getId();
        this.token = token;
        this.username = users.getUsername();
        this.phone = users.getPhone();
        this.email = users.getEmail();
        this.status = users.getStatus();
        this.role = users.getRole();
        this.avatar = users.getAvatar();
    }
}
    // Getters 和 Setters
