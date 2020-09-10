package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {

    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;
    @TableField("user_name")
    private String userName;
    @TableField("login_id")
    private String loginId;
    @TableField("login_pwd")
    private String loginPwd;

}
