package com.jason.jason_ssm.service;

import com.jason.jason_ssm.dao.IUserDao;
import com.jason.jason_ssm.domain.UserInfo;
import com.jason.jason_ssm.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IUserServiceImpl  implements  IUserService {
    @Autowired
    private IUserDao userDao;
    @Qualifier("bCryptPasswordEncoder")
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;//注入加密类
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        //或者用工具类
       // userInfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public void login(UserInfo userInfo) throws Exception {
        UserInfo user = userDao.findUserByName(userInfo.getUsername());

    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) throws Exception {
        if (ids != null) {
            for (String id : ids) {
                userDao.addRoleToUser(userId, id);
            }

        }
    }
}
