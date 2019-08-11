package com.jason.jason_ssm.service;

import com.jason.jason_ssm.dao.ISysLogDao;
import com.jason.jason_ssm.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLogServiceImpl implements ISysLogService {
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }
}
