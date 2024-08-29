package com.xingclay.mazegame.controller;

import com.xingclay.mazegame.domain.LeaderboardDTO;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @PostMapping("/leaderboard/update")
    public Result updateLeaderboard() {
        return leaderboardService.update();
    }

    @PostMapping("/leaderboard")
    public Result<List<LeaderboardDTO>> getLeaderboard() {
        return leaderboardService.get();
    }

}
