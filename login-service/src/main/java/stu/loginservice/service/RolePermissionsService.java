package stu.loginservice.service;

public interface RolePermissionsService {
    void assignPermissionToRole(int roleId, int permissionId);
    void removePermissionFromRole(int roleId, int permissionId);
}
