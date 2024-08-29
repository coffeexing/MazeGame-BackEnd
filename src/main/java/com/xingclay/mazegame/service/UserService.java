package com.xingclay.mazegame.service;

import com.xingclay.mazegame.domain.LoginUser;
import com.xingclay.mazegame.entity.User;
import com.xingclay.mazegame.pojo.Result;

public interface UserService {
    Result<String> login(LoginUser user);

    Result<String> register(LoginUser user);

    Result<String> update(Integer id, User user);

    Result freeze(Integer id);

    Result unfreeze(Integer id);
}
