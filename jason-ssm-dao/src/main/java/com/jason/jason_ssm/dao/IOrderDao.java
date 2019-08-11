package com.jason.jason_ssm.dao;

import com.jason.jason_ssm.domain.Member;
import com.jason.jason_ssm.domain.Orders;
import com.jason.jason_ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {

    @Select("select * from orders where ID=#{order_id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class ,one = @One(select ="com.jason.jason_ssm.dao.IProductDao.getProductById")),
            @Result(column = "memberId",property = "member",javaType = Member.class, one = @One(select ="com.jason.jason_ssm.dao.IMemberDao.getMemberById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select="com.jason.jason_ssm.dao.ITraverlerDao.getTravellerByOrdersId"))
    })
    Orders findOrderById(@Param("order_id") String id);

    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class ,one = @One(select ="com.jason.jason_ssm.dao.IProductDao.getProductById")),
            @Result(column = "memberId",property = "member",javaType = Member.class, one = @One(select ="com.jason.jason_ssm.dao.IMemberDao.getMemberById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select="com.jason.jason_ssm.dao.ITraverlerDao.getTravellerByOrdersId"))
    })
    List<Orders> findAll();
}
