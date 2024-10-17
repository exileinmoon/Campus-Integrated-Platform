package stu.loginservice.service;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import stu.loginservice.entity.Users;

import java.util.Collection;

@Getter
public class CustomUserDetails implements UserDetails {

    // 获取用户实体
    private final Users user;

    public CustomUserDetails(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 这里可以返回用户的角色等权限信息
        return null; // 根据需要实现角色或权限
    }

    @Override
    public String getPassword() {
        return user.getPassword_hash(); // 返回用户密码
    }

    @Override
    public String getUsername() {
        return user.getUsername(); // 返回用户名
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 账号是否未过期
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 账号是否未锁定
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 密码是否未过期
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() == 1; // 根据用户状态返回是否启用
    }

}
