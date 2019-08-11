package com.jason.jason_ssm.controller;


import com.github.pagehelper.PageInfo;
import com.jason.jason_ssm.domain.Orders;
import com.jason.jason_ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIN")  //这个注解 需要加一个前缀ROLE_ 不能省略前缀
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "pageSize",defaultValue ="3")Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView();
        List<Orders> orders_list = ordersService.findAll(page, pageSize);
        PageInfo pageInfo=new PageInfo(orders_list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;

    }

    @RequestMapping("/findById")
    public ModelAndView findOrderById(@RequestParam(name = "id", required = true) String id) {

        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findOrderById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders_show");
        return modelAndView;

    }
}
