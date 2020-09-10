package com.xtkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtkj.dao.RecordUserMapper;
import com.xtkj.pojo.RecordUser;
import com.xtkj.service.IRecordUserService;
import org.springframework.stereotype.Service;

@Service
public class RecordUserServiceImpl extends ServiceImpl<RecordUserMapper, RecordUser> implements IRecordUserService {
}
