package com.jason.jason_ssm.dao;

import com.jason.jason_ssm.domain.Product;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface IProductDao {
    @Select("select * from product")

    List<Product> findAll() throws Exception;

    @Insert("insert into  product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id=#{id}")
    Product getProductById(@Param("id") String id) throws Exception;

    @Delete("delete from product where id=#{id}")
    void deleteProductById(@Param("id") String id);
}
