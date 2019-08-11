package com.jason.jason_ssm.service;

import com.jason.jason_ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    List<SysLog> findAll() throws Exception;
    void save(SysLog log) throws Exception;
}
