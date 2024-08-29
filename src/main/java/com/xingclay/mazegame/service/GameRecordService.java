package com.xingclay.mazegame.service;

import com.xingclay.mazegame.entity.GameRecord;
import com.xingclay.mazegame.pojo.Result;

public interface GameRecordService {
    Result upload(GameRecord record);

    Result update(Integer id, GameRecord record);
}
