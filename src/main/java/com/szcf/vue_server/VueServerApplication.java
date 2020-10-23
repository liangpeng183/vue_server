package com.szcf.vue_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.szcf.vue_server.mapper")
@EnableCaching   // 启用缓存机制
public class VueServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueServerApplication.class, args);
        System.out.println("vue后台服务器启动。。。。");
    }

}
