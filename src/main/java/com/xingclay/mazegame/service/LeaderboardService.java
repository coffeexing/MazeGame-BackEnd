package com.xingclay.mazegame.service;

import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.domain.LeaderboardDTO;

import java.util.List;

public interface LeaderboardService {
    Result update();

    Result<List<LeaderboardDTO>> get();
}
