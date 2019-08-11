package com.jason.jason_ssm.service;

import com.github.pagehelper.PageHelper;
import com.jason.jason_ssm.dao.IOrderDao;
import com.jason.jason_ssm.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public Orders findOrderById(String id) {
        Orders orders = orderDao.findOrderById(id);
        return  orders;
    }

    @Override
    public List<Orders> findAll(int pagenum, int pageSize) {

        PageHelper.startPage(pagenum, pageSize);
        List<Orders> Orders_list=orderDao.findAll();

        return Orders_list;
    }
}
