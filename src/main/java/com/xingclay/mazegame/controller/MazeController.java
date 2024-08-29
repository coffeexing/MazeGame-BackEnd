package com.xingclay.mazegame.controller;

import com.xingclay.mazegame.entity.Maze;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.MazeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MazeController {

    @Autowired
    private MazeService mazeService;

    @PostMapping("/maze/{id}/update")
    private Result update(@PathVariable("id") Integer id, @ModelAttribute Maze maze) {
        return mazeService.update(id, maze);
    }
}
