package com.xingclay.mazegame.controller;

import com.xingclay.mazegame.entity.GameRecord;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.GameRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRecordController {

    @Autowired
    private GameRecordService gameRecordService;

    @PostMapping("/upload")
    public Result uploadRecord(@ModelAttribute GameRecord record) {
        return gameRecordService.upload(record);
    }

    @PostMapping("/record/{id}/update")
    public Result update(@PathVariable(name = "id") Integer id, @ModelAttribute GameRecord record) {
        return gameRecordService.update(id, record);
    }

}
