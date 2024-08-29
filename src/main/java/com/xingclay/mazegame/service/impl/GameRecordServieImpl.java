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
        int row = gameRecordMapper.insert(record);
        if (row == 0) {
            return Result.error(501, "上传游戏记录失败");
        }

        return Result.success("上传成功", null);
    }

    @Override
    public Result update(Integer id, GameRecord record) {
        return null;
    }
}
