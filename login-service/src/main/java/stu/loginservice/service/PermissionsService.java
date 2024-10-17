package stu.loginservice.service;


import java.security.Permission;

public interface PermissionsService {
    void addPermission(Permission permission);
    Permission getPermissionById(int id);
    void deletePermission(int id);
}
