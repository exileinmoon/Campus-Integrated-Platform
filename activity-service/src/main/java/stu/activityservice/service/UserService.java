package stu.activityservice.service;

import stu.activityservice.entity.Users1;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 李
* @description 针对表【users】的数据库操作Service
* @createDate 2024-10-17 19:14:35
*/
import java.util.List;

public interface UserService {
    void registerUser(Users1 user);
    Users1 getUserById(int id);
    Users1 getUserByUsername(String username);
    List<Users1> getAllUsers();
    void updateUser(int id, String phoneNumber, String role);
    void deleteUser(int id);
}
