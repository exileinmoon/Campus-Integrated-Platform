package stu.loginservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.loginservice.entity.Roles;
import stu.loginservice.mapper.RolesMapper;

import stu.loginservice.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public void addRoles(Roles role) {
        rolesMapper.insert(role);
    }

    @Override
    public Roles getRolesById(int id) {
        return rolesMapper.findById(id);
    }

    @Override
    public void deleteRoles(int id) {
        rolesMapper.delete(id);
    }
}
