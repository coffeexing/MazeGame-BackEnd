package com.xingclay.mazegame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("mazes")
public class Maze {
    @TableId(value = "maze_id", type = IdType.AUTO)
    private Integer mazeId;
    private Integer mazeType;
    private String mazeStructure;
    private Date createDate;
    private Integer status;
}

