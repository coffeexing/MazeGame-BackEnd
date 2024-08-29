package com.xingclay.mazegame.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("role_user")
public class RoleUser {
    private Integer roleId;
    private Integer userId;
}

