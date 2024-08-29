package com.xingclay.mazegame;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingclay.mazegame.domain.LoginUser;
import com.xingclay.mazegame.entity.User;
import com.xingclay.mazegame.mapper.UserMapper;
import com.xingclay.mazegame.pojo.Result;
import com.xingclay.mazegame.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyMazeGameApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@Test
	public void loginTest() {

		LoginUser user = new LoginUser("xing", "123456", 1);

		Result result = userService.login(user);

		System.out.println(result);
	}

	@Test
	public void registerTest() {
		LoginUser user = new LoginUser("xing", "123456", 1);

		Result<String> result = userService.register(user);

		System.out.println(result);
	}

	@Test
	public void updateTest() {
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(User::getUserId, 1);
		User queryUser = userMapper.selectOne(queryWrapper);

		queryUser.setUsername("x");

		Result<String> result = userService.update(1, queryUser);

		System.out.println(result);
	}

}
