package com.jason.jason_ssm.controller;

import com.jason.jason_ssm.domain.Role;
import com.jason.jason_ssm.domain.UserInfo;
import com.jason.jason_ssm.service.IRoleService;
import com.jason.jason_ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("findAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;

    }
    @PreAuthorize("authentication.principal.username='jason'")
    @RequestMapping("save")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

   /* @RequestMapping("/login")
    public String login(UserInfo userInfo) throws Exception {
        userService.login(userInfo);

        return "redirect:main";

    }
*/
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("userInfo", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }


    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        //先查user
        UserInfo user = userService.findById(id);
        //先查根据id查未拥有的角色
        List<Role> roleList = roleService.findOtherRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }


    @PostMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name ="userId" ,required = true) String userId, @RequestParam(name ="ids" ,required = true)String[] ids) throws Exception {
        userService.addRoleToUser(userId, ids);
        return  "redirect:findAll.do";
    }
}
