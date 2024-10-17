package stu.loginservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.loginservice.mapper.RolePermissionsMapper;
import stu.loginservice.service.RolePermissionsService;

@Service
public class RolePermissionsServiceImpl implements RolePermissionsService {

    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;

    @Override
    public void assignPermissionToRole(int roleId, int permissionId) {
        rolePermissionsMapper.insert(roleId, permissionId);
    }

    @Override
    public void removePermissionFromRole(int roleId, int permissionId) {
        rolePermissionsMapper.delete(roleId, permissionId);
    }
}
