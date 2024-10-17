package stu.loginservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.loginservice.entity.Users;


import stu.loginservice.mapper.UsersMapper;
import stu.loginservice.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper userMapper;

    @Override
    public void register(Users user) {
        userMapper.insert(user);
    }

    @Override
    public Users getUserById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public Users getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void update(Users user) {
        userMapper.update(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.delete(id);
    }
}
