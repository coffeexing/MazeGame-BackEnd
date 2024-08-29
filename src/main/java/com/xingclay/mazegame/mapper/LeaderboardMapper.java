package com.xingclay.mazegame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingclay.mazegame.domain.LeaderboardDTO;
import com.xingclay.mazegame.entity.Leaderboard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LeaderboardMapper extends BaseMapper<Leaderboard> {

    @Delete("DELETE FROM leaderboards")
    void deleteAll();

    @Select("SELECT l.ranking, u.username, l.score, gr.completion_time AS completionTime " +
            "FROM leaderboards l " +
            "JOIN users u ON l.user_id = u.user_id " +
            "JOIN game_records gr ON l.user_id = gr.user_id " +
            "ORDER BY l.ranking ASC " +
            "LIMIT 5")
    List<LeaderboardDTO> selectTopFiveLeaderboard();

}
