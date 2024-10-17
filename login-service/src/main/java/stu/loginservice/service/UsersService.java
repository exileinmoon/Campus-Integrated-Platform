package stu.loginservice.service;

import stu.loginservice.entity.Users;


public interface UsersService {
    void register(Users user);
    Users getUserById(int id);
    Users getUserByUsername(String username);
    void update(Users user);
    void deleteUser(int id);
}
