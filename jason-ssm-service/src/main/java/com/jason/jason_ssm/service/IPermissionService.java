package com.jason.jason_ssm.service;

import com.jason.jason_ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
     List<Permission> findAll() throws Exception;

    void save(Permission p);

    List<Permission> findOtherPermission(String roleid);
}
