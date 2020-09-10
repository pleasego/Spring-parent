package com.xtkj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtkj.pojo.User;

public interface IUserService extends IService<User> {

     boolean delUser(Integer id);

}
