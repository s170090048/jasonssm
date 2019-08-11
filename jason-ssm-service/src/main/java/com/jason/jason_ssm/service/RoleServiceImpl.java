package com.jason.jason_ssm.service;

import com.jason.jason_ssm.dao.IRoleDao;
import com.jason.jason_ssm.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        List<Role> roles = roleDao.findAll();
        return roles;
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRole(String id) throws Exception {
        return roleDao.findOtherRole(id);
    }

    @Override
    public Role findById(String roleid) {
        return roleDao.findById(roleid);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole( roleId, permissionId);
        }

    }
}
