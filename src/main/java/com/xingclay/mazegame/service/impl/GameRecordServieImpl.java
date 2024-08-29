package com.xingclay.mazegame.service.impl;

import com.xingclay.mazegame.entity.GameRecord;
import com.xingclay.mazegame.mapper.GameRecordMapper;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.GameRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameRecordServieImpl implements GameRecordService {

    @Autowired
    private GameRecordMapper gameRecordMapper;

    @Override
    public Result upload(GameRecord record) {
        if (record == null) {
            return Result.error(400, "无效的游戏记录");
        }

        int insertResult = gameRecordMapper.insert(record);
        if (insertResult > 0) {
            return Result.success("游戏记录上传成功");
        } else {
            return Result.error(500, "游戏记录上传失败");
        }
    }


    @Override
    public Result update(Integer id, GameRecord record) {
        return Result.success("更新成功");
    }
}
