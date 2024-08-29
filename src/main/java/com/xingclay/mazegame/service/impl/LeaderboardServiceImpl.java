package com.xingclay.mazegame.service.impl;

import com.xingclay.mazegame.domain.LeaderboardDTO;
import com.xingclay.mazegame.entity.GameRecord;
import com.xingclay.mazegame.entity.Leaderboard;
import com.xingclay.mazegame.mapper.GameRecordMapper;
import com.xingclay.mazegame.mapper.LeaderboardMapper;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    @Autowired
    private GameRecordMapper gameRecordMapper;

    @Autowired
    private LeaderboardMapper leaderboardMapper;

    @Override
    public Result update() {
        List<GameRecord> topRecords = gameRecordMapper.selectTopFiveByScore();

        if (topRecords == null || topRecords.isEmpty()) {
            return Result.error(500, "没有找到符合条件的游戏记录");
        }

        leaderboardMapper.deleteAll();

        int ranking = 1;
        for (GameRecord record : topRecords) {
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.setUserId(record.getUserId());
            leaderboard.setScore(record.getScore());
            leaderboard.setRanking(ranking++);
            leaderboard.setUpdateDate(LocalDateTime.now());
            leaderboard.setStatus(1);

            leaderboardMapper.insert(leaderboard);
        }

        return Result.success("排行榜更新成功");
    }


    @Override
    public Result<List<LeaderboardDTO>> get() {
        List<LeaderboardDTO> leaderboard = leaderboardMapper.selectTopFiveLeaderboard();

        if (leaderboard == null || leaderboard.isEmpty()) {
            return Result.error(404, "没有找到排行榜数据");
        }

        return Result.success(leaderboard);
    }
}
