package com.xingclay.mazegame.service.impl;

import com.xingclay.mazegame.entity.Maze;
import com.xingclay.mazegame.mapper.MazeMapper;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.MazeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MazeServiceImpl implements MazeService {

    @Autowired
    private MazeMapper mazeMapper;

    @Override
    public Result update(Integer id, Maze maze) {
        if (id == null || maze == null) {
            return Result.error(500, "ID或迷宫对象不能为空");
        }

        Maze existingMaze = mazeMapper.selectById(id);
        if (existingMaze == null) {
            return Result.error(500, "迷宫不存在");
        }

        existingMaze.setMazeStructure(maze.getMazeStructure());
        existingMaze.setCreateDate(LocalDateTime.now());

        int updateResult = mazeMapper.updateById(existingMaze);
        if (updateResult > 0) {
            return Result.success("迷宫更新成功");
        } else {
            return Result.error(500, "迷宫更新失败");
        }
    }

    @Override
    public Result<String> getMap(Integer id) {
        if (id == null) {
            return Result.error(500, "迷宫ID不能为空");
        }

        Maze maze = mazeMapper.selectById(id);
        if (maze == null) {
            return Result.error(500, "未找到对应的迷宫");
        }

        String mapStructure = maze.getMazeStructure();
        if (mapStructure == null || mapStructure.isEmpty()) {
            return Result.error(500, "迷宫结构为空");
        }

        return Result.success(200, "success", mapStructure);
    }

}
