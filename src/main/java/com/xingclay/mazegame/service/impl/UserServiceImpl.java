package com.xingclay.mazegame.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xingclay.mazegame.domain.LoginUser;
import com.xingclay.mazegame.entity.RoleUser;
import com.xingclay.mazegame.entity.User;
import com.xingclay.mazegame.mapper.RoleUserMapper;
import com.xingclay.mazegame.mapper.UserMapper;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public Result<Integer> login(LoginUser user) {
        String username = user.getUsername();
        String password = user.getPassword();
        int role = user.getRole();

        LambdaQueryWrapper<User> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(User::getUsername, username);
        User queryUser = userMapper.selectOne(queryWrapper1);

        if (queryUser == null) {
            register(user);
            return Result.error(201, "注册成功");
        }

        if (!BCrypt.checkpw(password, queryUser.getPassword())) {
            return Result.error(401, "登录失败");
        }

        LambdaQueryWrapper<RoleUser> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(RoleUser::getUserId, queryUser.getUserId());
        RoleUser queryRole = roleUserMapper.selectOne(queryWrapper2);

        if (role != queryRole.getRoleId()) {
            return Result.error(403, "授权失败");
        }

        Integer id = queryUser.getUserId();

        return Result.success("登录成功", id);
    }

    @Override
    public Result<String> register(LoginUser user) {
        String username = user.getUsername();
        String password = user.getPassword();
        int role = user.getRole();

        LambdaQueryWrapper<User> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(User::getUsername, username);
        User queryUser = userMapper.selectOne(queryWrapper1);

        if (queryUser != null) {
            return Result.error(501, "用户已存在");
        }

        String saltedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(saltedPassword);
        newUser.setCreateDate(LocalDateTime.now());
        newUser.setUpdateDate(LocalDateTime.now());
        Integer rows = userMapper.insert(newUser);

        if (rows == 0) {
            return Result.error(501, "注册失败");
        }

        LambdaQueryWrapper<User> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(User::getUsername, username);
        queryUser = userMapper.selectOne(queryWrapper2);

        RoleUser roleUser = new RoleUser();
        roleUser.setRoleId(role);
        roleUser.setUserId(queryUser.getUserId());
        rows = roleUserMapper.insert(roleUser);

        if (rows == 0) {
            return Result.error(501, "注册失败");
        }

        return Result.success("注册成功", null);
    }

    @Override
    public Result<String> update(Integer id, User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", id);

        if (!user.getPassword().isEmpty()) {
            String password = user.getPassword();
            String saltedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setPassword(saltedPassword);
        }

        user.setUpdateDate(LocalDateTime.now());

        Integer rows = userMapper.update(user, updateWrapper);

        if (rows == 0) {
            return Result.error(501, "修改失败");
        }

        return Result.success("修改成功", null);
    }

    @Override
    public Result freeze(Integer id) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", id);
        User user = new User();
        user.setStatus(0);
        user.setUpdateDate(LocalDateTime.now());

        Integer rows = userMapper.update(user, updateWrapper);

        if (rows == 0) {
            return Result.error(501, "冻结失败");
        }

        return Result.success("冻结成功", null);
    }

    @Override
    public Result unfreeze(Integer id) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", id);
        User user = new User();
        user.setStatus(1);
        user.setUpdateDate(LocalDateTime.now());

        Integer rows = userMapper.update(user, updateWrapper);

        if (rows == 0) {
            return Result.error(501, "解冻失败");
        }

        return Result.success("解冻成功", null);
    }
}
