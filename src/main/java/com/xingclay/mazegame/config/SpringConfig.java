package com.xingclay.mazegame.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xingclay.mazegame")
@MapperScan("com.xingclay.mazegame.mapper")
public class SpringConfig {
}
