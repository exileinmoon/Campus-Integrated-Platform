package stu.loginservice.service;


import stu.loginservice.entity.Roles;

public interface RolesService {
    void addRoles(Roles role);
    Roles getRolesById(int id);
    void deleteRoles(int id);
}
