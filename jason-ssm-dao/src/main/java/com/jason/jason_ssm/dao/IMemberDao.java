package com.jason.jason_ssm.dao;

import com.jason.jason_ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    Member getMemberById(String id);
}
