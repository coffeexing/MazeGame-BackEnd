package com.xingclay.mazegame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("game_records")
public class GameRecord {
    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;
    private Integer userId;
    private Integer mazeId;
    private Float completionTime;
    private Integer score;
    private Date gameData;
}

