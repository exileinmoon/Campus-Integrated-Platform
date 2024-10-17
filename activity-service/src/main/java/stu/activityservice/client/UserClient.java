package stu.activityservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import stu.activityservice.entity.Users;
import stu.activityservice.entity.Users1;


@FeignClient(name = "loginservice")  // Nacos中注册的user服务名称
public interface UserClient {

    @GetMapping("/api/auth/users/{id}")
    Users getUserById(@PathVariable("id") long id);
}
