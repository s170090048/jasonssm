package com.jason.jason_ssm.service;

import com.jason.jason_ssm.domain.Role;

import java.util.List;

public interface IRoleService {
   List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;


    List<Role> findOtherRole(String id) throws Exception;

    Role findById(String roleid);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
