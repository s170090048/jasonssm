package com.jason.jason_ssm.service;

import com.jason.jason_ssm.dao.IProductDao;
import com.jason.jason_ssm.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl  implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {

        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public Product getProductById(String id) throws Exception {
        return productDao.getProductById( id);
    }

    @Override
    public void deleteProductByIds(String[] ids) throws Exception  {
        for (String id : ids) {
            productDao.deleteProductById(id);
        }
    }

    @Override
    public void deleteProductById(String id) throws Exception {
        productDao.deleteProductById(id);
    }
}
