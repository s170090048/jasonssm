package com.jason.jason_ssm.dao;

import com.jason.jason_ssm.domain.Traveller;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ITraverlerDao {

    @Select("select * from traveller where ID in (select TRAVELLERID from order_traveller where ORDERID=#{ordersId})")
    Traveller getTravellerByOrdersId(@Param("ordersId") String ordersId) throws Exception;
}
