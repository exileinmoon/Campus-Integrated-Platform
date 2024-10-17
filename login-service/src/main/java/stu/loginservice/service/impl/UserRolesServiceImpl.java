package stu.loginservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.loginservice.mapper.UserRolesMapper;
import stu.loginservice.service.UserRolesService;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Override
    public void assignRoleToUser(int userId, int roleId) {
        userRolesMapper.insert(userId, roleId);
    }

    @Override
    public void removeRoleFromUser(int userId, int roleId) {
        userRolesMapper.delete(userId, roleId);
    }
}
