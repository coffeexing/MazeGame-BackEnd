package com.xingclay.mazegame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("leaderboards")
public class Leaderboard {
    @TableId(value = "leaderboard_id", type = IdType.AUTO)
    private Integer leaderboardId;
    private Integer userId;
    private Integer score;
    private Integer ranking;
    private LocalDateTime updateDate;
    private Integer status;
}

