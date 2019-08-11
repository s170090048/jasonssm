package com.jason.jason_ssm.service;

import com.github.pagehelper.PageInfo;
import com.jason.jason_ssm.domain.Orders;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public interface IOrdersService {
    Orders findOrderById(String id);

    List<Orders> findAll(int pagenum, int pageSizenum);
}
