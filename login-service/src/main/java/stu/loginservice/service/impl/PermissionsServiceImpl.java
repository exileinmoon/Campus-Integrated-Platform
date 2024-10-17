package stu.loginservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.loginservice.mapper.PermissionsMapper;
import stu.loginservice.service.PermissionsService;

import java.security.Permission;

@Service
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public void addPermission(Permission permission) {
        permissionsMapper.insert(permission);
    }

    @Override
    public Permission getPermissionById(int id) {
        return permissionsMapper.findById(id);
    }

    @Override
    public void deletePermission(int id) {
        permissionsMapper.delete(id);
    }
}
