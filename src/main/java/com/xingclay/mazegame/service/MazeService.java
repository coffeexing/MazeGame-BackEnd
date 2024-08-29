package com.xingclay.mazegame.service;

import com.xingclay.mazegame.entity.Maze;
import com.xingclay.mazegame.pojo.Result;

public interface MazeService {
    Result update(Integer id, Maze maze);

    Result<String> getMap(Integer id);
}
