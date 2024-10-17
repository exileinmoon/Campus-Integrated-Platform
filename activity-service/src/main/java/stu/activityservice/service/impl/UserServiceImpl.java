package stu.activityservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import stu.activityservice.entity.Users1;
import stu.activityservice.mapper.UserMapper;
import stu.activityservice.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author 李
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-10-17 19:14:35
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerUser(Users1 user) {
        userMapper.insertUser(user);
    }

    @Override
    public Users1 getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Users1 getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<Users1> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void updateUser(int id, String phoneNumber, String role) {
        userMapper.updateUser(id, phoneNumber, role);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
