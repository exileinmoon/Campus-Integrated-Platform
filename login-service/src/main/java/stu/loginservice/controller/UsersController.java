package stu.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.loginservice.entity.Users;
import stu.loginservice.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/auth/users")
public class UsersController {

    private final UsersService UsersService;

    @Autowired
    public UsersController(UsersService UsersService) {
        this.UsersService = UsersService;
    }


    // 根据 ID 获取单个用户
    @GetMapping("/{id}")
    public Users getUsersById(@PathVariable("id") int id) {
        return UsersService.getUserById(id);
    }



    // 删除用户
    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable("id") int id) {
        UsersService.deleteUser(id);
    }
}
