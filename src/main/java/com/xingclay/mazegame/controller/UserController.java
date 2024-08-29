package com.xingclay.mazegame.controller;

import com.xingclay.mazegame.domain.LoginUser;
import com.xingclay.mazegame.entity.User;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<Integer> login(@ModelAttribute LoginUser user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public Result<String> register(@ModelAttribute LoginUser user) {
        return userService.register(user);
    }

    @PostMapping("/user/{id}/update")
    public Result<String> update(@PathVariable(name = "id") Integer id, @ModelAttribute User user) {
        return userService.update(id, user);
    }

    @PostMapping("/user/{id}/freeze")
    public Result freeze(@PathVariable(name = "id") Integer id) {
        return userService.freeze(id);
    }

    @PostMapping("/user/{id}/unfreeze")
    public Result unfreeze(@PathVariable(name = "id") Integer id) {
        return userService.unfreeze(id);
    }
}
