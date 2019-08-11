package com.jason.jason_ssm.service;

import com.jason.jason_ssm.domain.UserInfo;

import java.util.List;

public interface IUserService {
    List<UserInfo> findAll() throws  Exception;

    void save(UserInfo userInfo) throws Exception;

    void login(UserInfo userInfo) throws Exception;

    UserInfo findById(String id)  throws Exception;

    void addRoleToUser(String userId, String[] ids) throws Exception;
}
