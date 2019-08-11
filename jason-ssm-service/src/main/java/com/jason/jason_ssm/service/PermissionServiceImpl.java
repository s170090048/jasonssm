package com.jason.jason_ssm.service;

import com.jason.jason_ssm.dao.IPermissionDao;
import com.jason.jason_ssm.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission p) {
        permissionDao.save(p);
    }

    @Override
    public List<Permission> findOtherPermission(String roleid) {
        return permissionDao.findOtherPermission( roleid) ;
    }
}
