package com.jason.jason_ssm.service;


import com.jason.jason_ssm.domain.Product;

import java.util.List;


public interface IProductService {
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;

    Product getProductById(String id) throws Exception;

    void deleteProductByIds(String[] ids) throws Exception;

    void deleteProductById(String id) throws Exception;
}
