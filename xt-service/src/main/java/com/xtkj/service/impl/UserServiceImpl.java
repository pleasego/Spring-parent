package com.xtkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.dao.UserMapper;
import com.xtkj.pojo.RecordUser;
import com.xtkj.pojo.User;
import com.xtkj.service.IRecordUserService;
import com.xtkj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private IRecordUserService iRecordUserService;


    @Transactional
    @Override
    public boolean delUser(Integer id) {
        User user = getById(id);
        boolean b = removeById(id);
        RecordUser recordUser = new RecordUser();
        recordUser.setUserId(user.getUserId());
        recordUser.setUserName(user.getUserName());
        recordUser.setLoginId(user.getLoginId());
        recordUser.setLoginPwd(user.getLoginPwd());
        boolean save = iRecordUserService.save(recordUser);
        return save;
    }
}
