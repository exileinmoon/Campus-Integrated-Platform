package stu.tradeservice.client;

import stu.tradeservice.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loginservice")  // Nacos中注册的user服务名称
public interface UserClient {

    @GetMapping("/api/auth/users/{id}")
    Users getUserById(@PathVariable("id") long id);
}
