package com.xtkj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xtkj.pojo.User;
import com.xtkj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Configuration
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {//查询所有用户
        return iUserService.list();
    }

    @RequestMapping("delUser")
    public boolean delUser(Integer id) {//删除用户
        return iUserService.removeById(id);
    }

    @RequestMapping("/updUser")
    public boolean updUser(User user) {//修改用户
        return iUserService.updateById(user);
    }

    @RequestMapping("/addUser")
    public boolean addUser(User user) {//添加用户
        return iUserService.save(user);
    }

    @RequestMapping("/pageUser")
    public IPage<User> pageUser(Integer current,Integer limit){//分页查询
        IPage page = new Page(current,limit);
        return iUserService.page(page);
    }

    @RequestMapping("recordUser")
    public boolean recordUser(Integer id){//删除用户记录历史表
       return iUserService.delUser(id);
    }

    @RequestMapping("testVersion")
    public boolean testVersion(Integer id){//添加乐观锁
        User user = iUserService.getById(id);
        user.setLoginId("888888");
        return iUserService.updateById(user);
    }
}
