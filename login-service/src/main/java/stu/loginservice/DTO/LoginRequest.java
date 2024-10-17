package stu.loginservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

    // Getter 和 Setter
    private String username;
    private String password;
    // 新增方法
    // 新增方法
    private String captcha; // 新增字段

    // 无参构造函数
    public LoginRequest() {}

    // 带参构造函数
    public LoginRequest(String username, String password, String captcha) {
        this.username = username;
        this.password = password;
        this.captcha = captcha; // 新增参数
    }

}
