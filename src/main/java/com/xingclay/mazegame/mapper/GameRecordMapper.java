package com.xingclay.mazegame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingclay.mazegame.entity.GameRecord;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GameRecordMapper extends BaseMapper<GameRecord> {

    @Select("SELECT user_id, MAX(score) as score FROM game_records GROUP BY user_id ORDER BY score DESC LIMIT 5")
    List<GameRecord> selectTopFiveByScore();

}
