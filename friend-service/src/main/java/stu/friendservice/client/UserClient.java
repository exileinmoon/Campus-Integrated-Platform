package stu.friendservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import stu.friendservice.entity.Users;

@FeignClient(name = "loginservice")  // Nacos中注册的user服务名称
public interface UserClient {

    @GetMapping("/api/auth/users/{id}")
    Users getUserById(@PathVariable("id") long id);
}