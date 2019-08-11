package com.jason.jason_ssm.controller;

import com.jason.jason_ssm.domain.Product;
import com.jason.jason_ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

  /*  @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
    }
*/

    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")  //省略前缀ROLE_
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("productList", products);
        modelAndView.setViewName("product_list");
        return modelAndView;
    }


    @PostMapping("/save")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/getProductById")
    public ModelAndView getProductById(@RequestParam(name = "id",required = true) String id) throws Exception {
        Product product=productService.getProductById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("product",product);
        modelAndView.setViewName("product_detail");
        return modelAndView;
    }
    @RequestMapping("/deleteProductByIds")
    public String deleteProductByIds(String[] ids) throws Exception {
        productService.deleteProductByIds(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteProductById")
    public String deleteProductByIds(String id) throws Exception {
        productService.deleteProductById(id);
        return "redirect:findAll.do";
    }


}
