package com.xingclay.mazegame.domain;

import lombok.Data;

@Data
public class LeaderboardDTO {
    private Integer ranking;
    private String username;
    private Integer score;
    private String completionTime;
}

